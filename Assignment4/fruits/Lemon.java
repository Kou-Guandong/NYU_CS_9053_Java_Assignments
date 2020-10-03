package fruits;

public class Lemon extends Citrus {
    private int sourness;

    public Lemon() {

    }

    public Lemon(int sourness, String taste, Boolean rotten) {
        this.setSourness(sourness);
        this.setTaste(taste);
        this.setRotten(rotten);
    }

    public int getSourness() {
        return this.sourness;
    }

    public void setSourness(int sourness) {
        this.sourness = sourness;
    }

}
