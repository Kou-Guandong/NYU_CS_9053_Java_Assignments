package fruits;

class Apple extends Fruit {
    private String texture;
    private String taste;

    public Apple() {

    }

    public Apple(String taste, String texture, String color, Boolean rotten) {
        super(color, rotten);
        this.setTaste(taste);
        this.setTexture(texture);
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

    public Boolean equals(Apple apple) {
        return this.getClass().equals(apple.getClass()) && this.getColor().equals(apple.getColor())
                && this.isRotten() == apple.isRotten() && this.getTaste().equals(apple.getTaste())
                && this.getTexture().equals(apple.getTexture());
    }

}