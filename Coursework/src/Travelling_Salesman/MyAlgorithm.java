package Travelling_Salesman;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class MyAlgorithm {
	
	public double getDistance(Point2D currentCity, Point2D possibleCity) {
		
		return Point2D.distance(currentCity.getX(), currentCity.getY(), possibleCity.getX(), possibleCity.getY());
	}
	
	//Random number generator for the random starting city
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
		
		//Sorting the arrayList from biggest to lowest in both coordinates
		Collections.sort(cities, new Comparator<Point2D>(){

			@Override
			public int compare(Point2D p1, Point2D p2) {
				
				double a = Math.sqrt(Math.pow(p1.getX(), 2) + Math.pow(p1.getY(),2));
				
				double b = Math.sqrt(Math.pow(p2.getX(), 2) + Math.pow(p2.getY(),2));
				
				if(a < b){
					return 1;
				}
				if(a > b){
					return -1;
				}
				
				return 0;
			}
			
		});
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
