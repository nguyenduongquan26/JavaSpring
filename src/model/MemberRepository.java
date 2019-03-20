package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import ulti.Helper;

public class MemberRepository extends Repository {
	public int add(Member obj) {
		return jdbc.update("CALL AddMember(?, ?, ?, ?, ?, ?, ?)",obj.getId(),obj.getUsername(),Helper.brypt(obj.getPassword()),obj.getEmail(),obj.getGender(),obj.getTel(),obj.getAddress());
	}

	
	public Member logOn(String username) {
		Member obj = jdbc.queryForObject("SELECT * FROM Member WHERE Username = ?", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int arg1) throws SQLException {
				
				return new Member(rs.getLong("MemberId"),
						rs.getString("Username"),
						rs.getString("Password"),
						rs.getString("Email"),
						rs.getByte("Gender"),
						rs.getString("Tel"),
						rs.getString("Address"));
			}
			
		},username);
		obj.setRoles(getRolesByMemberId(obj.getId()));
		return obj;
	}
	public List<Role> getRolesByMemberId(long memberId){
		
		return jdbc.query("CALL GetRolesByMemberId(?)", new RowMapper<Role>() {

			@Override
			public Role mapRow(ResultSet rs, int arg1) throws SQLException {
				
				return new Role(rs.getInt("RoleId"), rs.getString("RoleName"));
			}
			
		},memberId);
		
	}
}
