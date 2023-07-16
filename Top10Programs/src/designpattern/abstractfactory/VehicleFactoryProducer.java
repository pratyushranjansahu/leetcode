package designpattern.abstractfactory;

public class VehicleFactoryProducer {
    public static AbstractVehicleFactory createVehicleFactory(String factoryType)
    {
        switch (factoryType)
        {
            case "Truck":
                return new TruckFactory();
            case "Car":
                return new CarFactory();
            default:
                return null;
        }
    }
}
