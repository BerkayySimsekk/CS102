public class ShortAnswer extends Question {
    private String[] keywords;

    public ShortAnswer (String[] keywords, String question, String correctAnswer ) {
        super(question, correctAnswer);
        this.keywords = keywords;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public boolean isAnswerCorrect() {
        int counter;
        
        counter = 0;

        for(int n = 0; n < keywords.length; n++) {
            if(studentAnswer.contains(keywords[n])) {
                counter++;
            }
        }

        return counter > keywords.length / 2;
    }
}
