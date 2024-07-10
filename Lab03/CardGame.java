public abstract class CardGame implements Playable {
	
	Card[] deck = new Card[52];
		
	public CardGame(){
		int cardValue;
		for(int i = 0; i < 13; i++){
			deck[i] = new Card("Hearts", i+1);
		}
		cardValue = 1;
		for(int i = 13; i < 26; i++){
			deck[i] = new Card("Diamonds", cardValue);
			cardValue++;
		}
		cardValue=1;
		for(int i = 26; i < 39; i++){
			deck[i] = new Card("Spades", cardValue);
			cardValue++;
		}
		cardValue=1;
		for(int i = 39; i < 52; i++){
			deck[i] = new Card("Clubs", cardValue);
			cardValue++;
		}
	}
}