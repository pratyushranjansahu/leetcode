package designpattern.abstractfactory;
/*
    https://www.youtube.com/watch?v=7g9S371qzwM&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=7
    https://darrenfinch.com/abstract-factory-pattern-explained-creational-design-patterns/
 */
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
