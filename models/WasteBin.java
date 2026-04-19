package smartwaste.models;

import java.util.ArrayList;

public class WasteBin {
    private String binId;
    private String type; 
    private Double capacity; // Wrapper
    private Double currentLevel;
    private Boolean isDamaged; // Wrapper
    
    private ArrayList<MaintenanceLog> maintenanceHistory = new ArrayList<>();

    // Nested Class
    public class MaintenanceLog {
        String date;
        String issue;
        public MaintenanceLog(String date, String issue) {
            this.date = date;
            this.issue = issue;
        }
        public String getLog() { return date + ": " + issue; }
    }

    // Overloaded Constructor 1
    public WasteBin(String binId, String type, Double capacity) {
        this.binId = binId;
        this.type = type;
        this.capacity = capacity;
        this.currentLevel = 0.0;
        this.isDamaged = false;
    }

    // Overloaded Constructor 2
    public WasteBin(String binId, String type, Double capacity, Double currentLevel) {
        this(binId, type, capacity);
        this.currentLevel = currentLevel;
    }

    public void addWaste(Double amount) throws BinOverflowException {
        if (this.currentLevel + amount > this.capacity) {
            throw new BinOverflowException("Bin " + binId + " is overflowing!");
        }
        this.currentLevel += amount;
    }

    public void emptyBin() { this.currentLevel = 0.0; }
    
    public void addMaintenanceRecord(String date, String issue) {
        maintenanceHistory.add(new MaintenanceLog(date, issue));
        this.isDamaged = true;
    }

    // Getters
    public String getBinId() { return binId; }
    public String getType() { return type; }
    public Double getCapacity() { return capacity; }
    public Double getCurrentLevel() { return currentLevel; }
    public Boolean getStatus() { return currentLevel >= capacity; } 
}