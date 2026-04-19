package models;
public class CollectionStaff extends User {
    public CollectionStaff(String username) { super(username, "Staff"); }

    public void showDashboard() {
        System.out.println("Staff Dashboard: Operational updates and schedules.");
    }
}