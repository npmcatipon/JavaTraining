

public class Truck extends Vehicle implements Refuelable  {

	public Truck(String brand, int numberOfWheels) {
		this.setBrand(brand);
		this.setNumberOfWheels(numberOfWheels);
	}

	@Override
	public void startEngine() {
		System.out.println("Starting Truck's " + getBrand() + " engine with " + getNumberOfWheels() + " wheels.");
	}

	@Override
	public void refuel() {
		System.out.println("Refuelling Truck's " + getBrand() + " with " + getNumberOfWheels() + " wheels.");
	}

	@Override
	public void destroy() {
		System.out.println("Destroying Truck's " + getBrand() + " engine with " + getNumberOfWheels() + " wheels.");
	}
}
