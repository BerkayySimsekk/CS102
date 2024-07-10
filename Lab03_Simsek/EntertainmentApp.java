/**
 * Application class for Exam
 * 
 * @author (Lori Russell Dag) 
 * @version (2022-06-27)
 */
import javax.swing.JOptionPane;
public class EntertainmentApp
{
    
    public static void main(String[] args) {
        run();       
    }
    
    public static void run( ){
        Exam myExam = new Exam();
        Memory memory = new Memory();
        BlackJack blackJack = new BlackJack();

        String menu = "1. Take Exam\n2.Play Memory\n3.Play BlackJack \n4. Quit";
        
        //display menu and get result
        int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
        
        //while not exit
        while(choice != 4){
            if(choice == 1){
                myExam.play();
            }
            else if(choice == 2){
                memory.play();
            }
            else if( choice == 3){
            	blackJack.play();
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Choice - Try again");
            }
            //get next choice
            choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
        }
        
    }
}
