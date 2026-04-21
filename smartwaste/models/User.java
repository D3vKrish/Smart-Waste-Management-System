package models;
public abstract class User {
    // Common attributes for all users
    protected String username;
    String role;

    /**
     * Constructor for User class
     * @param username: The username of the user
     * @param role: The role of the user
     */
    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    /**
     * Abstract method to show the dashboard for the user. 
     * This will be implemented by subclasses.
     */
    public abstract void showDashboard();

    /**
     * Getters for username and role
     */
    public String getRole() { 
        return role; 
    }
    public String getUsername() { 
        return username; 
    }
}



