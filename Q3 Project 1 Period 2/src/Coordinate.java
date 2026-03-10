
public class Coordinate {
	
	private int x;
	private int y;
	private int level;
	public Coordinate prev;
	
	public Coordinate(int level, int x, int y) {
		this.level = level;
		this.x = x;
		this.y = y;
		
		prev = null;
		
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
	
	public Coordinate north() {
		return new Coordinate(level, this.x-1, this.y);
	}
	
	public Coordinate south() {
		return new Coordinate(level, this.x+1, this.y);
	}
	
	public Coordinate east() {
		return new Coordinate(level, this.x, this.y+1);
	}
	
	public Coordinate west() {
		return new Coordinate(level, this.x, this.y-1);
	}

	public String toString() {
		return "(" + level + ", " + x + ", " + y + ")" + " prev: " + prev;
	}
}
