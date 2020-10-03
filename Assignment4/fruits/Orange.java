package fruits;

public class Orange extends Citrus {
    private String type;

    public Orange() {

    }

    public Orange(String type, String taste, Boolean rotten) {
        super(taste, "orange", rotten);
        this.setType(type);
        this.setRotten(rotten);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "this is a " + this.getTaste() + (this.isRotten() ? " rotten " : " raw ") + this.type + " with id: "
                + this.getId();
    }

    public Boolean equals(Orange orange) {
        return this.getClass().equals(orange.getClass()) && this.getColor().equals(orange.getColor())
                && this.isRotten() == orange.isRotten() && this.getTaste().equals(orange.getTaste())
                && this.getType().equals(orange.getType());
    }

    // for debug purpose only
    public static void main(String[] args) {
        Orange myOrange = new Orange("mandarin", "sweet", true);
        System.out.println(myOrange);
    }
}
