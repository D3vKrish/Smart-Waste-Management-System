package models;
public class CollectionStaff extends User {
    String location;
    /**
     * Constructor for CollectionStaff
     * @param username: Unique identifier for the staff member
     * @param location: Zone of operation (A, B, C) which maps to specific campus locations
     */
    public CollectionStaff(String username, String location) { 
        super(username, "Staff"); 
        switch(location.toUpperCase()) {
            case "A": 
                this.location = "BITS Pilani, Goa Campus"; 
                break;
            case "B": 
                this.location = "BITS Pilani, Hyderabad Campus"; 
                break;
            case "C": 
                this.location = "BITS Pilani, Pilani Campus"; 
                break;
            default: this.location = "Unknown Zone";
        }
    }

    /**
     * Displays the staff dashboard.
     * Access is restricted to staff members only.
     */
    public void showDashboard() {
        System.out.println("Restricted staff access granted to user: "+this.username);
        System.out.println("Staff Dashboard: Operational updates and schedules.");
    }

    /**
     * Getter for the staff member's location.
     */
    public String getLocation() { 
        return this.location; 
    }
}