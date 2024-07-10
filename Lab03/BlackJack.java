import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack extends CardGame{
	private ArrayList<Card> playerHand = new ArrayList<Card>();
	private ArrayList<Card> dealerHand = new ArrayList<Card>();
	
	public void play(){
		Random r = new Random();
		int card = r.nextInt(51);
		dealerHand.add(deck[card]);
		dealerHand.add(deck[r.nextInt(51)]);
		
		playerHand.add(deck[r.nextInt(51)]);
		playerHand.add(deck[r.nextInt(51)]);	
		System.out.println(playerHand);
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Hit or Stay");
		String choice = input.next();
		
		while(choice.equalsIgnoreCase("HIT")){
			playerHand.add(deck[r.nextInt(51)]);	
			System.out.println(playerHand);
			System.out.println("Enter Hit or Stay");
			choice = input.next();
		}
		if(win()){
			System.out.println("Hurray you're a winner!");
			
		}
		else {
			System.out.println("Sorry try again");
		}
		
		
	}
	public boolean win(){
		int dealerScore=0;
		int playerScore = 0;
		for(int i = 0; i < dealerHand.size(); i++){
			dealerScore += dealerHand.get(i).getValue(); 
		}
		for(int j = 0; j < playerHand.size(); j++){
			playerScore+= playerHand.get(j).getValue();
		}
		if(playerScore > 21) {
			return false;
		}
		else return (playerScore > dealerScore);
	}
}