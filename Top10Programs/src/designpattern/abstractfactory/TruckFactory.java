package designpattern.abstractfactory;

public class TruckFactory implements AbstractVehicleFactory
{
    @Override
    public Vehicle createVehicle(String typeOfVehicle, String color, int engineHP)
    {
        Truck newTruck;
        switch (typeOfVehicle)
        {
            case "Dodge Ram":
                newTruck = new DodgeRam(color, engineHP);
                break;
            case "Ford Ranger":
                newTruck = new FordRanger(color, engineHP);
                break;
            default:
                newTruck = null;
        }
        if(newTruck != null)
            newTruck.canTow = true;

        return newTruck;
    }
}
