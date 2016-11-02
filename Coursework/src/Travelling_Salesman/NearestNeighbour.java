package Travelling_Salesman;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class NearestNeighbour {
	
	public double getDistance(Point2D currentCity, Point2D possible){
		
		return Point2D.distance(currentCity.getX(), currentCity.getY(), possible.getX(), possible.getY());
	}

	public ArrayList<Point2D> nearestNeighbour(ArrayList<Point2D> cities){
		
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		Point2D closest = null;
		Point2D currentCity = cities.remove(0);
		
		while(cities.size() > 0){
			
			result.add(currentCity);
			
			double distance = Double.POSITIVE_INFINITY;
			
			for(Point2D city : cities){
				if(getDistance(currentCity, city) < distance){
					closest = city;
					distance = getDistance(currentCity, city);
				}
			}
			cities.remove(closest);
			
			currentCity = closest;
		}
		
		return result;
	}
	
}
