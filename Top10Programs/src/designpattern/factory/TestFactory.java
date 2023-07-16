package designpattern.factory;
/*
    https://www.youtube.com/watch?v=7g9S371qzwM&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=7
    https://www.scaler.com/topics/factory-design-pattern-in-java/
 */
public class TestFactory {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("RECTANGLE");
        shape.draw();
    }
}
