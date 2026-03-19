import java.io.File;
import java.io.FileNotFoundException;

public class Runner {
	
	public static void main(String[] args) throws FileNotFoundException, IllegalMapCharacterException, IncorrectMapFormatException {
		boolean stackApproach = false;
		boolean queueApproach = false;
		boolean optimal = false;
		boolean showTime = false;
		boolean inCoord = false;
		boolean outCoord = false;
	
		for (String arg : args) {
			if (arg.equals("--Stack")) {
				stackApproach = true;
			}
			if (arg.equals("--Queue")) {
				queueApproach = true;
			}
			if (arg.equals("--Opt")) {
				optimal = true;
			}
			if (arg.equals("--Time")) {
				showTime = true;
			}
			if (arg.equals("--Incoordinate")) {
				inCoord = true;
			}
			if (arg.equals("--Outcoordinate")) {
				outCoord = true;
			}
			if (arg.equals("--Help")) {
				System.out.println("help message");
				System.exit(0);
			}
		}
	
		if (queueApproach && stackApproach || queueApproach && optimal || optimal && stackApproach) {
			System.out.println("you may only choose one pathfinding approach!");
			System.exit(-1);
		}
		if (inCoord && outCoord) {
			System.out.println("map format cannot be both incoordinate and outcoordinate!");
			System.exit(-1);
		}
		
		Map map = new Map(new File("randomMap.txt"), true);
		QueueBased queueBased = new QueueBased(map);
		StackBased stackBased = new StackBased(map);
		double time = (double) System.currentTimeMillis()/1000;
		System.out.println(map);
		queueBased.solve();
		queueBased.printSolution();
//		time = (double)System.currentTimeMillis()/1000 - time;
		
//		System.out.println(time);
		
	
	}
}
