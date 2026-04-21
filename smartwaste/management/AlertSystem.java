package management;
/**
 * Interface for triggering alerts in the waste management system.
 * This interface defines a method for triggering alerts with a message and s
 * everity level,
 */
interface AlertSystem {
    void triggerAlert(String message, String severity); 
}
