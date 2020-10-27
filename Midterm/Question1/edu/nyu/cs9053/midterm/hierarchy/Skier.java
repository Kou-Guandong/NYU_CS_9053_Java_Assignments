package edu.nyu.cs9053.midterm.hierarchy;

public class Skier extends WinterSportPlayer {
    public int skiLength;

    public Skier() {

    }

    public Skier(String name, int age, int skiLength) {
        super(name, age);
        this.skiLength = skiLength;
    }

    public int getSkiLength() {
        return this.skiLength;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with ski length " + this.getSkiLength();
    }

    public boolean equals(Skier skier) {
        return super.equals(skier) && this.skiLength == skier.skiLength;
    }
}
