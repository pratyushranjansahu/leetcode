package designpattern.abstractfactory;

public class DodgeRam extends Truck {
    public DodgeRam(String color, int engineHP)
    {
        super(color, engineHP);
    }
    @Override
    public void drive()
    {
        System.out.println("Driving a " + color + " Dodge Ram. This thing has " + engineHP + " horsepower. Wow.");
    }
}
