package test;

import cars.CrashedCar;
import cars.UsedCar;

public class TestCars {

	public static void main(String[] args) {
		// anstelle CrashedCar.DMG_LVL_LOW auch 0 ok
		CrashedCar cc = new CrashedCar("BMW M3", 10000, CrashedCar.DMG_LVL_LOW);
		print("low", 10000*0.9, cc.getPrice());
		
		cc.setDamageLevel(CrashedCar.DMG_LVL_MEDIUM);
		print("medium", 10000*0.5, cc.getPrice());

		cc.setDamageLevel(CrashedCar.DMG_LVL_TOTAL);
		print("total", 0, cc.getPrice());

		double price = 80000;
		UsedCar uc = new UsedCar("Audi A6", price, 0);
		print("u0", price, uc.getPrice());

		uc.setMileage(10000);
		print("u10000", 76000, uc.getPrice());

		uc.setMileage(200000);
		print("u200000", 0, uc.getPrice());

		uc.setMileage(210000);
		print("u210000", 0, uc.getPrice());

	}

	private static void print(String id, double expected, double effective) {
		System.out.println(id + " expected " + expected + ", effective: "+ effective);
	}
}