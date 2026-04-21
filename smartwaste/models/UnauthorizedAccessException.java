package models;
public class UnauthorizedAccessException extends Exception {
    /**
     * Constructor for UnauthorizedAccessException
     * @param error
     */
    public UnauthorizedAccessException(String error) { 
        super(error); 
    }
}