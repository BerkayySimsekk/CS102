import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
import java.util.*;
import java.io.*;

public class MovieList extends JFrame {
        private JComboBox yearcmb;
        private JRadioButton drama;
        private JRadioButton comedy;
        private JRadioButton animation;
        private JRadioButton horror;
        private JTextArea list;
        private Scanner movies;
        private JButton save;
                
        private String[] years = {	"2020",	"2021", "2022", "2023"};                            
     					 
    					   
        public MovieList (String title)
        {
        	
	       	setTitle(title);
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300,350);
     		MovieWindow();		  
      	}	
         
        private void MovieWindow() {
        	setLayout(new FlowLayout());
        	
        	JLabel yearLabel = new JLabel("Choose Year");
          	yearcmb = new JComboBox(years);
           	yearcmb.setSelectedIndex(0);
           	add(yearLabel);
          	add(yearcmb);
          
          	JPanel category_panel = new JPanel();
          	category_panel.setLayout(new BoxLayout(category_panel, BoxLayout.Y_AXIS));
          	category_panel.add(new JLabel("MOVIE Categories", JLabel.CENTER));
          	ButtonGroup category_group = new ButtonGroup();
          	
          	drama = new JRadioButton("Drama", false);
          	category_panel.add(drama);
          	category_group.add(drama);
          	comedy = new JRadioButton("Comedy", false);
          	category_panel.add(comedy);
          	category_group.add(comedy);
          	animation = new JRadioButton("Animation", false);
          	category_panel.add(animation);
          	category_group.add(animation);
          	horror = new JRadioButton("Horror", false);
          	category_panel.add(horror);
          	category_group.add(horror);
          	
          	add(category_panel);
          	
          	list = new JTextArea(8, 20);
          	
          	JScrollPane listScroll = new JScrollPane(list,
          	                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
          	                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
          	add(listScroll);         	                       
 			
 			save = new JButton("SAVE TO FILE");
          	
          	add(save);
          	
          	ButtonListener handler = new ButtonListener();   
          	yearcmb.addActionListener(handler);
      		drama.addActionListener(handler);
      		comedy.addActionListener(handler);
      		animation.addActionListener(handler);
      		horror.addActionListener(handler);   
      		
      		save.addActionListener(handler);
            
		}//end MovieWindow	
           	
           	private class ButtonListener implements ActionListener {
           	 	public void actionPerformed(ActionEvent event) {
           	 		if(event.getSource()== save){
           	 		  try{
           	 		  	FileWriter outStream = new FileWriter("outFile.txt");
						PrintWriter output = new PrintWriter(outStream);
           	 		  	 
           	 		  	String outString = list.getText();
           	 		  	output.print(outString);
           	 		  	System.out.println("File Written");
           	 		  	output.close();
           	 		  }
           	 		  catch(IOException ex){
           	 		  	System.err.println("Error Creating File");
			    		System.exit(1);
           	 		  }
           	 			
           	 		}
           	 		
           	 		else {
           	 			String index = (String)yearcmb.getSelectedItem();
		    	    	String movie="";	
		    	    	String name="";
		    	    	String type="";
		    	    	String year="";
		    	    	String hour="";
		    	
		    			list.setText("");
		    	
			    		try {
			    			movies = new Scanner(new File("movies.txt"));
			    			movies.useDelimiter(",");
			    		}
			    		catch(FileNotFoundException ex){
			    			System.err.println("Error Opening File");
			    			System.exit(1);
			    		}
						
						while(movies.hasNext()){
							name = movies.next();
							type = movies.next();
							year = movies.next();
							hour = movies.next();
							
							if(drama.isSelected()) {
						    	if((year.equals(index)) && (type.equals("Drama")))
									list.append(name.trim()+" Length: "+hour+"\n");
							}	
							if(comedy.isSelected()) {
						    	if((year.equals(index)) && (type.equals("Comedy")))
								 list.append(name.trim()+" Length: "+hour+"\n");
							}
							if(animation.isSelected()) {
						    	if((year.equals(index)) && (type.equals("Animation")))
								 	list.append(name.trim()+" Length: "+hour+"\n");
							}		
							if(horror.isSelected()) {
						    	if((year.equals(index)) && (type.equals("Horror")))
								 	list.append(name.trim()+" Length: "+hour+"\n");
							}
						}// end while
						movies.close();
           	 		}//end else
		  }//end actionperformed
     	}//end ButtonListener
 
	public static void main( String[] args)
     {
        MovieList window = new MovieList("MOVIE LIST");
        window.setVisible(true);
	 }
}