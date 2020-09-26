
public class Ellipse {
    private static int nextId;
    private int id = ++nextId;

    private double semiMajorAxis = 2.0;
    private double semiMinorAxis = 1.0;

    public Ellipse() {

    }

    public Ellipse(double a, double b) {
        this.semiMajorAxis = a;
        this.semiMinorAxis = b;
    }

    public double getSemiMajorAxis() {
        return this.semiMajorAxis;
    }

    public double getSemiMinorAxis() {
        return this.semiMinorAxis;
    }

    public double getArea() {
        return this.semiMajorAxis * this.semiMinorAxis * Math.PI;
    }

    public int getId() {
        return this.id;
    }

}
