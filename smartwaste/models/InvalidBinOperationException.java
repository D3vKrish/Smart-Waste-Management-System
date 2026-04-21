package models;
public class InvalidBinOperationException extends Exception {
    /**
     * Constructor for InvalidBinOperationException
     * @param error
     */
    public InvalidBinOperationException(String error) { 
        super(error); 
    }
}