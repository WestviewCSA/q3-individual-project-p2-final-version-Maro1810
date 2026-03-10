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
	
	String[][][] map;
	boolean coordinateBased;
	File file;
	private int numRows;
	private int numCols;
	private int numLevels;
	
	public Map(File file, boolean coordinateBased) throws FileNotFoundException {
		this.file = file;
		this.coordinateBased = coordinateBased;
		
		readMap();
	}
	
	
	private void readMap() throws FileNotFoundException{
		Scanner scanner = new Scanner(file);
		
		
		numRows = scanner.nextInt();
		numCols = scanner.nextInt();
		numLevels = scanner.nextInt();
		
		map = new String[numLevels][numRows][numCols];
		
		if (!coordinateBased) {
			
			for (int level = 0; level < map.length; level++) {
				for (int row = 0; row < map[level].length; row++) {
					String line = scanner.next();
					for (int col = 0; col < map[level][row].length; col++) {
						map[level][row][col] = line.substring(col, col+1);
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
				
				map[level][row][col] = symbol;
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					for (int k = 0; k < map[i][j].length; k++) {
						if (map[i][j][k] == null) {
							map[i][j][k] = ".";
						}
					}
				}
			}
			scanner.close();
			
		}
	}
	
	public void setSymbol(Coordinate coord, String symbol) {
		map[coord.getLevel()][coord.getX()][coord.getY()] = symbol;
	}
	 /*
	  * precondition: coord is a valid coordinate in the map
	  */
	public String getSymbol(Coordinate coord) {
		return map[coord.getLevel()][coord.getX()][coord.getY()];
	}
	
	public boolean inBounds(Coordinate coord) {
		return (coord.getX() >= 0 && coord.getX() < numRows &&
				coord.getY() >= 0 && coord.getY() < numCols &&
				coord.getLevel() >= 0 && coord.getLevel() < numLevels);
	}
	
	public String[][][] getMap() {
		return map;
	}
	
	public boolean endSymbol(Coordinate coord) {
		return getSymbol(coord).equals("|") || getSymbol(coord).equals("$");
	}
	
	public int numLevels() {
		return numLevels;
	}
	
	public String toString() {
		String res = "";
		for (int i = 0; i < map.length; i++) {
			for (int j = 0 ; j < map[i].length; j++) {
				for (int k = 0; k < map[i][j].length; k++) {
					res += map[i][j][k];
				}
				res += "\n";
			}
			res += "\n";
		}
		
		return res;
	}
}
