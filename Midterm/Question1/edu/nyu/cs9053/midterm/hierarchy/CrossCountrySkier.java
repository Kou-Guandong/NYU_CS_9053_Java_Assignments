package edu.nyu.cs9053.midterm.hierarchy;

public class CrossCountrySkier extends Skier {
    
    public int distance;

    public CrossCountrySkier() {

    }

    public CrossCountrySkier(String name, int age, int skiLength, int distance) {
        super(name, age, skiLength);
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with ski distance: " + this.getDistance();
    }

    public boolean equals(CrossCountrySkier skier) {
        return super.equals(skier) && this.distance == skier.distance;
    }

}
