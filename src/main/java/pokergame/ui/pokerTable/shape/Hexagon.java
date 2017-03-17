package pokergame.ui.pokerTable.shape;

/**
 * Created by Rik on 17-3-2017.
 */
public class Hexagon {
    private final MyShape shape = new MyShape();
    public void draw() {
        shape.draw();
    }

    private class MyShape extends Shape {
        public void draw() {

        }
    }
}
