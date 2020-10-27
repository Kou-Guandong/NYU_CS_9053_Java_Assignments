package edu.nyu.cs9053.midterm.hierarchy;

public class SpeedSkater extends IceSkater {
    public double speed;

    public SpeedSkater() {

    }

    public SpeedSkater(String name, int age, double skateSize, double speed) {
        super(name, age, skateSize);
        this.speed = speed;
    }

    public double getSpeed() {
        return this.speed;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with speed: " + this.getSpeed();
    }

    public boolean equals(SpeedSkater skater) {
        return super.equals(skater) && this.speed == skater.speed;
    }

}
