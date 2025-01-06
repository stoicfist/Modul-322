package carspoly;

public class CrashedCar extends Car {

	//an enum would be nicer
	public static final int DMG_LVL_LOW = 0;
	public static final int DMG_LVL_MEDIUM = 1;
	public static final int DMG_LVL_TOTAL = 2;
	
	private int damageLevel;
	
	public CrashedCar(String model, double price, int damageLevel) {
		super(model, price);
		this.damageLevel = damageLevel;
	}

	public double getPrice() {
		double pr = super.getPrice();
		switch (this.damageLevel) {
		case DMG_LVL_LOW:
			pr *= 0.9;
			break;
		case DMG_LVL_MEDIUM:
			pr *= 0.5;
			break;
			
		case DMG_LVL_TOTAL:
			pr = 0;
			break;

		}
		return pr;
	}
	
	/**
	 * @return the damageLevel
	 */
	public int getDamageLevel() {
		return damageLevel;
	}

	/**
	 * @param damageLevel the damageLevel to set
	 */
	public void setDamageLevel(int damageLevel) {
		this.damageLevel = damageLevel;
	}

}
