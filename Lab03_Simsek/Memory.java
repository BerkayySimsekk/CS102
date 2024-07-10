import java.util.Scanner;
import java.util.Random;

public class Memory extends CardGame {
	private Card firstCard;
	private Card secondCard;
	private Card[][] memoryDeck;
	private int guesses;
	private int matchFound;

	public static final int MAX_GUESSES = 52;
	
	public Memory(){
		matchFound = 0;
		guesses = 0;
		memoryDeck = new Card[4][13];
		int row = 0;
		int col = 0;
		while(row < 4){
			col = 0;
			while( col < 13 ){
				Random r = new Random();
				int card = r.nextInt(52);
				if(!deck[card].faceUp){
					memoryDeck[row][col] = new Card(deck[card]);
					deck[card].flip();
					col++;
				}	
			}
			row++;
		}
	}

	public void printGame(){
		for( int r = 0; r < 4; r++ ){
			for(int c = 0; c < 13; c++){
				if( !memoryDeck[r][c].isFlipped()){
					System.out.printf("%8s","******");
				}
				else {
					System.out.printf( "%8s",memoryDeck[r][c]);
				}
				
			}
			System.out.println();
		}
	}
	public boolean isMatch() {
		if(firstCard.getValue() == secondCard.getValue()) {
				firstCard.flip();
				secondCard.flip();
				return true;
		}
		return false;
	}

	@Override
	public void play() {
		int row;
		int col;

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		do {
			printGame();

			//first card
			System.out.print("Enter row and column of card: ");
			row = in.nextInt();
			col = in.nextInt();

			firstCard = memoryDeck[row][col];
			System.out.println(firstCard);

			//second card
			System.out.print("Enter row and column of card: ");
			row = in.nextInt();
			col = in.nextInt();

			secondCard = memoryDeck[row][col];
			System.out.println(secondCard);

			guesses++;

			//check for match
			if(isMatch()) {
				matchFound++;
				System.out.println("Match found!");
			}
			else {
				System.out.println("No match!");
			}

		}
		while(guesses < MAX_GUESSES && matchFound != MAX_GUESSES / 2);
		
		if(win()) {
			System.out.println("You won!");
		}
		else {
			System.out.println("You lost!");
		}
	}

	@Override
	public boolean win() {
		return guesses < MAX_GUESSES;
	}	
}