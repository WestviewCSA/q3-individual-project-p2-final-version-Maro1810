
public class Coordinate {
	
	private int x;
	private int y;
	private int level;
	public String symbol;
	
	public Coordinate prev;
	public boolean visited;
	
	public Coordinate(int level, int x, int y, String symbol) {
		this.level = level;
		this.x = x;
		this.y = y;
		this.symbol = symbol;
		
		prev = null;
		visited = false;
		
	}
	
	public Coordinate() {
		
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	

	public String toString() {
		return "(" + level + ", " + x + ", " + y + ")" + " prev: " + prev;
	}
}
