package smartwaste.models;
public abstract class User {
    protected String username;
    public String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public abstract void showDashboard();
    public String getRole() { 
        return role; 
    }
    public String getUsername() { 
        return username; 
    }
}



