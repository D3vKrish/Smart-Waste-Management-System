package models;
public class CollectionStaff extends User {
    String location;
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

    public void showDashboard() {
        System.out.println("Restricted staff access granted to user: "+this.username);
        System.out.println("Staff Dashboard: Operational updates and schedules.");
    }

    public String getLocation() { 
        return this.location; 
    }
}