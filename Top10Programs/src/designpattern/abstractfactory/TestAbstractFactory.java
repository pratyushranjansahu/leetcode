package designpattern.abstractfactory;

public class TestAbstractFactory {
    public static void main(String[] args) {
        AbstractVehicleFactory vehicleFactory = VehicleFactoryProducer.createVehicleFactory("Truck");
        if(vehicleFactory != null)
        {
            Vehicle newDodgeRam = vehicleFactory.createVehicle("Dodge Ram", "white", 350);
            newDodgeRam.drive();
        }
    }
}
