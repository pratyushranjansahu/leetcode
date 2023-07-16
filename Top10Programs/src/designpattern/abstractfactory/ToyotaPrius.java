package designpattern.abstractfactory;

public class ToyotaPrius extends Car {
    public ToyotaPrius(String color, int engineHP)
    {
        super(color, engineHP);
    }
    @Override
    public void drive()
    {
        //I'm not ashamed of my opinion on the Toyota Prius.
        System.out.println("Driving a " + color + " Toyota Prius. This thing is trash. It's not even worth telling you the horsepower.");
    }
}
