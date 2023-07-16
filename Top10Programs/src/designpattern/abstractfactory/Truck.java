package designpattern.abstractfactory;

public abstract class Truck extends Vehicle {
    public Truck(String color, int engineHP)
    {
        super(color, engineHP);
        System.out.println("Constructing a truck that can tow stuff.");
    }
}
