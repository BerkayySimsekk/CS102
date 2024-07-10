
/**
 * Exam represents an exam that has a list of questions.
 * 
 * @author (CS102) 
 * @version (2022-06-27)
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Exam implements Playable, Scoreable
{
   //List of Questions
   ArrayList<Question> exam;
   private boolean completed;
   private int totalScore;
   private int totalPoints;
    /**
     * Constructor for objects of class Exam
     */
    public Exam()
    {
       //initialize the list of questions
       exam = new ArrayList<Question>();
       completed = false;
       //add questions to the list
       exam.add(new Question("An array the same as an ArrayList (true/false)","false"));
       exam.add(new MultipleChoice("What is the purpose of a constructor?\n","a","a) To create objects and initialize their data\nb) To construct the application\nc)To display output to the user"));
       exam.add(new Question("Strings are immutable? (true/false)","true"));
       exam.add(new MultipleChoice("What does immutable mean?\n","b","a)A String is an instance of an object. \nb)Once created the object's data cannot be changed\nc)String class objects can be used in any application"));
       exam.add(new Question("You must use the new keyword to create a String object (true/false)","false"));
       exam.add(new ShortAnswer("What is a static data member?\n","A variable that belong to the class and not the object \n","variable","class","constant","shared"));
    }

  /**
     Displays all questions in exam, inputs their answer, 
     
     */
    public void takeExam(){
            //for each question in exam
            for(Question current : exam){
                //Display question and get result
                String answer = JOptionPane.showInputDialog(current.displayQuestion());
                //set the student answer
                current.setStudentAnswer(answer);
                //score the question
                current.setScore();
                //display if student answered correctly
                if(current.isAnswerCorrect()){
                    JOptionPane.showMessageDialog(null, "Your answer is correct!");
                }
                else {
                     JOptionPane.showMessageDialog(null, "Your answer is not correct!");
                }
            }
            completed = true;
            JOptionPane.showMessageDialog(null, "COMPLETED - Thank you for taking the exam");
            
            //grade the exam
            gradeExam();
            
            //display mistakes in the exam
            displayMistakes();
    }
    /**For all questions in the exam calculate and display the total score.*/
    public void gradeExam(){
        if(completed){
                totalScore=0;
                totalPoints=0;
            for(Question current : exam){
                totalScore+=current.getScore();
                totalPoints+=5;
            }
            //display the result
            JOptionPane.showMessageDialog(null, "Your score is "+totalScore+"/"+totalPoints);
            if(win()) {
                JOptionPane.showMessageDialog(null, "You won!");    
            }
            else {
                JOptionPane.showMessageDialog(null, "You lost!");  
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"ERROR - You must first complete the exam!");
        }
    }
    /**Displays each question in Exam answered incorrectly*/
    public void displayMistakes(){
        String mistakes = "";
        /*For each question in exam*/
        for(Question temp : exam){
            /*if answer is not correct*/
            if(!temp.isAnswerCorrect()){
                /*Concatenate question to output string (uses the Question's toString() method*/
                mistakes+=temp+"\n\n\n";
            }
        }
        /*Display the incorrect questions*/
        JOptionPane.showMessageDialog(null, mistakes);
    }
    public int calculateTotalPoints(){
        int total = 0;
        for(int n = 0; n < exam.size(); n++){
            total += Question.points;
        }
        return total;
    }

    @Override
    public int calculateScore() {
        return this.totalScore;  
    }

    @Override
    public void play() {
        takeExam();
    }

    @Override
    public boolean win() {
        return calculateScore() >= calculateTotalPoints() / 2;
    }
  
}
