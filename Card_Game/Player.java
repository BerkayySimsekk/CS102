package Card_Game;

// Player - Simple card game player with name and hand of cards
// author:
// date:
public class Player {
    // properties
    String name;
    Cards hand;

    // constructors
    public Player(String name) {
        this.name = name;
        hand = new Cards(false);
    }

    // methods
    public String getName() {
        return name;
    }

    public Cards getHand() {
        return hand;
    }

    public void add(Card c) {
        hand.addTopCard(c);
    }

    public Card playCard() {
        Card playedCard;
        boolean isPlayed;

        isPlayed = false;
        playedCard = null;

        for (int n = hand.cards.length - 1; n >= 0 && !isPlayed; n--) {
            if (hand.cards[n] != null) {
                playedCard = hand.cards[n];
                hand.cards[n] = null;
                isPlayed = true;
            }
        }

        return playedCard;
    }

} // end class Player
