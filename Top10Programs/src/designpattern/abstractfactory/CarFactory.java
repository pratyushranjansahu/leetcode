package designpattern.abstractfactory;

public class CarFactory implements AbstractVehicleFactory
{
    @Override
    public Vehicle createVehicle(String typeOfVehicle, String color, int engineHP)
    {
        Car newCar;
        switch (typeOfVehicle)
        {
            case "Honda Civic":
                newCar = new HondaCivic(color, engineHP);
                break;
            case "Toyota Prius":
                newCar = new ToyotaPrius(color, engineHP);
                break;
            default:
                newCar = null;
        }
        if(newCar != null)
            newCar.canTow = false;

        return newCar;
    }
}
