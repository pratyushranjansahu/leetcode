package designpattern.abstractfactory;

public abstract class Car extends Vehicle {
    public Car(String color, int engineHP)
    {
        super(color, engineHP);
        System.out.println("Constructing a car that can't tow stuff.");
    }
}
