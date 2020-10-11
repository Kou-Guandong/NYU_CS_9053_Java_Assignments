package shapes;

public class ShapeException extends Exception {
    static final long serialVersionUID = 301L;

    public ShapeException() {

    }

    public ShapeException(String message) {
        super(message);
    }
}
