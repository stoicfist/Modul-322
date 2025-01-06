package carspoly;

import java.util.ArrayList;

public class Fleet {

	private ArrayList<Car> cars = new ArrayList<Car>();
	
	public void addCar(Car car) {
		this.cars.add(car);
	}
	
	public void print() {
		for(Car c : cars) {
			System.out.println(c.getModel() + " : " + c.getPrice());
		}
	}
}
