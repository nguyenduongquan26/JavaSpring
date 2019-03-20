package model;

public class Cart {
	private String id;
	private int productId;
	private short quantity;
	private String title;
	private int price;
	
	
	public Cart(String id, int productId, short quantity, String title, int price) {
		
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.title = title;
		this.price = price;
	}
	public Cart() {
		
	}
	public Cart(String id, int productId, short quantity) {
		
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
