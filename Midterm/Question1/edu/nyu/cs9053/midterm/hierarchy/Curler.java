package edu.nyu.cs9053.midterm.hierarchy;

public class Curler extends WinterSportPlayer {

    private int shoesSize;

    public Curler() {

    }

    public Curler(String name, int age, int shoesSize) {
        super(name, age);
        this.shoesSize = shoesSize;
    }

    public int getShoesSize() {
        return this.shoesSize;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with shoes size: " + this.getShoesSize();
    }

    public boolean equals(Curler curler) {
        return super.equals(curler) && this.shoesSize == curler.shoesSize;
    }

}
