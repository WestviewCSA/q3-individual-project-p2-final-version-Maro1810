import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class QueueBased {
	
	Map map;
	double time = System.currentTimeMillis();
	
	public QueueBased(Map map) {
		this.map = map;
	}
	
	public Map queueBasedSolution() throws FileNotFoundException {
		for (int l = 0; l < map.numLevels(); l++) {
			
		
		boolean found = false;
		
		Coordinate wolverineLocation = findWolverine(l);
		Coordinate endLocation = new Coordinate();
		
		Queue<Coordinate> queuedLocations = new LinkedList<Coordinate>();
		Queue<Coordinate> visitedLocations = new LinkedList<Coordinate>();
		System.out.println(wolverineLocation);
		queuedLocations.add(wolverineLocation);

		while (!found) {
			Coordinate currLocation = queuedLocations.remove();
			visitedLocations.add(currLocation);
			
			Coordinate[] nextLocations = {currLocation.north(), currLocation.south(), currLocation.east(), currLocation.west()};
			
				for (int i = 0; i < nextLocations.length; i++) {
					if (map.inBounds(nextLocations[i]) && !map.getSymbol(nextLocations[i]).equals("@")) {
						if (map.endSymbol(nextLocations[i])) {
							if (!contains(queuedLocations, nextLocations[i]) && !contains(visitedLocations, nextLocations[i])) {
								endLocation = nextLocations[i];
								endLocation.prev = currLocation;
								found = true;
								break;
							}
								
						}
							
						else if (map.getSymbol(nextLocations[i]).equals(".")) {
							if (!contains(queuedLocations, nextLocations[i]) && !contains(visitedLocations, nextLocations[i])) {
								nextLocations[i].prev = currLocation;
								queuedLocations.add(nextLocations[i]);
							}
						}		
					}
				}
				
			}
			
			Coordinate c = endLocation.prev;
			
			while(c != null && !map.getSymbol(c).equals("W")) {
				map.setSymbol(c, "+");
				c = c.prev;
			}
			
		}
		
		time = System.currentTimeMillis() - time;

		return map;
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

	private boolean contains(Queue<Coordinate> queue, Coordinate coordinate) {
		for (Coordinate c : queue) {
			if (c.getLevel() == coordinate.getLevel() && c.getX() == coordinate.getX() && c.getY() == coordinate.getY()) {
				return true;
			}
		}
		return false;
	}
}
