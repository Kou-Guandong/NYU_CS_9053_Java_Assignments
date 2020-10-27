package edu.nyu.cs9053.midterm.hierarchy;

public class IceSkater extends WinterSportPlayer {
    public double skateSize;

    public IceSkater() {

    }

    public IceSkater(String name, int age, double skateSize) {
        super(name, age);
        this.skateSize = skateSize;
    }

    public double getSkateSize() {
        return this.skateSize;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with skate size: " + this.getSkateSize();
    }

    public boolean equals(IceSkater skater) {
        return super.equals(skater) && this.skateSize == skater.skateSize;
    }
}
