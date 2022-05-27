package pl.shonsu.modifiers;

public class Pen {
    protected String color;

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Pen(String color) {
        this.color = color;
    }
}
