package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

public class InvoiceRepository extends Repository{

	
	public int add(Invoice obj) {
		return jdbc.update("CALL addBill(?, ?, ?, ?)",obj.getId(),obj.getEmail(),obj.getTel(),obj.getAddress());
	}
	
	
	public int add2(Invoice obj) {
		int ret = jdbc.update("INSERT INTO Invoice (InvoiceId, Email, Tel, Address) VALUES(?, ?, ?, ?)",obj.getId(),obj.getEmail(),obj.getTel(),obj.getAddress());
		add(obj.getDetails());
		return ret;
	}
	
	public int[] add(List<InvoiceDetail> list) {
		return jdbc.batchUpdate("INSERT INTO InvoiceDetail(InvoiceId, ProductId, Price, Quantity) VALUES(?, ?, ?, ?)",new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement prst, int index) throws SQLException {
				// TODO Auto-generated method stub
				InvoiceDetail obj = list.get(index);
				prst.setString(1, obj.getInvoiceId());
				prst.setInt(2, obj.getProductId());
				prst.setInt(3, obj.getPrice());
				prst.setShort(4, obj.getQuantity());
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
	}
	
	public Invoice getInvoice(String id) {
		Invoice obj =  jdbc.queryForObject("SELECT * FROM Invoice WHERE InvoiceId =?", new RowMapper<Invoice>() {

			@Override
			public Invoice mapRow(ResultSet rs, int arg1) throws SQLException {
				
				return new Invoice(rs.getString("InvoiceId"),
						rs.getString("Email"),
						rs.getString("Tel"),
						rs.getString("Address"),
						rs.getByte("StatusId"),
						rs.getDate("AddedDate"));
			}
			
		},id);
		obj.setDetails(getInvoiceDetails(id));
		return obj;
	}
	
	
	public List<InvoiceDetail> getInvoiceDetails(String id){
		return jdbc.query("CALL GetBillDetails(?) ", new RowMapper<InvoiceDetail>() {

			@Override
			public InvoiceDetail mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new InvoiceDetail(rs.getString("InvoiceId"),
						rs.getInt("ProductId"),
						rs.getShort("Quantity"),
						rs.getInt("Price"),
						rs.getString("Title"),
						rs.getString("ImageUrl"));
			}
			
		},id);
	}
	
	
	
	public List<Invoice> getInvoices(){
		return jdbc.query("CALL GetInvoices()",new RowMapper<Invoice>() {

			@Override
			public Invoice mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new Invoice(rs.getString("InvoiceId"),
						rs.getString("Email"),
						rs.getString("Tel"),
						rs.getString("Address"),
						rs.getByte("StatusId"),
						rs.getDate("AddedDate"),
						rs.getString("StatusName"),
						rs.getInt("Total"),
						rs.getInt("TotalQuantity"));
			}
			
		});
	}
	
	
	
}
