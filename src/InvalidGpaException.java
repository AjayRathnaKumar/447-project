public class InvalidGpaException extends Exception{
    float gpa;
    public InvalidGpaException(float gpa){
        super("Invalid gpa encountered");
        this.gpa=gpa;
    }
    public InvalidGpaException(String message,float gpa) {
        super(message);
        this.gpa=gpa;
    }

    public InvalidGpaException(String message, Throwable cause, float gpa) {
        super(message, cause);
        this.gpa=gpa;
    }

    public InvalidGpaException(Throwable cause,float gpa) {
        super(cause);
        this.gpa=gpa;
    }

    protected InvalidGpaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, float gpa) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.gpa=gpa;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    public float getgpa() {
        return gpa;
    }
}
