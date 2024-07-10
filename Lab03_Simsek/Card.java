
public class Card {
	
	String suit;
	int value;
	boolean faceUp;
	
	public Card(String suit, int val){
		this.suit = suit;
		value = val;
		faceUp = false;
	}
	public Card(Card c){
		this.suit = c.suit;
		this.value = c.value;
		this.faceUp = false;
	}
	public void flip(){
		faceUp = !faceUp;
	}
	public boolean isFlipped(){
		return faceUp;
	}
	public void setIsFlipped(boolean isFlipped) {
		this.faceUp = isFlipped;
	}
	public void setSuit(String suit){
		this.suit = suit;
	}
	public String getSuit(){
		return suit;
	}
	public void setValue(int val){
		value = val;
	}
	public int getValue(){
		return value;
	}
	public String toString(){
		String s, v;
		switch(suit){
		
			case "Hearts":
				s = "H";
				break;
			case "Spades":
				s = "S";
				break;	
			case "Diamonds":
				s = "D";
				break;
			default:
				s = "C";
		}
		switch(value){
			case 1: 
				v = "ACE";
				break;
			case 2:
			case 3:
			case 4:
			case 5: 
			case 6:
			case 7:
			case 8:
			case 9:
				v = value + "";
				break;
			case 10:
				v = "JACK";
				break;
			case 11:
				v = "QUEEN";
				break;
			default:
				v = "KING";
				break;
		}
		return v +" "+s;
	}
}