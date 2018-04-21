
public class wayPT {
	private double x;
	private double y;
	private int time;

	public wayPT() {
		x = 0;
		y = 0;
		time = 0;
	}
	
	public wayPT(double a, double b, int c) {
		x = a;
		y = b;
		time = c;
	}

	public void setX(double xPoint) {
		x = xPoint;
	}

	public void setY(double yPoint) {
		y = yPoint;
	}

	public void setTime(int t) {
		time = t;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getTime() {
		return time;
	}
	public double findDist(wayPT b) {
		double a = Math.sqrt(((b.x - this.x) * (b.x - this.x)) + ((b.y - this.y) * (b.y - this.y)));
		return a;
	}
	public int timeLapse(wayPT b) {
		int a = b.time - this.time;
		return a;
	}
	public String toString() {
		return "(" + x + ", " + y + ", " + time + ")";
	}
}
