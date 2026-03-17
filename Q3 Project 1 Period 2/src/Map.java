import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Map {
	
//	public static void main(String[] args) throws FileNotFoundException {
//	
////		boolean stackBased = false;
////		boolean queueBased = false;
////		boolean optimal = false;
////		boolean showTime = false;
////		boolean inCoord = false;
////		boolean outCoord = false;
////		
////		for (String arg : args) {
////			if (arg.equals("--Stack")) {
////				stackBased = true;
////			}
////			if (arg.equals("--Queue")) {
////				queueBased = true;
////			}
////			if (arg.equals("--Optimal")) {
////				optimal = true;
////			}
////			if (arg.equals("--Time")) {
////				showTime = true;
////			}
////			if (arg.equals("--Incoordinate")) {
////				inCoord = true;
////			}
////			if (arg.equals("--Outcoordinate")) {
////				outCoord = true;
////			}
////			if (arg.equals("--Help")) {
////				System.out.println("help message");
////			}
////		}
////		
////		if (queueBased && stackBased) {
////			System.out.println("you may only choose one pathfinding approach!");
////			System.exit(-1);
////		}
////		if (inCoord && outCoord) {
////			System.out.println("map format cannot be both incoordinate and outcoordinate!");
////			System.exit(-1);
////		}
//		
//	}

	Coordinate[][][] map;
	boolean coordinateBased;
	File file;
	private int numRows;
	private int numCols;
	private int numLevels;
	
	public Map(File file, boolean coordinateBased) throws FileNotFoundException, IllegalMapCharacterException, IncorrectMapFormatException {
		this.file = file;
		this.coordinateBased = coordinateBased;
		
		readMap();
	}
	
	
	private void readMap() throws FileNotFoundException, IllegalMapCharacterException, IncorrectMapFormatException{
		Scanner scanner = new Scanner(file);
		
		
		numRows = scanner.nextInt();
		numCols = scanner.nextInt();
		numLevels = scanner.nextInt();
		
		if (numRows <= 0 || numCols <= 0 || numLevels <= 0) {
			scanner.close();
			throw new IncorrectMapFormatException("Number of rows, columns, and levels must be a positive integer!");
		}
		
		map = new Coordinate[numLevels][numRows][numCols];
		
		if (!coordinateBased) {
			
			for (int level = 0; level < map.length; level++) {
				for (int row = 0; row < map[level].length; row++) {
					String line = scanner.next();
					for (int col = 0; col < map[level][row].length; col++) {
						String symbol = line.substring(col, col+1);
						
						if (!symbol.equals("@") && !symbol.equals("W") && !symbol.equals("|") && !symbol.equals("$") 
								&& !symbol.equals(".")) {
							scanner.close();
							throw new IllegalMapCharacterException("Symbols must be W, |, $, ., or @!");	
						}
						
						map[level][row][col] = new Coordinate(level, row, col, symbol);
					}
				}
			}
			
			scanner.close();

		}
		else {
			while (scanner.hasNext()) {
				String symbol = scanner.next();
				int row = Integer.parseInt(scanner.next());
				int col = Integer.parseInt(scanner.next());
				int level = Integer.parseInt(scanner.next());
				
				if (row <= 0 || col <= 0 || level <= 0) {
					scanner.close();
					throw new IncorrectMapFormatException("Number of rows, columns, and levels must be a positive integer!");
				}
				
				map[level][row][col] = new Coordinate(level, row, col, symbol);
				
				if (!symbol.equals("@") && !symbol.equals("W") && !symbol.equals("|") && !symbol.equals("$") 
						&& !symbol.equals(".")) {
					scanner.close();
					throw new IllegalMapCharacterException("Symbols must be W, |, $, ., or @!");	
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					for (int k = 0; k < map[i][j].length; k++) {
						if (map[i][j][k] == null) {
							map[i][j][k] = new Coordinate(i, j, k, ".");
						}
					}
				}
			}
			scanner.close();
			
		}
	}
	
	public void setSymbol(Coordinate coord, String symbol) {
		map[coord.getLevel()][coord.getX()][coord.getY()].symbol = symbol;
	}
	 /*
	  * precondition: coord is a valid coordinate in the map
	  */
//	public String getSymbol(Coordinate coord) {
//		return map[coord.getLevel()][coord.getX()][coord.getY()];
//	}
	
	public Coordinate north(Coordinate coord) {
		if (inBounds(new Coordinate(coord.getLevel(), coord.getX()-1, coord.getY(), "."))) {
			return map[coord.getLevel()][coord.getX()-1][coord.getY()];
		}
		return null;
	}
	
	public Coordinate south(Coordinate coord) {
		if (inBounds(new Coordinate(coord.getLevel(), coord.getX()+1, coord.getY(), "."))) {
			return map[coord.getLevel()][coord.getX()+1][coord.getY()];
		}
		return null;
	}
	
	public Coordinate east(Coordinate coord) {
		if (inBounds(new Coordinate(coord.getLevel(), coord.getX(), coord.getY()+1, "."))) {
			return map[coord.getLevel()][coord.getX()][coord.getY()+1];
		}
		return null;
	}
	
	public Coordinate west(Coordinate coord) {
		if (inBounds(new Coordinate(coord.getLevel(), coord.getX(), coord.getY()-1, "."))) {
			return map[coord.getLevel()][coord.getX()][coord.getY()-1];
		}
		return null;
	}
	
	public boolean inBounds(Coordinate coord) {
		return (coord.getX() >= 0 && coord.getX() < numRows &&
				coord.getY() >= 0 && coord.getY() < numCols &&
				coord.getLevel() >= 0 && coord.getLevel() < numLevels);
	}
	
	public Coordinate[][][] getMap() {
		return map;
	}
	
	public boolean endSymbol(Coordinate coord) {
		return coord.symbol.equals("|") || coord.symbol.equals("$");
	}
	
	public int numLevels() {
		return numLevels;
	}
	
	public String toString() {
		String res = "";
		for (int i = 0; i < map.length; i++) {
			for (int j = 0 ; j < map[i].length; j++) {
				for (int k = 0; k < map[i][j].length; k++) {
					res += map[i][j][k].symbol;
				}
				res += "\n";
			}
			res += "\n";
		}
		
		return res;
	}
}

class IllegalCommandLineInputsException extends Exception {
	public IllegalCommandLineInputsException(String message) {
		super(message);
	}
}

class IllegalMapCharacterException extends Exception {
	public IllegalMapCharacterException(String message) {
		super(message);
	}
}

class IncompleteMapException extends Exception {
	public IncompleteMapException(String message) {
		super(message);
	}
}

class IncorrectMapFormatException extends Exception {
	public IncorrectMapFormatException(String message) {
		super(message);
	}
}
