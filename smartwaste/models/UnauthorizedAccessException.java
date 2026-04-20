package models;
public class UnauthorizedAccessException extends Exception {
    public UnauthorizedAccessException(String error) { 
        super(error); 
    }
}