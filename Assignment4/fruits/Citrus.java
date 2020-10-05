package fruits;

public class Citrus extends Fruit {

    private String taste;

    public Citrus() {

    }

    public Citrus(String taste, String color, Boolean rotten) {
        super(color, rotten);
        this.setTaste(taste);
    }

    public String getTaste() {
        return this.taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String toString() {
        return "this is a " + this.getTaste() + " " + this.getColor() + (this.isRotten() ? " rotten " : " raw ")
                + "citrus with id: " + this.getId();
    }

    public Boolean equals(Citrus citrus) {
        return this.getClass().equals(citrus.getClass()) && this.getColor().equals(citrus.getColor())
                && this.isRotten() == citrus.isRotten() && this.getTaste().equals(citrus.getTaste());
    }

    // for debug purpose only
    public static void main(String[] args) {
        Citrus myOrange = new Citrus("juicy", "orange", true);
        System.out.println(myOrange);
    }

}