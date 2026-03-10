import java.io.File;
import java.io.FileNotFoundException;

public class Runner {
	
	public static void main(String[] args) throws FileNotFoundException {
		Map map = new Map(new File("easyMap1.txt"), false);

		QueueBased queueBased = new QueueBased(map);
		Coordinate coord = new Coordinate(0, 0, 0);
//		System.out.println(map);
	}
}
