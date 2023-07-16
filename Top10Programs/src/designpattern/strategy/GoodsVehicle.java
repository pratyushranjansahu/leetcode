package designpattern.strategy;

public class GoodsVehicle extends Vehicle {

    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
