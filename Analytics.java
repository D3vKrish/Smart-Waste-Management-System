package smartwaste;

class AnalyticsEngine implements Reportable, AlertSystem {
    private double totalRecyclableCollected = 0;
    private double totalNonRecyclableCollected = 0; // Track recyclable vs non-recyclable [cite: 137]

    public void recordCollection(WasteBin bin) {
        if (bin.getType().equalsIgnoreCase("recyclable")) {
            totalRecyclableCollected += bin.getCurrentLevel();
        } else {
            totalNonRecyclableCollected += bin.getCurrentLevel();
        }
        bin.emptyBin();
    }

    // Requirement 8: Overloaded Methods (Minimum 3) 
    public void printStats() {
        System.out.println("Total Waste: " + (totalRecyclableCollected + totalNonRecyclableCollected) + " kg");
    }

    public void printStats(String category) {
        if (category.equalsIgnoreCase("recyclable")) 
            System.out.println("Recyclable Collected: " + totalRecyclableCollected + " kg");
        else 
            System.out.println("Non-Recyclable Collected: " + totalNonRecyclableCollected + " kg");
    }

    public void printStats(boolean detailed) {
        if (detailed) {
            System.out.println("--- Detailed Environmental Impact ---"); [cite: 149]
            printStats("recyclable");
            printStats("organic");
            double efficiency = (totalRecyclableCollected / (totalRecyclableCollected + totalNonRecyclableCollected + 0.1)) * 100;
            System.out.println("Recycling Efficiency: " + String.format("%.2f", efficiency) + "%"); [cite: 146]
        } else {
            printStats();
        }
    }

    // Requirement 10: Vararg overloading (Minimum 1) 
    public void logMissedPickups(String... missedBinIds) {
        System.out.print("ALERT: Missed pickups for bins: "); [cite: 141]
        for (String id : missedBinIds) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    @Override
    public void generateSummary() { printStats(true); }

    @Override
    public void triggerAlert(String message, String severity) {
        System.out.println("[" + severity.toUpperCase() + " ALERT] " + message);
    }
}