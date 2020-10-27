package edu.nyu.cs9053.midterm.hierarchy;

public class FigureSkater extends IceSkater {
    public int expereince;

    public FigureSkater() {

    }

    public FigureSkater(String name, int age, double skateSize, int expereince) {
        super(name, age, skateSize);
        this.expereince = expereince;
    }

    public double getExpereince() {
        return this.expereince;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with experience (years): " + this.getExpereince();
    }

    public boolean equals(FigureSkater skater) {
        return super.equals(skater) && this.expereince == skater.expereince;
    }

}
