import java.io.File;
import java.io.FileNotFoundException;

public class p1 {
	
	public static void main(String[] args) throws FileNotFoundException, IllegalMapCharacterException, IncorrectMapFormatException, IllegalCommandLineInputsException, IncompleteMapException {
		p1 p = new p1();
		
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
				System.out.println("Use --Stack to solve the maze using a stack-based approach, --Queue to solve the maze using a queue-based approach, and --Opt to solve the maze using an optimal pathfinding algorithm. Use --Time to display the time taken to solve the maze. Use --Incoordinate if the input map is in coordinate format, and --Outcoordinate if the input map is in grid format. Only one of --Stack, --Queue, and --Opt can be used at the same time, and at least one of them must be used. The last argument should be the file path of the input map.");
				System.exit(0);
			}
		}
	
		if (queueApproach && stackApproach || queueApproach && optimal || optimal && stackApproach) {
			throw new IllegalCommandLineInputsException("Only one of --Stack, --Queue, and --Opt can be used at one time!");
		}
		if (!queueApproach && !stackApproach && !optimal) {
			throw new IllegalCommandLineInputsException("At least one of --Stack, --Queue, and --Opt must be used!");
		}
		
		Map map = new Map(new File(args[args.length-1]), inCoord);
		QueueBased queueBased = new QueueBased(map);
		StackBased stackBased = new StackBased(map);

		double time = (double) System.currentTimeMillis()/1000;

		if (queueApproach) {
			queueBased.solve();
			time = (double)System.currentTimeMillis()/1000 - time;
			if (showTime) {
				System.out.println(time);
			}
			queueBased.printSolution(outCoord);
		}
		if (stackApproach) {
			stackBased.solve();
			time = (double)System.currentTimeMillis()/1000 - time;

			if (showTime) {
				System.out.println(time);
			}

			stackBased.printSolution(outCoord);
		}
		if (optimal) {
			// Implement optimal pathfinding logic
		}
//		time = (double)System.currentTimeMillis()/1000 - time;
		
//		System.out.println(time);
		
	
	}
}
