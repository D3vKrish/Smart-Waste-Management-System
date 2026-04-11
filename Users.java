package smartwaste;

abstract class User {
    protected String username;
    protected String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public abstract void showDashboard();
    public String getRole() { return role; }
    public String getUsername() { return username; }
}

class Admin extends User {
    public Admin(String username) { super(username, "Administrator"); }

    @Override
    public void showDashboard() {
        System.out.println("Admin Dashboard: Full management access granted.");
    }
}

class CollectionStaff extends User {
    public CollectionStaff(String username) { super(username, "Staff"); }

    @Override
    public void showDashboard() {
        System.out.println("Staff Dashboard: Operational updates and schedules.");
    }
}