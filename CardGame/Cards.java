package Card_Game;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author:
// date:
public class Cards {
    final int NOOFCARDSINFULLPACK = 52;

    // properties
    Card[] cards;
    int valid; // number of cards currently in collection

    // constructors
    public Cards(boolean fullPack) {
        cards = new Card[NOOFCARDSINFULLPACK];
        valid = 0;

        if (fullPack)
            createFullPackOfCards();
    }

    // methods
    public Card getTopCard() {
        Card tmp;

        if (valid <= 0)
            return null;
        else {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }

    public boolean addTopCard(Card c) {
        if (valid < cards.length) {
            cards[valid] = c;
            valid++;
            return true;
        }
        return false;
    }

    private void createFullPackOfCards() {
        for (int n = 0; n < NOOFCARDSINFULLPACK; n++) {
            addTopCard(new Card(n));
        }
    }

    public void shuffle() {
        int indexForFirstChosenCard;
        int indexForSecondChosenCard;
        Card temporary;

        for (int n = 0; n < NOOFCARDSINFULLPACK; n++) {
            // choosing random indexes from the cards array
            indexForFirstChosenCard = (int) (Math.random() * 52);
            indexForSecondChosenCard = (int) (Math.random() * 52);

            // swapping the randomly chosen cards
            temporary = cards[indexForFirstChosenCard];
            cards[indexForFirstChosenCard] = cards[indexForSecondChosenCard];
            cards[indexForSecondChosenCard] = temporary;
        }
    }
} // end class Cards
