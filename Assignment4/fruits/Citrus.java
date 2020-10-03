package fruits;

class Citrus extends Fruit {

    private String taste;

    public Citrus() {

    }

    public Citrus(String taste, String color, Boolean rotten) {
        super(color, rotten);
        this.taste = taste;
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

    // for debug purpose only
    public static void main(String[] args) {
        Citrus myOrange = new Citrus("juicy", "orange", true);
        System.out.println(myOrange);
    }

}