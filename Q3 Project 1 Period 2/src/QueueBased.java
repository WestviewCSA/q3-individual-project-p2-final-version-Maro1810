import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class QueueBased {
	
	Map map;
	
	public QueueBased(Map map) {
		this.map = map;
	}
	
	public String[][][] queueBasedSolution() throws FileNotFoundException {
		for (int l = 0; l < map.numLevels(); l++) {
			
		
		boolean found = false;
		
		Coordinate wolverineLocation = findWolverine(l);
		Coordinate endLocation = new Coordinate();
		
		Queue<Coordinate> queuedLocations = new LinkedList<Coordinate>();
		Queue<Coordinate> visitedLocations = new LinkedList<Coordinate>();
		
		queuedLocations.add(wolverineLocation);
		
		do {
			Coordinate currLocation = queuedLocations.remove();
			visitedLocations.add(currLocation);
			
			Coordinate[] nextLocations = {currLocation.north(), currLocation.south(), currLocation.east(), currLocation.west()};
			
				for (int i = 0; i < nextLocations.length; i++) {
					if (map.inBounds(nextLocations[i])) {
						if (!map.getSymbol(nextLocations[i]).equals("@")) {
							if (map.endSymbol(nextLocations[i])) {
								if (!queuedLocations.contains(nextLocations[i]) && !visitedLocations.contains(nextLocations[i])) {
									endLocation = nextLocations[i];
									found = true;
									break;
								}
								
							}
							
							else {
								if (!queuedLocations.contains(nextLocations[i]) && !visitedLocations.contains(nextLocations[i])) {
									queuedLocations.add(nextLocations[i]);
								}
							}
							
						}
						
						
					}
				}
			}
			while(!found);
		
		}
		return null;
	}
	
	private Coordinate findWolverine(int level) {
		Coordinate wolverineLocation = new Coordinate();
		
		for (int row = 0; row < map.getMap()[level].length; row++) {
			for (int col = 0; col < map.getMap()[level][row].length; col++) {
				if (map.getMap()[level][row][col].equals("W")) {
					wolverineLocation = new Coordinate(level, row, col);
				}
			}
		}
		
		
		return wolverineLocation;
	}
}
