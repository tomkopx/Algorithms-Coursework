package Travelling_Salesman;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

public class MyAlgorithm {
	
	public double getDistance(Point2D currentCity, Point2D possibleCity) {
		
		return Point2D.distance(currentCity.getX(), currentCity.getY(), possibleCity.getX(), possibleCity.getY());
	}
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

	public ArrayList<Point2D> algorithm(ArrayList<Point2D> cities){
		
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		Point2D closest = null;
		//Do not remove the first city in list, will cause the algorithm to skip the final city in result
		//This will ensure a random city start, might improve the route length
		Point2D currentCity = cities.get(randInt(0, cities.size()-1));
		
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
