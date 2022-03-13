package trenitalia.exceptions;

public class TrenitaliaEmptyArgumentException extends RuntimeException {
    public TrenitaliaEmptyArgumentException() {
        super("One or more arugments are empty");
    }
}
