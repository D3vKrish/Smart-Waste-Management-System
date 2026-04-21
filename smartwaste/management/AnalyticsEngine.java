package management;
import models.WasteBin;

class AnalyticsEngine implements Reportable, AlertSystem {
    private double totalRecyclableCollected = 0;
    private double totalNonRecyclableCollected = 0;


    /**
     * Records the collection of waste from a bin and updates the analytics data.
     * @param bin: The WasteBin object representing the bin that was collected, 
     *             used to determine the type and amount of waste collected.
     */
    public void recordCollection(WasteBin bin) {
        if (bin.getType().equalsIgnoreCase("recyclable")) {
            totalRecyclableCollected += bin.getCurrentLevel();
        } else {
            totalNonRecyclableCollected += bin.getCurrentLevel();
        }
        bin.emptyBin();
    }

    /**
     * Prints overall waste collection statistics, including total waste collected and 
     * breakdown by category.
     */
    public void printStats() {
        System.out.println("Total Waste: " + (totalRecyclableCollected + 
            totalNonRecyclableCollected) + " kg");
    }

    /**
     * Prints waste collection statistics for a specific category 
     * (recyclable or non-recyclable)
     * Overloads the printStats method to provide category-specific insights 
     * when requested
     * @param category: The category of waste for which to print statistics 
     *                  (recyclable or non-recyclable)
     */
    public void printStats(String category) {
        if (category.equalsIgnoreCase("recyclable")) 
            System.out.printf("Recyclable Collected: %.2f kg\n", totalRecyclableCollected);
        else 
            System.out.printf("Non-Recyclable Collected: %.2f kg\n", totalNonRecyclableCollected);
    }

    /**
     * Prints detailed waste collection statistics, including breakdown by category and
     * overall efficiency metrics.
     * Overloads the printStats method to provide more detailed insights when requested
     * @param detailed: A boolean indicating whether to print detailed statistics
     */
    public void printStats(boolean detailed) {
        if (detailed) {
            System.out.println("--- Detailed Environmental Impact ---");
            printStats("recyclable");
            printStats("organic");
            double efficiency = (totalRecyclableCollected / (totalRecyclableCollected + 
                totalNonRecyclableCollected + 0.1)) * 100;
            System.out.printf("Recycling Efficiency: %.2f%%", efficiency);
        } else {
            printStats();
        }
    }

    /**
     * Logs missed pickups for bins that were not collected as scheduled, 
     * providing insights into potential issues in the collection process.
     * @param missedBinIds: An array of WasteBin objects representing the bins that were 
     *                      missed during collection  
     */
    public void logMissedPickups(WasteBin[] missedBinIds) {
        System.out.println("ALERT: Missed pickups for bins: ");
        for (WasteBin bin : missedBinIds) {
            System.out.println(bin.getBinId() + " " + bin.getLocation());
        }
        System.out.println();
    }

    /**
     * Generates a summary report of waste collection statistics, including total waste collected,
     * breakdown by category, and overall efficiency metrics.
     */
    public void generateSummary() { 
        printStats(true); 
    }

    /**
     * Triggers an alert with the specified message and severity level.
     * @param message: The message to show with the alert
     * @param severity: The severity level of the alert
     */
    public void triggerAlert(String message, String severity) {
        System.out.println("[" + severity.toUpperCase() + " ALERT] " + message);
    }
}