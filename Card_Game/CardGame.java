package Card_Game;

import java.util.ArrayList;
import java.util.Arrays;

// Cardgame
// author:
// date:
public class CardGame {
    // properties
    Cards fullPack;
    Player[] players;
    ScoreCard scoreCard;
    Cards[] cardsOnTable;
    int roundNo;
    int turnOfPlayer;

    // constructors
    public CardGame(Player p1, Player p2, Player p3, Player p4) {
        players = new Player[4];
        players[0] = p1;
        players[1] = p2;
        players[2] = p3;
        players[3] = p4;
        scoreCard = new ScoreCard(players.length);

        fullPack = new Cards(true);
        fullPack.shuffle();
        dealCardsToPlayers();

        cardsOnTable = new Cards[fullPack.NOOFCARDSINFULLPACK / players.length];
        for (int i = 0; i < fullPack.NOOFCARDSINFULLPACK / players.length; i++) {
            cardsOnTable[i] = new Cards(false);
        }
        roundNo = 0;
        turnOfPlayer = 0;
    }

    // methods
    public boolean playTurn(Player p, Card c) {
        if (isGameOver() || !isTurnOf(p)) {
            return false;
        }

        turnOfPlayer++;
        turnOfPlayer = turnOfPlayer % players.length;

        Cards currentRoundCards = cardsOnTable[roundNo];
        currentRoundCards.addTopCard(c);

        if (turnOfPlayer == 0) {
            // The round has ended
            Player[] winners = getCurrentRoundWinners();
            for (Player winner : winners) {
                if (winner != null) {
                    int playerNo = getPlayerNo(winner);
                    scoreCard.update(playerNo, 1);
                }
            }
            roundNo++;
        }

        return true;
    }

    public boolean isTurnOf(Player p) {

        return turnOfPlayer == getPlayerNo(p);
    }

    public boolean isGameOver() {
        return roundNo == fullPack.NOOFCARDSINFULLPACK / players.length;
    }

    public int getScore(int playerNumber) {
        return scoreCard.getScore(playerNumber);
    }

    public String getName(int playerNumber) {
        return this.players[playerNumber].getName();
    }

    public int getRoundNo() {
        return roundNo;
    }

    public int getTurnOfPlayerNo() {
        return turnOfPlayer;
    }

    public Player[] getWinners() {
        int[] winnersIndexes = scoreCard.getWinners();
        Player[] winnersArray = new Player[winnersIndexes.length];
        for (int i = 0; i < winnersIndexes.length; i++) {
            if (winnersIndexes[i] != -1) {
                winnersArray[i] = players[winnersIndexes[i]];
            }
        }
        return winnersArray;
    }

    public String showScoreCard() {
        return scoreCard.toString();
    }

    private void dealCardsToPlayers() {
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < fullPack.NOOFCARDSINFULLPACK / players.length; j++) {
                Card card = fullPack.getTopCard();
                players[i].add(card);
            }
        }
    }

    private int getPlayerNo(Player p) {
        int playerNo = -1;
        for (int i = 0; i < players.length; i++) {
            if (players[i] == p) {
                playerNo = i;
            }
        }
        return playerNo;
    }

    private Player[] getCurrentRoundWinners() {
        Cards currentRoundCards = cardsOnTable[roundNo];
        Card maxCard = currentRoundCards.cards[0];
        for (int i = 1; i < players.length; i++) {
            if (maxCard.compareTo(currentRoundCards.cards[i]) < 0) {
                maxCard = currentRoundCards.cards[i];
            }
        }

        Player[] winners = new Player[players.length];
        int index = 0;
        for (int i = 0; i < players.length; i++) {
            if (maxCard.compareTo(currentRoundCards.cards[i]) == 0) {
                winners[index] = players[i];
                index++;
            }
        }

        return winners;
    }

}