/**
 * @(#)MovieDatabase.java
 */

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class MovieDatabase {
 private ArrayList<Movie> movieList;
 
    public MovieDatabase( String filename ) {
     movieList = new ArrayList<Movie>();
     loadMovies( filename );
     JOptionPane.showMessageDialog( null, movieList.size() + " movies added...");
    }
    public void loadMovies( String fileName ){
     try{
      Scanner inFile = new Scanner( new File( fileName) );
      while( inFile.hasNext() ){
       String line = inFile.nextLine();
       String[] data = line.split(",");
       String name = data[0];
       String category = data[1];
       int year = Integer.parseInt( data[2] );
       double length = Double.parseDouble( data[3].trim() );
       movieList.add( new Movie(name, category, length, year) );
      } 
     }
     catch( IOException ex ){
      System.out.println("Unable to open file");
     }
     
    }
    public ArrayList<Movie> searchMovies( String category, int year ){
     ArrayList<Movie> matches = new ArrayList<Movie>();
     for( Movie m : movieList ){
      if(m.getCategory().equalsIgnoreCase(category) && m.getYear() == year){
       matches.add(m);
      }
     }
     return matches;
    }
    public ArrayList<Integer> getYears(){
     ArrayList<Integer> years = new ArrayList<Integer>();
     for( Movie m : movieList ){
      if( !years.contains(m.getYear())){
       years.add(m.getYear());
      }
     }
     Collections.sort(years);
     return years;
    }
    public ArrayList<String> getCategories(){
     ArrayList<String> categories = new ArrayList<String>();
     for( Movie m : movieList ){
      if( !categories.contains(m.getCategory())){
       categories.add(m.getCategory());
      }
     }
     Collections.sort( categories );
     return categories;
    }
}