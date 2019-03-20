package model;

import java.util.Date;
import java.util.List;

public class Member {
	private long id;
	private String username;
	private String password;
	private String email;
	private byte gender;
	private String tel;
	private String address;
	private Date dated;
	private List<Role> roles;
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte getGender() {
		return gender;
	}
	public void setGender(byte gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public Member(long id, String username, String password, String email, byte gender, String tel, String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.tel = tel;
		this.address = address;
	}
	public Member() {
		super();
	}
	
}
