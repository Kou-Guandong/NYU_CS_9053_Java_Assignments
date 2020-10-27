package edu.nyu.cs9053.midterm.hierarchy;

public abstract class WinterSportPlayer implements WinterSportInterface {

	public String name;
	public int age;

	public WinterSportPlayer() {

	}

	public WinterSportPlayer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

    public String getPlayerInfo() {
        return this.getName() + ", " + this.getAge();
	}
	
	public boolean equals(WinterSportPlayer player) {
		return this.name.equals(player.name) && this.age == player.age;
	}

}
