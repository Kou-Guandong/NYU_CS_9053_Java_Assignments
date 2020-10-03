package fruits;

class Apple extends Fruit {
    private String texture;
    private String taste;

    public Apple() {

    }

    public Apple(String taste, String texture, String color, Boolean rotten) {
        super(color, rotten);
        this.taste = taste;
        this.texture = texture;
    }

    public String getTaste() {
        return this.taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTexture() {
        return this.texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

}