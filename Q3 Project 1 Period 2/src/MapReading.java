import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MapReading {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		String[][][] map2 = readCoordinateMap(new File("coordinate.txt"));
		boolean stackBased = false;
		boolean queueBased = false;
		boolean optimal = false;
		boolean showTime = false;
		boolean inCoord = false;
		boolean outCoord = false;
		
		for (String arg : args) {
			if (arg.equals("--Stack")) {
				stackBased = true;
			}
			if (arg.equals("--Queue")) {
				queueBased = true;
			}
			if (arg.equals("--Optimal")) {
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
			}
		}
		
		if (queueBased && stackBased) {
			System.out.println("you may only choose one pathfinding approach!");
			System.exit(-1);
		}
		if (inCoord && outCoord) {
			System.out.println("map format cannot be both incoordinate and outcoordinate!");
			System.exit(-1);
		}
		
		
		
		printMap(map2);
	}
	
	public static String[][][] readMap(File file) throws FileNotFoundException{
		Scanner scanner = new Scanner(file);
		
		int numRows = scanner.nextInt();
		int numCols = scanner.nextInt();
		int numLevels = scanner.nextInt();
		
		String[][][] map = new String[numLevels][numRows][numCols];
		
		for (int level = 0; level < map.length; level++) {
			for (int row = 0; row < map[level].length; row++) {
				String line = scanner.next();
				for (int col = 0; col < map[level][row].length; col++) {
					map[level][row][col] = line.substring(col, col+1);
				}
			}
		}
		
		scanner.close();
		
		return map;
	}
	
	public static String[][][] readCoordinateMap(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		
		int numRows = scanner.nextInt();
		int numCols = scanner.nextInt();
		int numLevels = scanner.nextInt();
		
		String[][][] map = new String[numLevels][numRows][numCols];
		
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
		
		return map;
	}
	
	
	public static void printMap(String[][][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0 ; j < map[i].length; j++) {
				for (int k = 0; k < map[i][j].length; k++) {
					System.out.print(map[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
