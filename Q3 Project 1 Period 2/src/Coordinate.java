
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
	
//	public Coordinate north() {
//		return new Coordinate(level, this.x-1, this.y);
//	}
//	
//	public Coordinate south() {
//		return new Coordinate(level, this.x+1, this.y);
//	}
//	
//	public Coordinate east() {
//		return new Coordinate(level, this.x, this.y+1);
//	}
//	
//	public Coordinate west() {
//		return new Coordinate(level, this.x, this.y-1);
//	}

	public String toString() {
		return "(" + level + ", " + x + ", " + y + ")" + " prev: " + prev;
	}
}
