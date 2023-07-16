package designpattern.abstractfactory;

public class HondaCivic extends Car {
    public HondaCivic(String color, int engineHP)
    {
        super(color, engineHP);
    }
    @Override
    public void drive()
    {
        System.out.println("Driving a " + color + " Honda Civic. This thing has " + engineHP + " horsepower. But it's a car so it doesn't really matter.");
    }
}
