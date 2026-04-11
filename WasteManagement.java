package smartwaste;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SmartWasteManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Requirement 7: Scanner 
        AnalyticsEngine engine = new AnalyticsEngine();
        
        WasteBin bin1 = new WasteBin("B001", "organic", 100.0);
        WasteBin bin2 = new WasteBin("B002", "recyclable", 150.0, 50.0); // Uses overloaded constructor
        
        System.out.println("Welcome to Smart Waste Management System");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your role (admin/staff): ");
        String roleStr = scanner.nextLine();
        
        User activeUser;
        if (roleStr.equalsIgnoreCase("admin")) {
            activeUser = new Admin(username);
        } else {
            activeUser = new CollectionStaff(username);
        }
        
        activeUser.showDashboard();

        try {
            // Simulating waste deposits
            bin1.addWaste(80.0);
            bin2.addWaste(120.0); // This will throw BinOverflowException (50 + 120 > 150)
            
        } catch (BinOverflowException e) {
            engine.triggerAlert(e.getMessage(), "High");
        }

        // Collecting waste
        engine.recordCollection(bin1);
        
        // Requirement 10: Varargs usage
        engine.logMissedPickups("B002", "B005", "B012");

        // Outputting reports
        engine.generateSummary(); 

        // Requirement 7: File Handling (Writing a collection event to a log file) 
        try (FileWriter writer = new FileWriter("collection_log.txt", true)) {
            writer.write("Collection Event executed by: " + activeUser.getUsername() + "\n"); 
            writer.write("Bin B001 emptied successfully.\n");
            System.out.println("Log successfully saved to collection_log.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
        
        scanner.close();
    }
}