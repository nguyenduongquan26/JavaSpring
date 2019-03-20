package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class ProductRepository extends Repository{
	private static class ProductMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int index) throws SQLException {
			
			return new Product(
					rs.getInt("ProductId"),
					rs.getInt("CategoryId"),
					rs.getString("ISBN"),
					rs.getString("Title"),
					rs.getShort("Pages"),
					rs.getShort("Year"),
					rs.getString("Weight"),
					rs.getString("Size"),
					rs.getString("Content"),
					rs.getString("ImageUrl"),
					rs.getString("Description"),
					rs.getInt("Price"));
		}
		
	}
	
	public Product getProduct(String isbn) {
		return jdbc.queryForObject("SELECT * FROM Product WHERE ISBN = ?", new ProductMapper(),isbn);
	}
	
	public List<Product> getProducts(int id){
		return jdbc.query("SELECT * FROM Product WHERE CategoryId = ?", new ProductMapper(),id);
	}
	
	
	public List<Product> getProducts(){
		return jdbc.query("SELECT * FROM Product", new ProductMapper());
		
	}
	
	
	
	public List<Product> search(String q){
		return jdbc.query("SELECT * FROM Product WHERE Title LIKE ?", new ProductMapper(),"%"+q+"%");
	}
	
	
	
	public Product getProduct(int id) {
		return jdbc.queryForObject("SELECT * FROM Product WHERE ProductId = ?", new ProductMapper(),id);
	}
	
	
	
	public int count() {
		return jdbc.queryForObject("SELECT COUNT(*) AS Total FROM Product", new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int index) throws SQLException {
				
				return rs.getInt("Total");
			}
		});
	}
	
	
	public List<Product> getProducts(int index,int pageSize){
		return jdbc.query("SELECT * FROM Product LIMIT ?,?", new ProductMapper(),index,pageSize);
		
	}
	
	public List<Product> getProductRelated(int productId, int categoryId){
		String sql = "SELECT * FROM Product WHERE CategoryId = ? AND ProductId != ?";
		return jdbc.query(sql, new ProductMapper(),categoryId, productId);
	}
	
	
}
