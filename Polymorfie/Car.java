package carspoly;

public class Car {
	
	private String model;
	private double price;
	
	public Car(String model, double price) {
		this.model = model;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	
	public String getModel() {
		return model;
	}
	
	
	
}