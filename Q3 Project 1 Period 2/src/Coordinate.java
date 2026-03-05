
public class Coordinate {
	
	private int x;
	private int y;
	private int level;
	
	public Coordinate(int level, int x, int y) {
		this.level = level;
		this.x = x;
		this.y = y;
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
}
