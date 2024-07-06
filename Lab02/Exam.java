import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    final int MAX_SCORE = 15;

    int score;
    ArrayList<Question> exam;
    boolean completed;
    ArrayList<Question> incorrectlyAnsweredQuestions;

    public Exam() {
        score = 0;
        completed = false;
        exam = new ArrayList<Question>();
        incorrectlyAnsweredQuestions = new ArrayList<Question>();

        String[] keywords = {"variable", "class", "object"};
        Question q1 = new Question("An array the same as an ArrayList (true/false)", "false");
        MultipleChoice m1 = new MultipleChoice("a. Because of single inheritance, Mammal can have no subclasses.\nb. Because of single inheritance, Mammal can have no other parent than Animal.\n c. Because of single inheritance, Animal can have only one subclass. ", "A class Animal has a subclass Mammal. Which of the following is true:", "b");
        ShortAnswer s1 = new ShortAnswer(keywords, "What is a static data member?", "A variable that belong to the class and not the object");
        exam.add(q1); exam.add(m1); exam.add(s1);
    }

    public boolean getCompleted() {
        return completed;
    }

    public ArrayList<Question> getExam() {
        return exam;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setExam(ArrayList<Question> exam) {
        this.exam = exam;
    }

    public void takeExam() {
        Scanner in = new Scanner(System.in);

        System.out.println("Questions: ");
        //first and second questions
        for(int n = 0; n < 2; n++) {
            System.out.println(exam.get(n).getQuestion());
            System.out.print("Please enter your answer: ");
            exam.get(n).setStudentAnswer(in.nextLine());

            if(exam.get(n).getStudentAnswer().equals(exam.get(n).getCorrectAnswer())) {
                exam.get(n).setScore();
                score += exam.get(n).getScore();
                System.out.println("You answered correctly!");
            }
            else {
                incorrectlyAnsweredQuestions.add(exam.get(n));
                System.out.println("You answered incorrectly!");
            }

            System.out.println();
        }

        //third question
        System.out.println(exam.get(2).getQuestion());
        System.out.print("Please enter your answer: ");
        exam.get(2).setStudentAnswer(in.nextLine());  
        
        if(exam.get(2).isAnswerCorrect()) {
            exam.get(2).setScore();
            score += exam.get(2).getScore();
            System.out.println("You answered correctly!");
        }
        else {
            incorrectlyAnsweredQuestions.add(exam.get(2));
            System.out.println("You answered incorrectly!");
        }

        System.out.println();

        completed = true;
    }

    public void clearIncorrectlyAnsweredQuestionsList() {
        incorrectlyAnsweredQuestions.clear();
    }

    public void gradeExam() {
        if(completed) {
            System.out.println("Your score is: " + score + "/" + MAX_SCORE);
        }
    }

    public void displayMistakes() {
        System.out.println("Incorrectly answered questions: ");

        for(int n = 0; n < incorrectlyAnsweredQuestions.size(); n++) {
            System.out.println(incorrectlyAnsweredQuestions.get(n).getQuestion());
            System.out.println("The correct answer was: " + incorrectlyAnsweredQuestions.get(n).getCorrectAnswer());
        }
    }
}
