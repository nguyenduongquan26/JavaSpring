package model;

import java.util.Date;
import java.util.List;

public class Invoice {
	private String id;
	private String email;
	private String tel;
	private String address;
	private byte status;
	private Date dated;
	private String statusName;
	private int total;
	private int totalQuantity;
	public Invoice(String id, String email, String tel, String address, byte status, Date dated, String statusName,
			int total, int totalQuantity) {
		super();
		this.id = id;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.dated = dated;
		this.statusName = statusName;
		this.total = total;
		this.totalQuantity = totalQuantity;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	private List<InvoiceDetail> details;
	
	public List<InvoiceDetail> getDetails() {
		return details;
	}
	public void setDetails(List<InvoiceDetail> details) {
		this.details = details;
	}
	public Invoice(String id, String email, String tel, String address, byte status, Date dated) {
		super();
		this.id = id;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.dated = dated;
	}
	public Invoice(String id, String email, String tel, String address) {
		super();
		this.id = id;
		this.email = email;
		this.tel = tel;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public Invoice() {
		super();
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
}
