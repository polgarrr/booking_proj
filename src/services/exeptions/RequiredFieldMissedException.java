package services.exeptions;

public class RequiredFieldMissedException extends Exception{
    public RequiredFieldMissedException(String message) {
        super(message);
    }
    public RequiredFieldMissedException() {
        super("You didn't filled all required fields.");
    }
}
