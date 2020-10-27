package edu.nyu.cs9053.midterm.hierarchy;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Sledder extends WinterSportPlayer {
    public String sledColor;

    public Sledder() {

    }

    public Sledder(String name, int age, String sledColor) {
        super(name, age);
        this.sledColor = sledColor;
    }

    public String getSledColor() {
        return this.sledColor;
    }

    @Override
    public String getPlayerInfo() {
        return super.getPlayerInfo() + ", with sled color: " + this.getSledColor();
    }

    public boolean equals(Sledder sledder) {
        return super.equals(sledder) && this.sledColor.equals(sledder.sledColor);
    }

}
