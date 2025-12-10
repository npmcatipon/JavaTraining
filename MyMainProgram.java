

public class MyMainProgram {
	public static void main(String[] args) {
		Truck truck = new Truck("Honda",5);
		truck.startEngine();
		truck.refuel();
		
		Car car = new Car("Toyota",4);
		car.startEngine();
		car.refuel();
		
		destroyVehicle(truck);
		destroyVehicle(car);
	}

	public static void destroyVehicle(Vehicle vehicle) {
		vehicle.destroy();
	}
}
