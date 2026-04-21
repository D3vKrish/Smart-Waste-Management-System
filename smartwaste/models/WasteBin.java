package models;

public class WasteBin {
    // Attributes
    String binId;
    String type; 
    Double capacity; 
    Double currentLevel;
    Boolean isDamaged; 
    String location;
    
    // Maintenance history log
    MaintenanceLog[] maintenanceHistory = new MaintenanceLog[10];
    int logCount = 0;

    /**
     * Inner class to represent maintenance logs for the waste bin. 
     * Each log entry contains a date and a description of the issue.
     */
    public class MaintenanceLog {
        String date;
        String issue;
        /**
         * Constructor for MaintenanceLog
         * @param date
         * @param issue
         */
        public MaintenanceLog(String date, String issue) {
            this.date = date;
            this.issue = issue;
        }

        /**
         * Returns a formatted string representation of the maintenance log entry.
         * @return
         */
        public String getLog() { 
            return date + ": " + issue; 
        }
    }
    
    /**
     * Constructor for WasteBin
     * @param binId: Unique identifier for the waste bin.
     * @param type: Type of waste the bin 
     * @param capacity: Maximum capacity of the waste bin in liters.
     * @param location: Physical location of the waste bin   */
    public WasteBin(String binId, String type, Double capacity, String location) {
        this.binId = binId;
        this.type = type;
        this.capacity = capacity;
        this.currentLevel = 0.0;
        this.isDamaged = false;
        this.location=location;
    }
    
    /**
     * Overloaded constructor for WasteBin that allows setting the initial current level 
     * of waste in the bin.
     * @param binId
     * @param type
     * @param capacity
     * @param currentLevel
     * @param location
     */
    public WasteBin(String binId, String type, Double capacity, Double currentLevel, String location) {
        this.binId = binId;
        this.type = type;
        this.capacity = capacity;
        this.location = location;
        this.currentLevel = currentLevel;
    }

    /**
     * Adds waste to the bin. If the added amount exceeds the bin's capacity, a 
     * BinOverflowException is thrown.
     * @param amount
     * @throws BinOverflowException
     */
    public void addWaste(Double amount) throws BinOverflowException {
        if (this.currentLevel + amount > this.capacity) {
            throw new BinOverflowException("Bin " + this.binId + " is overflowing!"); 
        }
        this.currentLevel += amount;
    }

    /**
     * Empties the waste bin by resetting the current level to zero.
     */
    public void emptyBin() { 
        this.currentLevel = 0.0; 
    }

    /**
     * Adds a maintenance record to the bin's maintenance history. 
     * @param issue
     */
    public void addMaintenanceRecord(String issue) {
        addMaintenanceRecord("Unknown Date", issue);
    }

    /**
     * Overloaded method to add a maintenance record with a specific date and issue 
     * description.
     * @param date
     * @param issue
     */
    public void addMaintenanceRecord(String date, String issue) {
        if (logCount < maintenanceHistory.length) {
            maintenanceHistory[logCount++] = new MaintenanceLog(date, issue);
            this.isDamaged = true;
        } else 
            System.out.println("Maintenance log is full for bin: " + binId);
        
    }

    /**
     * Overloaded method to add multiple maintenance records at once, allowing for
     * multiple issues to be logged on the same date.
     * @param date
     * @param issues
     */
    public void addMaintenanceRecord(String date, String... issues) {
        for (String issue: issues) {
            addMaintenanceRecord(date, issue); 
        }
    }

    /**
     * Checks if the waste bin is empty by verifying if the current level of waste
     */
    public boolean isEmpty() { 
        return this.currentLevel == 0.0; 
    }

    // Getters for the waste bin attributes
    public String getBinId() {
        return binId; 
    }

    public String getType() { 
        return type; 
    }

    public Double getCapacity() { 
        return capacity; 
    }

    public Double getCurrentLevel() { 
        return currentLevel; 
    }
    
    public Boolean getIsDamaged() { 
        return isDamaged; 
    }
    
    public Boolean getStatus() { 
        return currentLevel >= capacity; 
    } 
    
    public String getLocation() {
        return location;
    }
}
