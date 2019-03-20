package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

public class AuthorRepository extends Repository {
	
	public int[] delete(int arr[]) {
		return jdbc.batchUpdate("DELETE FROM Author WHERE AuthorId = ?", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement prepareStament, int index) throws SQLException {
				prepareStament.setInt(1, arr[index]);
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return arr.length;
			}
		});
	}
	
	
	public Author getAuthors(int id){
		return jdbc.queryForObject("SELECT * FROM Author WHERE AuthorId = ?", new RowMapper<Author>() {

			@Override
			public Author mapRow(ResultSet rs, int index) throws SQLException {
				
				return new Author(rs.getInt("AuthorId"),rs.getString("AuthorName"));
			}
			
		},id);
	}
	public int edit(Author obj) {
		return jdbc.update("UPDATE Author SET AuthorName = ? WHERE AuthorId = ?",obj.getName(),obj.getId());
	}
	public List<Author> getAuthors(){
		return jdbc.query("SELECT * FROM Author", new RowMapper<Author>() {

			@Override
			public Author mapRow(ResultSet rs, int index) throws SQLException {
				
				return new Author(rs.getInt("AuthorId"),rs.getString("AuthorName"));
			}
			
		});
	}
	public int add(Author obj) {
		return jdbc.update("INSERT INTO Author(AuthorName) VALUES(?)",obj.getName());
	}
	public int delete(int id) {
		return jdbc.update("DELETE FROM Author WHERE AuthorId = ?",id);
	}
}
