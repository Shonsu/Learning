package pl.shonsu.modifiers.different_package;

import pl.shonsu.modifiers.Pen;

public class BallPen extends Pen {
    protected String manufacturer;

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BallPen(String color, String manufacturer) {
        super(color);
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return manufacturer + " " + color;
    }
}
