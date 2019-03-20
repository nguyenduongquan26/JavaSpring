package model;

import java.util.Date;

public class Wishlist {
	private String id;
	private int productId;
	private int viewed;
	private Date dated;
	private String title;
	private String imageUrl;
	public Wishlist(String id, int productId) {
		this(id,productId,0,null,null,null);
	}
	public Wishlist(String id, int productId, int viewed, Date dated, String title, String imageUrl) {
		super();
		this.id = id;
		this.productId = productId;
		this.viewed = viewed;
		this.dated = dated;
		this.title = title;
		this.imageUrl = imageUrl;
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
	public int getViewed() {
		return viewed;
	}
	public void setViewed(int viewed) {
		this.viewed = viewed;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
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
