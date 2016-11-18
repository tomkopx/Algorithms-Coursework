package Travelling_Salesman;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Limit {
	
	//Function to get the distance between 2 locations
	public double getDistance(Point2D currentCity, Point2D possibleCity) {
		
		return Point2D.distance(currentCity.getX(), currentCity.getY(), possibleCity.getX(), possibleCity.getY());
	}
	

	public ArrayList<Point2D> algorithm(ArrayList<Point2D> cities){
		
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		Point2D closest = null;
		
		//Do not remove the first city in list, will cause the algorithm to skip the final city in result
		Point2D currentCity = cities.get(0);
		
		while(cities.size() > 0) {
			
			result.add(currentCity);
			
			//Remove the current city here to avoid skipping the last city from final result
			cities.remove(currentCity);
			
			double distance = Double.POSITIVE_INFINITY;
			
			for(Point2D city : cities) {
				if(getDistance(currentCity, city) < distance) {
					closest = city;
					distance = getDistance(currentCity, city);
					//I'm putting a limit on the distance as assumption that not many distances will be smaller than 50 so I can save some time by breaking the loop when first value lower than 50 is encountered 
					if (distance < 50){
						break;
					}
				}
			}
			
			currentCity = closest;
			
		}
			
		return result;
	}
}
