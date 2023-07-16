package designpattern.abstractfactory;

public class FordRanger extends Truck {
    public FordRanger(String color, int engineHP)
    {
        super(color, engineHP);
    }
    @Override
    public void drive()
    {
        System.out.println("Driving a " + color + " Ford Ranger. This thing has " + engineHP + " horsepower. Wow.");
    }
}
