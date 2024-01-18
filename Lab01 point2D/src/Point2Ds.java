import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Point2Ds {
	private Point2D[] points;
	
	public Point2D getPoint(int i) {
		// Return the point object at index i 
		
		// Put your code here 
		return points[i];
	}
	
	public void readFromFile(String filename) throws FileNotFoundException {
		// Read all points stored in filename
		// Store them in the array points 
		ArrayList<Point2D> listPoint = new ArrayList<Point2D>();
		 try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			   String strCurrentLine;

			   while ((strCurrentLine = br.readLine()) != null) {
			    String[] strArray = strCurrentLine.split(" ");
			    listPoint.add(new Point2D(Double.parseDouble(strArray[0]),Double.parseDouble(strArray[1]))); 
			   }
			   points = listPoint.toArray(new Point2D[0]);
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	
		// Put your code here 	
	}
	
	public Point2D getClosestPointToOrigin() {
		// Return the point that is closest to the origin 
		// Put your code here 
		Point2D origin = new Point2D(0,0);
		return getClosestPoint(origin.getX(),origin.getY());
	}

	public Point2D getClosestPoint(double x,double y) {
		// Return the point that is closest to x,y 

		// Put your code here 
		Point2D pointRef = new Point2D(x,y);
		Point2D pointToReturn = new Point2D(1000,1000);
		
		for(Point2D challenge:points) {
			if(challenge.distance(pointRef)< pointRef.distance(pointToReturn))
				pointToReturn = challenge;
		}
		
		return pointToReturn;
		
	}
}
