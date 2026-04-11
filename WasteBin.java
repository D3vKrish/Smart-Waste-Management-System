package smartwaste;

import java.util.ArrayList;

class WasteBin {
    private String binId;
    private String type; // organic, recyclable, hazardous 
    private Double capacity; // Requirement 11: Wrapper class 
    private Double currentLevel;
    private Boolean isDamaged; // Requirement 11: Wrapper class 
    
    // Requirement 1: Non-static Nested Class 
    private ArrayList<MaintenanceLog> maintenanceHistory = new ArrayList<>();

    class MaintenanceLog {
        String date;
        String issue;
        public MaintenanceLog(String date, String issue) {
            this.date = date;
            this.issue = issue;
        }
        public String getLog() { return date + ": " + issue; }
    }

    // Requirement 9: Overloaded Constructors (Minimum 2) 
    public WasteBin(String binId, String type, Double capacity) {
        this.binId = binId;
        this.type = type;
        this.capacity = capacity;
        this.currentLevel = 0.0;
        this.isDamaged = false;
    }

    // Overloaded Constructor for a bin that starts partially full
    public WasteBin(String binId, String type, Double capacity, Double currentLevel) {
        this(binId, type, capacity);
        this.currentLevel = currentLevel;
    }

    public void addWaste(Double amount) throws BinOverflowException {
        if (this.currentLevel + amount > this.capacity) {
            throw new BinOverflowException("Bin " + binId + " is overflowing!"); [cite: 140]
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
    public Boolean getStatus() { return currentLevel >= capacity; } // full status 
}