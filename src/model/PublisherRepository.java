package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.jdbc.core.RowMapper;

public class PublisherRepository extends Repository {
	
	private static class PublisherMapper implements RowMapper<Publisher> {

		@Override
		public Publisher mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			return new Publisher(rs.getInt("PublisherId"),rs.getString("PublisherName"));
		}

	}
	
	
	public List<Publisher> getPublisher(){
		return jdbc.query("SELECT * FROM Publisher", new  PublisherMapper());
	}
	
	
	public Publisher getPublisher(int id) {
		return jdbc.queryForObject("SELECT * FROM Publisher WHERE PublisherId = ?", new PublisherMapper(),id);
		
	}
	
	public int add(Publisher obj) {
		return jdbc.update("INSERT INTO Publisher(PublisherName) VALUES(?)", obj.getName()); 
	}
	
	public int edit(Publisher obj) {
		return jdbc.update("UPDATE Publisher SET PublisherName = ? WHERE PublisherId = ?", obj.getName(),obj.getId()); 
	}
	
	
	public int delete(int id) {
		return jdbc.update("DELETE FROM Publisher WHERE PublisherId = ?",id);
	}
	
	
}
