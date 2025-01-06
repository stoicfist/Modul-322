package carspoly;

public class UsedCar extends Car {

	private int mileage;

	public UsedCar(String model, double price, int mileage) {
		super(model, price);
		this.mileage = mileage;
	}

	public double getPrice() {

		double priceOneKm = (super.getPrice() / 100) * 0.0005;
		// Preis - Abschreibung
		double newPrice = super.getPrice() - (priceOneKm * this.mileage);
		if (newPrice < 0) {
			newPrice = 0;
		}
		return newPrice;
	}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
}
