
public abstract class Vehicle {

	private String brand;
	private int numberOfWheels;

	abstract void startEngine();
	abstract void destroy();

	public Vehicle() {
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
}
