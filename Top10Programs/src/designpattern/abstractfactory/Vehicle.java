package designpattern.abstractfactory;

public abstract class Vehicle {
    protected String color;
    protected int engineHP;
    protected Boolean canTow;

    public Vehicle(String color, int engineHP)
    {
        this.color = color;
        this.engineHP = engineHP;
    }
    public abstract void drive();
}
