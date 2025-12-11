

public class Car extends Vehicle implements Refuelable {

	public Car(String brand, int numberOfWheels) {
		this.setBrand(brand);
		this.setNumberOfWheels(numberOfWheels);
	}

	@Override
	public void startEngine() {
		System.out.println("Starting Car's " + getBrand() + " engine with " + getNumberOfWheels() + " wheels.");
		
	}
	
	@Override
	public void refuel() {
		System.out.println("Refuelling Car's " + getBrand() + " with " + getNumberOfWheels() + " wheels.");
		
	}

	@Override
	void destroy() {
		System.out.println("Destroying Car's " + getBrand() + " engine with " + getNumberOfWheels() + " wheels.");
		
	}

}
