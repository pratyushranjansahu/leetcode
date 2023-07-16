package designpattern.strategy;
/*
    https://www.youtube.com/watch?v=u8DttUrXtEw&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=4
    https://www.freecodecamp.org/news/a-beginners-guide-to-the-strategy-design-pattern/
 */
public class TestStrategy {

    public static void main(String[] args) {
        Vehicle vehicle = new OffRoadVehicle();
        vehicle.drive();//Sports Drive Strategy
    }
}
