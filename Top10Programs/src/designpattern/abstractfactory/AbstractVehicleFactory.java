package designpattern.abstractfactory;

public interface AbstractVehicleFactory {
    Vehicle createVehicle(String typeOfVehicle, String color, int engineHP);
}
