/**
 * @(#)Movie.java
 */
public class Movie {
 private String movieName;
 private String category;
 private double length;
 private int year;

    public Movie( String movieName, String category, double length, int year) {
     this.movieName = movieName;
     this.category = category;
     this.length = length;
     this.year = year;
    }
    public String getMovieName(){
     return movieName;
    }
    public String getCategory(){
     return category;
    }
    public double getLength(){
     return length;
    }
    public int getYear(){
     return year;
    }
    public String toString(){
     return movieName + "," + category + "," + year + "," + length + "\n";
    }
}