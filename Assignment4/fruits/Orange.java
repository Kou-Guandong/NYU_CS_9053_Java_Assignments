package fruits;

import jdk.internal.jshell.tool.resources.l10n;

public class Orange extends Citrus {
    private String type;

    public Orange() {

    }

    public Orange(String type, String taste, Boolean rotten) {
        this.setType(type);
        this.setTaste(taste);
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

    // for debug purpose only
    public static void main(String[] args) {
        Orange myOrange = new Orange("mandarin", "sweet", true);
        System.out.println(myOrange);
    }
}
