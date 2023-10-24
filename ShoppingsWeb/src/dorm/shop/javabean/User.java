package dorm.shop.javabean;

public class User {
	private String username;
    private String shopPassword;

    public User() {
    }

    public User(String username, String shopPassword) {
        this.username = username;
        this.shopPassword = shopPassword;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return shopPassword;
	}

	public void setPassword(String ShopPassword) {
		this.shopPassword = ShopPassword;
	}
    
}
