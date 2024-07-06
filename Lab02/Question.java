
/**
 * Exam represents a Questions object.
 * 
 * @author (CS102) 
 * @version (2022-06-22)
 */
public class Question {

    protected String question;
    protected String studentAnswer;
    protected String correctAnswer;
    protected int score;
    protected static int points=5;
    
    public Question(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.score = 0;
    }
    
    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
    

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    public int getScore() { 
        return score;
    }
    public void setScore(){
        if(correctAnswer.equalsIgnoreCase(studentAnswer)){
            score = points;
        }
    }
    public String displayQuestion(){
        return getQuestion();
    }
    public String toString(){
        return "Question: "+question+"\nYour Answer: "+studentAnswer+"\nCorrect Answer: "+correctAnswer;
    }
    
    public boolean isAnswerCorrect(){
        if(studentAnswer.equalsIgnoreCase(correctAnswer)){
            return true;
        }
        else {
            return false;
        }
    }
    
}
