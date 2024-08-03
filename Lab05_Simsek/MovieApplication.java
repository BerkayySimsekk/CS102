import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class MovieApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");

        stage.setHeight(500);
        stage.setWidth(1000);
        stage.setTitle("Movie Application");

        TilePane root = new TilePane();
        VBox subRoot1 = new VBox();
        HBox subRoot2 = new HBox();
        ScrollPane subRoot3 = new ScrollPane();
        VBox subRootOfSubRoot3 = new VBox();

        Scene scene = new Scene(root, 100, 100);

        TextArea movieInformation = new TextArea();
        Button saveToFile = new Button("SAVE TO FILE");

        movieInformation.setEditable(false);

        subRootOfSubRoot3.getChildren().addAll(movieInformation, saveToFile);
        subRootOfSubRoot3.setAlignment(Pos.CENTER);

        subRoot3.setContent(subRootOfSubRoot3);

        Label chooseYear = new Label("Choose Year: ");
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        ArrayList<Integer> yearList = new ArrayList<Integer>();
        yearList = movieDatabase.getYears();
        
        for(int n = 0; n < yearList.size(); n++) {
            choiceBox.getItems().add(yearList.get(n) + "");    
        }

        subRoot2.getChildren().addAll(chooseYear, choiceBox);

        ToggleGroup toggleGroup = new ToggleGroup();
        Label categories = new Label("Categories");
        RadioButton action = new RadioButton("action");
        RadioButton animation = new RadioButton("animation");
        RadioButton drama = new RadioButton("drama");
        RadioButton comedy = new RadioButton("comedy");
        RadioButton romance = new RadioButton("romance");

        action.setToggleGroup(toggleGroup);
        animation.setToggleGroup(toggleGroup);
        drama.setToggleGroup(toggleGroup);
        comedy.setToggleGroup(toggleGroup);
        romance.setToggleGroup(toggleGroup);

        action.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String movies = "";
                ArrayList<Movie> moviesList = new ArrayList<Movie>();
                moviesList = movieDatabase.searchMovies("action", Integer.valueOf(choiceBox.getValue()));

                for(int n = 0; n < moviesList.size(); n++) {
                    movies += moviesList.get(n);
                }

                movieInformation.setText(movies);  
            }
            
        });

        animation.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String movies = "";
                ArrayList<Movie> moviesList = new ArrayList<Movie>();
                moviesList = movieDatabase.searchMovies("animation", Integer.valueOf(choiceBox.getValue()));

                for(int n = 0; n < moviesList.size(); n++) {
                    movies += moviesList.get(n);
                }

                movieInformation.setText(movies);  
            }
            
        });

        drama.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String movies = "";
                ArrayList<Movie> moviesList = new ArrayList<Movie>();
                moviesList = movieDatabase.searchMovies("drama", Integer.valueOf(choiceBox.getValue()));

                for(int n = 0; n < moviesList.size(); n++) {
                    movies += moviesList.get(n);
                }

                movieInformation.setText(movies);  
            }
            
        });

        comedy.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String movies = "";
                ArrayList<Movie> moviesList = new ArrayList<Movie>();
                moviesList = movieDatabase.searchMovies("comedy", Integer.valueOf(choiceBox.getValue()));

                for(int n = 0; n < moviesList.size(); n++) {
                    movies += moviesList.get(n);
                }

                movieInformation.setText(movies);  
            }
            
        });

        romance.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String movies = "";
                ArrayList<Movie> moviesList = new ArrayList<Movie>();
                moviesList = movieDatabase.searchMovies("romance", Integer.valueOf(choiceBox.getValue()));

                for(int n = 0; n < moviesList.size(); n++) {
                    movies += moviesList.get(n);
                }

                movieInformation.setText(movies);  
            }
            
        });

        saveToFile.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    RadioButton r = (RadioButton)toggleGroup.getSelectedToggle();
                    FileWriter outStream = new FileWriter( r.getText() + choiceBox.getValue() + ".txt");
                    PrintWriter output = new PrintWriter(outStream);
                        
                    String outString = movieInformation.getText();
                    output.print(outString);
                    output.close();
                }
                catch(IOException ex){
                    System.err.println("Error Creating File");
                    System.exit(1);
                }
            }
            
        });

        subRoot1.getChildren().addAll(categories, action, animation, drama, comedy, romance);

        root.getChildren().addAll(subRoot2, subRoot1, subRoot3);

        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
