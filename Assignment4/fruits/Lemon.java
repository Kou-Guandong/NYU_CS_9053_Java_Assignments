package fruits;

public class Lemon extends Citrus {
    private int sourness;

    public Lemon() {

    }

    public Lemon(int sourness, String taste, Boolean rotten) {
        super(taste, "yellow", rotten);
        this.setSourness(sourness);
    }

    public int getSourness() {
        return this.sourness;
    }

    public void setSourness(int sourness) {
        this.sourness = sourness;
    }

    public Boolean equals(Lemon lemon) {
        return this.getClass().equals(lemon.getClass()) && this.getColor().equals(lemon.getColor())
                && this.isRotten() == lemon.isRotten() && this.getTaste().equals(lemon.getTaste())
                && this.getSourness() == lemon.getSourness();
    }

}
