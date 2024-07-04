package assignment_9;

public class Point {
	int xCord;
	int yCord;
	
	public Point(int xCord, int yCord) {
		super();
		this.xCord = xCord;
		this.yCord = yCord;
	}

	public int getXCord() {
		return xCord;
	}

	public void setXCord(int xCord) {
		this.xCord = xCord;
	}

	public int getYCord() {
		return yCord;
	}

	public void setYCord(int yCord) {
		this.yCord = yCord;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || getClass() != obj.getClass()) {
			return false;
		}
		Point point = (Point) obj;
		return xCord==point.xCord && yCord==point.yCord;
	}

	@Override
	public String toString() {
		return "Point [xCord=" + xCord + ", yCord=" + yCord + "]";
	}
	
	
}
