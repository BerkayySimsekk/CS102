public class MultipleChoice extends Question {
    private String choices;

    public MultipleChoice(String choices, String question, String correctAnswer) {
        super(question, correctAnswer);
        this.choices = choices;    
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String toString() {
        return "Here is the question: " + question + "\n" + choices;
    }

}
