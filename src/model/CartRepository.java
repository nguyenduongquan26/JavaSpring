package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class CartRepository extends Repository {
	public int add(Cart obj) {
		//return jdbc.update("INSERT INTO Cart(CartId , ProductId, Quantity) VALUES(?,?,?)",obj.getId(),obj.getProductId(),obj.getQuantity());
		return jdbc.update("CALL AddCart(?,?,?)",obj.getId(),obj.getProductId(),obj.getQuantity());
		
	}
	public List<Cart> getCarts(String id){
		return jdbc.query("SELECT * FROM Cart INNER JOIN Product ON Cart.ProductId = Product.ProductId WHERE CartId = ?", new RowMapper<Cart>() {

			@Override
			public Cart mapRow(ResultSet rs, int index) throws SQLException {
				
				return new Cart(rs.getString("CartId"),rs.getInt("ProductId"),rs.getShort("Quantity"),rs.getString("Title"),
						rs.getInt("Price"));
			}
		},id);
	}
	public int edit(Cart obj) {
		String sql = "UPDATE Cart SET Quantity = ? WHERE CartId = ? AND ProductId = ?";
		return jdbc.update(sql,obj.getQuantity(), obj.getId(),obj.getProductId());
	}
}
