package edu.nyu.cs9053.midterm.hierarchy;

public class Luger extends Sledder {
    public String sledShape;

    public Luger() {

    }

    public Luger(String name, int age, String sledColor, String sledShape) {
        super(name, age, sledColor);
        this.sledShape = sledShape;
    }

    public String getSledShape() {
        return this.sledShape;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with sled shape: " + this.getSledShape();
    }

    public boolean equals(Luger sledder) {
        return super.equals(sledder) && this.sledShape.equals(sledder.sledShape);
    }

}
