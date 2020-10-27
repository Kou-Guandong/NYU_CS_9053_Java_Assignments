package edu.nyu.cs9053.midterm.hierarchy;

public class MogulSkier extends Skier {
    private int jumps;

    public MogulSkier() {

    }

    public MogulSkier(String name, int age, int skiLength, int jumps) {
        super(name, age, skiLength);
        this.jumps = jumps;
    }

    public boolean equals(MogulSkier skier) {
        return super.equals(skier) && this.jumps == skier.jumps;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with jumps: " + this.jumps;
    }

}
