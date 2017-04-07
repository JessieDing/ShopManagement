import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<Integer, Car> cars = new HashMap<>();
		cars.put(1, new Car("Benz", 280, 4));
		cars.put(2, new Car("BMW", 280, 4));
		cars.put(3, new Car("Audi", 280, 4));
		for (Map.Entry<Integer, Car> e : cars.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue().toString());
		}
	}

}

@SuppressWarnings("rawtypes")
class Car implements Comparable {
	private String name;
	private double maxSpeed;
	private int capacity;

	public Car() {
	}

	public Car(String name, double maxSpeed, int capacity) {
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "name='" + name + '\'' + ", maxSpeed=" + maxSpeed + ", capacity=" + capacity;
	}

	@Override
	public int compareTo(Object o) {
		Car c = (Car) o;
		if (this.capacity > c.capacity) {
			return 1;
		} else {
			return -1;
		}
	}
}
