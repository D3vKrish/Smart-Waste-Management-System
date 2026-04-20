package models;
import management.*;
public class Admin extends User {
    public Admin(String username) { 
        super(username, "Administrator"); 
    }   

    public void showDashboard() {
        System.out.println("Complete admin access granted to user: "+this.username);
    }

    public void generateFullReport(Reportable engine) {
        System.out.println("\n[SECURE ACCESS] Generating System-Wide Analytics...");
        engine.generateSummary();
    }
}