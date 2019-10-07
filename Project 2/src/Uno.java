import java.util.Random;
import java.util.Scanner;

public class Uno {

    /**
     * nPlayers: Number of players in the game
     * player: Current Player
     * playerHand[][]: List of Players and their hands
     * currentCard: Keeps track of the card on top of the discard pile
     * CARDS_IN_DECK: Total cards in the deck
     * START_HAND: Initial hand size
     * direction: Direction of the play
     * winner: Stores the winner of game
     */
    public static int nPlayers;
    public static int currentPlayer;
    public static UnoCard playerHand[][];
    public static UnoCard currentCard;
    public static final int CARDS_IN_DECK = 112;
    public static final int START_HAND = 7;
    public static boolean direction = true; // true for regular direction, false for reverse direction
    public static int winner;

    /**
     *
     * @param nPlayers
     */
    public Uno(int nPlayers) {
        playerHand = new UnoCard[nPlayers][CARDS_IN_DECK];
        currentPlayer = 0;
        this.nPlayers = nPlayers;
    }

    /**
     *
     */
    public static void distributeCards() {
        for (int i = 0; i < nPlayers; i++){
            for (int j = 0; j < START_HAND; j++){
                playerHand[i][j] = new UnoCard();
            }
        }
    }

    /**
     *
     * @param player
     * @param index
     */
    public static void removeCardFromHand(int p, int idx) {
        for (int i = 0; i < playerHand[p].length-1; i++){
            UnoCard last = playerHand[p][idx+i+1];
            playerHand[p][idx+i] = last;
        }
    }

    /**
     *
     * @param player
     */
    public static void printHandOfPlayer(int p) {
        int i = 0;
        while(playerHand[p][i] != null){
            System.out.println(i + ". " + playerHand[p][i].color + " " + playerHand[p][i].card);
            i++;
        }
        System.out.println("0: Draw a card | Skip turn");
    }

    /**
     *
     * @param player
     * @return
     */
    public static int cardsLeft(int p) {
        int counter = 0;
        while (playerHand[p][counter] != null){
            counter += 1;
        }
        return counter;
    }

    /**
     *
     * 
     */
    public static void handleWild() {
        System.out.println("Color changes to?");
        for (int i = 0; i < COLOR.values().length; i++){
            COLOR color = COLOR.values()[i];
            System.out.println(i + ". " + color);
        }
        Scanner s = new Scanner(System.in);
        currentCard.color = COLOR.values()[s.nextInt()-1];
    }

    /**
     *
     */
    public static void nextPlayer() {
        if (currentPlayer == nPlayers-1){
            currentPlayer = 0;
        }
        int dir = direction ? 1:-1;
        currentPlayer = currentPlayer + dir*1;
    }

    /**
     *
     * 
     */
    public static void handleWildDraw4() {
        handleWild();
        for (int i = 0; i < 4; i++){
            playerHand[currentPlayer+1][cardsLeft(currentPlayer+1)+i] = new UnoCard();
        }
    }
    
    /**
     *
     * 
     */
    public static void handleSkip() {
        //TODO: implement
    }    
    
    /**
     *
     * 
     */
    public static void handleReverse() {
        //TODO: implement
    }
    
    /**
     *
     * 
     */
    public static void handleDraw2() {
        //TODO: implement
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //TODO: implement
    }

}
