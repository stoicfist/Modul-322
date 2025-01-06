package test;

import java.util.ArrayList;

import carspoly.Car;
import carspoly.CrashedCar;
import carspoly.Fleet;
import carspoly.UsedCar;

public class TestCarsPoly {

	public static void main(String[] args) {
		double price = 80000;
		
		//Test 1
		System.out.println("TEST 1");
		Car uc = new UsedCar("Audi A6", price, 10000);
		print("u10000", 76000, uc.getPrice());
		
		//Test 2
		System.out.println("TEST 2");
		Car cc = new CrashedCar("BMW M3", price, CrashedCar.DMG_LVL_LOW);
		print("low", price*0.9, cc.getPrice());
		
		//Test 3
		System.out.println("TEST 3");
		Fleet fleet = new Fleet();
		fleet.addCar(uc);
		fleet.addCar(cc);
		fleet.print();
	}
	
	private static void print(String id, double expected, double effective) {
		System.out.println(id + " expected " + expected + ", effective: "+ effective);
	}
}
