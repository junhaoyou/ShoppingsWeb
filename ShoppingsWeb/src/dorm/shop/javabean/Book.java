package dorm.shop.javabean;

public class Book {
	private String shopName;
	private String id;
	private String author;
	private double price;
	
	public Book(String id,String shopName,String author,double price) {
		this.id=id;
		this.shopName=shopName;
		this.author=author;
		this.price=price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return shopName;
	}
	public void setName(String shopName) {
		this.shopName =shopName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
