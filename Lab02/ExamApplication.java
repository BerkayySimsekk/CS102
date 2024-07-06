import java.util.Scanner;

public class ExamApplication {
    public static void main(String[] args) {
        Exam exam = new Exam();
        
        run(exam);
    }

    public static void run(Exam exam) {
        int choice;
        boolean isTaken;

        Scanner in = new Scanner(System.in);

        choice = -1;
        isTaken = false;

        while(choice != 4) {
            System.out.println("1) Take the exam\n2) Grade the exam\n3) Display mistakes\n4) Quit");
            System.out.print("Enter the number of the option you want to choose: ");
            choice = in.nextInt();

            if(isTaken && choice == 1) {
                exam.setCompleted(false);
            }

            if(!exam.getCompleted() && choice == 1) {
                exam.takeExam();
                isTaken = true;
            }

            if(!exam.getCompleted() && choice == 2) {
                System.out.println("Take the exam first!");
            }

            if(!exam.getCompleted() && choice == 3) {
                System.out.println("Take the exam first!");
            }

            if(exam.getCompleted() && choice == 2) {
                exam.gradeExam();
            }

            if(exam.getCompleted() && choice == 3) {
                exam.displayMistakes();
            }

            if(choice == 4) {
                System.out.print("Exiting...");
            }
            
            System.out.println();
        }
    }
}
