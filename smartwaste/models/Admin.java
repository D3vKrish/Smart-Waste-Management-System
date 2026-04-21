package models;
import management.*;
public class Admin extends User {
    /**
     * Constructor for Admin user, inherits from User class with role set to Administrator
     * @param username
     */
    public Admin(String username) { 
        super(username, "Administrator"); 
    }   

    /**
     * Method to display the admin dashboard
     */
    public void showDashboard() {
        System.out.println("Complete admin access granted to user: "+this.username);
    }

    /**
     * Method to generate a full report using the provided Reportable engine
     * demonstrates the admin's ability to access detailed system analytics
     * @param engine
     */
    public void generateFullReport(Reportable engine) {
        System.out.println("\n[SECURE ACCESS] Generating System-Wide Analytics...");
        engine.generateSummary();
    }
}