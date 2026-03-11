import java.io.File;
import java.io.FileNotFoundException;

public class Runner {
	
	public static void main(String[] args) throws FileNotFoundException {
		Map map = new Map(new File("C:\\Users\\rayya\\Downloads\\q3-individual-project-p2-final-version-Maro1810\\Q3 Project 1 Period 2\\randomMap.txt"), false);
		QueueBased queueBased = new QueueBased(map);
		Coordinate coord = new Coordinate(0, 0, 0);
		// map.setSymbol(coord, "-");
		System.out.println(queueBased.queueBasedSolution());
		System.out.println(queueBased.time);
		// System.out.println(map);
	}
}
