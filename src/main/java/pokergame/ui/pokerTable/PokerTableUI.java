package pokergame.ui.pokerTable;

import pokergame.Poker;
import pokergame.ui.pokerTable.shape.Shape;

public class PokerTableUI {
    private String color;
    private int sizeX;
    private int sizeY;
    private Shape tableShape;

    public String getColor() {
        return color;
    }

    public PokerTableUI setColor(String color) {
        this.color = color;
        return this;
    }

    public int getSizeX() {
        return sizeX;
    }

    public PokerTableUI setSizeX(int sizeX) {
        this.sizeX = sizeX;
        return this;
    }

    public int getSizeY() {
        return sizeY;
    }

    public PokerTableUI setSizeY(int sizeY) {
        this.sizeY = sizeY;
        return this;
    }

    public Shape getTableShape() {
        return tableShape;
    }

    public PokerTableUI setTableShape(Shape shape) {
        this.tableShape = shape;
        return this;
    }
}
