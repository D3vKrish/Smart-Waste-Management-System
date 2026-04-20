package models;
public class InvalidBinOperationException extends Exception {
    public InvalidBinOperationException(String error) { 
        super(error); 
    }
}