package edu.nyu.cs9053.midterm.hierarchy;

public class BobSledder extends Sledder {
    public double steerSize;

    public BobSledder() {

    }

    public BobSledder(String name, int age, String sledColor, double steerSize) {
        super(name, age, sledColor);
        this.steerSize = steerSize;
    }

    public double getSteerSize() {
        return this.steerSize;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with sled shape: " + this.getSteerSize();
    }

    public boolean equals(BobSledder sledder) {
        return super.equals(sledder) && this.steerSize == sledder.steerSize;
    }

}
