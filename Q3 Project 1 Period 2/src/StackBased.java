import java.io.FileNotFoundException;
import java.util.Stack;

public class StackBased {
	Map map;
	
	public StackBased(Map map) {
		this.map = map;
	}
	
	public void solve() throws FileNotFoundException {
		for (int l = 0; l < map.numLevels(); l++) {
			
		
		boolean found = false;
		
		Coordinate wolverineLocation = findWolverine(l);
		Coordinate endLocation = new Coordinate();
		
		Stack<Coordinate> stackedLocations = new Stack<Coordinate>();

		System.out.println(wolverineLocation);
		stackedLocations.push(wolverineLocation);
	

		while (!found) {
			Coordinate currLocation = stackedLocations.pop();
			
			Coordinate[] nextLocations = {map.north(currLocation), map.south(currLocation), map.east(currLocation), map.west(currLocation)};
			
				for (int i = 0; i < nextLocations.length; i++) {
					if (nextLocations[i] == null) {
						continue;
					}
					if (!nextLocations[i].symbol.equals("@")) {
						if (map.endSymbol(nextLocations[i])) {
							if (!nextLocations[i].visited) {
								nextLocations[i].visited = true;
								
								endLocation = nextLocations[i];
								
								endLocation.prev = currLocation;
								found = true;
								break;
							}
								
						}
							
						else if (nextLocations[i].symbol.equals(".")) {
							if (!nextLocations[i].visited) {
								nextLocations[i].visited = true;
								
								nextLocations[i].prev = currLocation;
								stackedLocations.push(nextLocations[i]);
							}
						}		
					}
				}
				
			}
			
			Coordinate c = endLocation.prev;
			
			while(c != null && c.symbol != null && !c.symbol.equals("W")) {
				map.setSymbol(c, "+");
				c = c.prev;
			}
			
		}
		

		System.out.println(map);
	}
	
	private Coordinate findWolverine(int level) {
		Coordinate wolverineLocation = new Coordinate();
		
		for (int row = 0; row < map.getMap()[level].length; row++) {
			for (int col = 0; col < map.getMap()[level][row].length; col++) {
				if (map.getMap()[level][row][col].symbol.equals("W")) {
					wolverineLocation = new Coordinate(level, row, col, "W");
				}
			}
		}
		
		
		return wolverineLocation;
	}

}