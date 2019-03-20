package model;

public class InvoiceDetail {
	private String invoiceId;
	private int productId;
	private short quantity;
	private int price;
	private String title;
	private String imageUrl;
	
	public InvoiceDetail() {
		
	}
	public InvoiceDetail(String invoiceId, int productId, short quantity, int price, String title, String imageUrl) {
		
		this.invoiceId = invoiceId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.title = title;
		this.imageUrl = imageUrl;
	}
	public InvoiceDetail(String invoiceId, int productId, short quantity, int price) {
		
		this(invoiceId,productId,quantity,price,null,null);
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public short getQuantity() {
		return quantity;
	}
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
