package model.user;

public class User {

  private int userId;
    private String username;
    private String password;
   

    public User(int userId, String username, String password) {
        
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    public User() {

    }

    

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

    
}
