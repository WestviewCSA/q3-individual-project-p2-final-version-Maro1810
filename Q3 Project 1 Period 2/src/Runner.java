import java.io.File;
import java.io.FileNotFoundException;

public class Runner {
	
	public static void main(String[] args) throws FileNotFoundException, IllegalMapCharacterException, IncorrectMapFormatException {
		Map map = new Map(new File("randomMap.txt"), false);
		QueueBased queueBased = new QueueBased(map);
		StackBased stackBased = new StackBased(map);
		double time = (double) System.currentTimeMillis()/1000;
		
		Map newMap = stackBased.solve();
		time = (double)System.currentTimeMillis()/1000 - time;
		
		System.out.println(time);
		System.out.println(newMap);
		
	
	}
}
