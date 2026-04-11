package smartwaste;

interface Reportable {
    void generateSummary();
}

interface AlertSystem {
    void triggerAlert(String message, String severity); // severity: low, moderate, high, critical
}