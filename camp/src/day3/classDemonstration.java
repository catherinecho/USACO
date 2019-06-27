package day3;
import java.util.*;
public class classDemonstration {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Star Wars", 8.8, 1980));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));
		System.out.println("Sorted by rating");
		RatingCompare ratingCompare = new RatingCompare();
		Collections.sort(list, ratingCompare);
		for(Movie movie: list) {
			System.out.println(movie.getRating()+" " + movie.getName() + " " + movie.getYear());
		}
		System.out.println("\nSorted by name");
		NameCompare nameCompare = new NameCompare();
		Collections.sort(list, nameCompare);;
		for(Movie movie: list) {
			System.out.println(movie.getRating()+" " + movie.getName() + " " + movie.getYear());
		}
		System.out.println("\nSorted by year");
		Collections.sort(list);
		for(Movie movie: list) {
			System.out.println(movie.getRating()+" " + movie.getName() + " " + movie.getYear());
		}
	}
}
class Movie implements Comparable<Movie>{
	private double rating;
	private String name;
	private int year;
	public int compareTo(Movie m) {
		if( m.year - this.year != 0) {
			return m.year - this.year;
		}else {
			return this.getName().compareTo(m.getName());
		}
		
	}
	public Movie(String nm, double rt, int yr) {
		this.name = nm;
		this.rating = rt;
		this.year = yr;
	}
	public double getRating() {return rating;}
	public String getName() {return name;}
	public int getYear() {return year;}
	
}
class RatingCompare implements Comparator<Movie>{
	public int compare(Movie m1, Movie m2) {
		if(m1.getRating() < m2.getRating()) {
			return -1;
		}else if(m1.getRating() < m2.getRating()) {
			return 1;
		}else {
			if(m1.getYear() < m2.getYear()) {
				return -1;
			}
			else {
				return 1;
			}
		}
			
	}
}
class NameCompare implements Comparator<Movie>{
	public int compare(Movie m1, Movie m2) {
		return m1.getName().compareTo(m2.getName());
	}
}