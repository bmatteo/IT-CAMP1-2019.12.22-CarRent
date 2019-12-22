package pl.camp.it.db;

import pl.camp.it.model.Bus;
import pl.camp.it.model.Car;
import pl.camp.it.model.Truck;
import pl.camp.it.model.Vehicle;

public class CarRepository {

    private static final CarRepository carRepository = new CarRepository();

    private final int listSize = 5;
    private final Vehicle[] vehicleList = new Vehicle[listSize];

    private CarRepository() {
        this.vehicleList[0] =
                new Car("Audi", "A5",
                        1999, 300.00, "AWS");
        this.vehicleList[1] =
                new Car("BMW", "3",
                        1999, 200.00, "QWE");
        this.vehicleList[2] =
                new Bus("Solaris", "A1",
                        4999, 400.00, "ZXC");
        this.vehicleList[3] =
                new Bus("Solaris", "A1",
                        4999, 400.00, "FGH");
        this.vehicleList[4] =
                new Truck("Volvo", "100",
                        3999, 500.00, "VBN");
    }

    public static CarRepository getBaza() {
        return CarRepository.carRepository;
    }

    public Vehicle[] getAvailableVehicles() {
        Vehicle[] result = new Vehicle[this.listSize];
        int i = 0;
        for(Vehicle v : this.vehicleList) {
            if(!v.isRent()) {
                result[i++] = v;
            }
        }

        return result;
    }

    public Car[] getAvailableCars() {
        Car[] result = new Car[this.listSize];
        int i = 0;

        for(Vehicle v : this.vehicleList) {
            if(!v.isRent() && v instanceof Car) {
                result[i++] = (Car) v;
            }
        }

        return result;
    }

    public Truck[] getAvailableTrucks() {
        Truck[] result = new Truck[this.listSize];
        int i = 0;

        for(Vehicle v : this.vehicleList) {
            if(!v.isRent() && v instanceof Truck) {
                result[i++] = (Truck) v;
            }
        }

        return result;
    }

    public Bus[] getAvailableBuses() {
        Bus[] result = new Bus[this.listSize];
        int i = 0;

        for(Vehicle v : this.vehicleList) {
            if(!v.isRent() && v instanceof Bus) {
                result[i++] = (Bus) v;
            }
        }

        return result;
    }

    public boolean rentVehicle(String vin) {
        for (Vehicle vehicle : this.vehicleList) {
            if(vehicle.getVin().equals(vin)) {
                vehicle.setRent(true);
                return true;
            }
        }

        return false;
    }
}
