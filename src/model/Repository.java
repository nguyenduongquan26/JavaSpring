package model;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Repository {
	protected JdbcTemplate jdbc;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	public Repository() {
		DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/minishop?userUnicode=true&characterEncoding=UTF-8","root","");
		jdbc = new JdbcTemplate(dataSource);
	}
	
}
