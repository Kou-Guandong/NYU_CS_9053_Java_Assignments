package fruits;

public class Fruit {
    private String color;
    private Boolean rotten;
    private static int next_id = 0;
    private int id = ++next_id;

    public Fruit() {

    }

    public Fruit(String color, Boolean rotten) {
        this.color = color;
        this.rotten = rotten;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isRotten() {
        return this.rotten;
    }

    public void setRotten(Boolean rotten) {
        this.rotten = rotten;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "This is a/an " + this.getClass().getSimpleName() + " with " + this.color + " color and id: " + this.id;
    }

    public static void main(String[] args) {
        System.out.println("fruit main");
    }

}