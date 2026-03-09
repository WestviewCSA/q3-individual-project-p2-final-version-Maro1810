
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
	
	public Coordinate north() {
		return new Coordinate(this.x-1, y, level);
	}
	
	public Coordinate south() {
		return new Coordinate(this.x+1, y, level);
	}
	
	public Coordinate east() {
		return new Coordinate(x, this.y+1, level);
	}
	
	public Coordinate west() {
		return new Coordinate(x, this.y-1, level);
	}
}
