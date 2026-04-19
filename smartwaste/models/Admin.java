package models;
public class Admin extends User {
    public Admin(String username) { 
        super(username, "Administrator"); 
    }

    public void showDashboard() {
        System.out.println("Admin Dashboard: Full management access granted.");
    }
}