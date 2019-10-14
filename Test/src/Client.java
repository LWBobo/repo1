
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Client {
	public static void main(String[] args) {
		Car car  = new Car();
		car.move();
		
		System.out.println("----------");
		FlyCar flycar = new FlyCar(car);
		flycar.move();
		
		System.out.println("---------");
		WaterCar  waterCar = new WaterCar(car);
		waterCar.move();
		
		System.out.println("-------");
		WaterCar waterCar2 = new WaterCar(new FlyCar(new AICar(car)));
		waterCar2.move();
		
		
//		Reader r = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:/a.txt"))));
		
	}
}
