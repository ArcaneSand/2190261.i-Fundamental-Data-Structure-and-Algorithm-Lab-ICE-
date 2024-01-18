
public class Point2D {
	private double x;
	private double y;
	public Point2D(double x,double y) {
		// Store x,y in this.x,this.y

		// Put your code here 
		this.x = x;
		this.y = y;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double distance(Point2D other) {
		// Return a double that is the distance between this and other
		double xDis = Math.abs(this.x - other.x);
		double yDis = Math.abs(this.y - other.y);
		
		// Put your code here
		
		return Math.pow((Math.pow(xDis, 2)+ Math.pow( yDis,2)),0.5);
	}
}
