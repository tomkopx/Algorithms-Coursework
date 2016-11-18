package Travelling_Salesman;

import java.awt.geom.Point2D;
import java.util.ArrayList;


public class Main {
	
	//Function that calculates the route length
	public static double routeLength(ArrayList<Point2D> cities) {
		//Calculate the length of a TSP route held in an ArrayList as a set of Points
		double result=0; //Holds the route length
		Point2D prev = cities.get(cities.size()-1);
		//Set the previous city to the last city in the ArrayList as we need to measure the length of the entire loop
		for(Point2D city : cities){
			//Go through each city in turn
			result += city.distance(prev);
			//get distance from the previous city
			prev = city;
			//current city will be the previous city next time
		}
		return result;
	}

	//Main method used for running the algorithms
	public static void main(String[] args) {
		
		//Create objects to call the algorithms
		NearestNeighbour neighbour = new NearestNeighbour();
		Limit limit = new Limit();
		SortLimit sort = new SortLimit();
					
		ArrayList<Point2D> cities = new ArrayList<Point2D>();
				
		//All the city files here, uncomment the one you want to use
		
		//cities = FileLoader.loadTSPLib("src/Travelling_Salesman/berlin52.tsp");
		//cities = FileLoader.loadTSPLib("src/Travelling_Salesman/d493.tsp");
		//cities = FileLoader.loadTSPLib("src/Travelling_Salesman/rl1889.tsp");
		//cities = FileLoader.loadTSPLib("src/Travelling_Salesman/rl5915.tsp");
		//cities = FileLoader.loadTSPLib("src/Travelling_Salesman/rl11849.tsp");

		System.out.println("Before ArrayList size: " + cities.size());
		System.out.format("Before route length: %f%n", routeLength(cities));

		
		//Store the system time before running the algorithm
		final double startTime = System.currentTimeMillis();
		
		//Uncomment the algorithm you want to use
		
		//cities = neighbour.nearestNeighbour(cities);
		//cities = limit.algorithm(cities);
		//cities = sort.algorithm(cities);
		
		//Store the system time after running an algorithm
		final double endTime = System.currentTimeMillis();
		
		
		System.out.println("After ArrayList size: " + cities.size());
		System.out.format("After route length: %f%n", routeLength(cities));
		
		//Display the time taken to complete the algorithm
		System.out.format("Time to run algorithm: %fms%n", (endTime - startTime));
		
	}

}
