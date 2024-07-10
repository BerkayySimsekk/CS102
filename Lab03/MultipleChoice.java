/**
 * Exam represents a MultipleChoice question object.
 * 
 * @author (CS102) 
 * @version (2022-06-22)
 */
public class MultipleChoice extends Question {
    
    private String choices;

    public MultipleChoice(String question, String correctAnswer, String choices ){
        super( question, correctAnswer );
        this.choices = choices;
    }
    public String getChoices(){
        return choices;
    }
    public String displayQuestion(){
        String formatQuestion = super.displayQuestion();
        formatQuestion += "\n"+getChoices();
        return formatQuestion;
    }

}
