/**
 * Exam represents a ShortAnswer question object.
 * 
 * @author (CS102) 
 * @version (2022-06-22)
 */

public class ShortAnswer extends Question {
    
    private String[] keywords;
    public ShortAnswer(String question, String correctAnswer, String...keywords ){
        super( question, correctAnswer );
        this.keywords = keywords;
    }
    public boolean isAnswerCorrect(){
        int len = keywords.length;
        int count = 0;
        for( String kw : keywords ){
            if( studentAnswer.contains(kw)){
                count++;
            }
        }
        return count > (len / 2) + 1;
    }
}
