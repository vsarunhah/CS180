import java.util.Scanner;

public class Uno {

    public static final int CARDS_IN_DECK = 112;
    public static final int START_HAND = 7;
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
    public static UnoCard[][] playerHand;
    public static UnoCard currentCard;
    public static boolean direction = true; // true for regular direction, false for reverse direction
    public static int winner;

    /**
     * @param nPlayers
     */
    public Uno(int nPlayers) {
        playerHand = new UnoCard[nPlayers][CARDS_IN_DECK];
        currentPlayer = 0;
        Uno.nPlayers = nPlayers;
    }

    /**
     *
     */
    public static void distributeCards() {
        for (int i = 0; i < nPlayers; i++) {
            for (int k = 0; k < START_HAND; k++) {
                playerHand[i][k] = new UnoCard();
            }
        }
    }

    /**
     * @param player
     * @param index
     */
    public static void removeCardFromHand(int p, int idx) {
        int ind = idx;
        while (playerHand[p][ind] != null) {
            UnoCard next = playerHand[p][ind + 1];
            playerHand[p][ind] = next;
            ind++;
        }
    }

    /**
     * @param player
     */
    public static void printHandOfPlayer(int p) {
        System.out.println("Player " + (p + 1) + "'s Hand:");
        int i = 0;
        while (playerHand[p][i] != null) {
            int k = i + 1;
            if (playerHand[p][i].isWildDraw4()) {
                System.out.println(k + ": " + playerHand[p][i].card);
            } else if (playerHand[p][i].isWild()) {
                System.out.println(k + ": " + playerHand[p][i].card);
            } else {
                System.out.println(k + ": " + playerHand[p][i].color + " " + playerHand[p][i].card);
            }
            i++;
        }
        System.out.println("0: Draw a card | Skip turn");
    }

    /**
     * @param player
     * @return
     */
    public static int cardsLeft(int p) {
        int counter = 0;
        while (playerHand[p][counter] != null) {
            counter++;
        }
        return counter;
    }

    /**
     *
     */
    public static void nextPlayer() {
        if (currentPlayer == nPlayers - 1 && direction) {
            currentPlayer = 0;
        } else if (currentPlayer == 0 && !direction) {
            currentPlayer = nPlayers - 1;
        } else if (direction) {
            currentPlayer += 1;
        } else {
            currentPlayer -= 1;
        }
    }

    /**
     *
     */
    public static void handleWild() {
        System.out.println("Played Wild Card.");
        System.out.println("Color changes to? \n1. Red\n2. Green\n3. Yellow\n4. Blue");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        while (choice > 4 || choice < 1) {
            System.out.println("INVALID CHOICE!");
            choice = s.nextInt();
        }
        currentCard.color = COLOR.values()[choice - 1];
    }

    /**
     *
     */
    public static void handleWildDraw4() {
        nextPlayer();
        handleWild();
        int ca = cardsLeft(currentPlayer);
        for (int i = 0; i < 4; i++) {
            playerHand[currentPlayer][ca + i] = new UnoCard();
        }
        nextPlayer();
    }

    /**
     *va
     */
    public static void handleSkip() {
        nextPlayer();
        int player = currentPlayer;
        if (player == nPlayers - 1 && direction) {
            player = 0;
        } else if (player == 0 && !direction) {
            player = nPlayers - 1;
        } else if (direction) {
            player += 1;
        } else {
            player -= 1;
        }
        System.out.println("Player " + player + "'s turn has been skipped!");
        nextPlayer();
    }

    /**
     *
     */
    public static void handleReverse() {
        System.out.println("The game has been reversed!");
        direction = !direction;
    }

    /**
     *
     */
    public static void handleDraw2() {
        nextPlayer();
        int ca = cardsLeft(currentPlayer);
        playerHand[currentPlayer][ca] = new UnoCard();
        playerHand[currentPlayer][ca + 1] = new UnoCard();
        System.out.println("Player " + (currentPlayer + 1) + " has to draw 2 cards!");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("How many players are there?");
        int players = s.nextInt();
        while (players < 2 || players > 99) {
            System.out.println("Please enter between 2 and 99 players.");
            players = s.nextInt();
        }
        Uno game = new Uno(players);
        System.out.println("Shuffling and Adding Cards to Hands...");
        distributeCards();
        currentCard = new UnoCard(10);
        System.out.println("First Card: " + currentCard.color + " " + currentCard.card);
        int zeroCounter = 0;
        while (true) {
            int played = currentPlayer;
            printHandOfPlayer(currentPlayer);
            System.out.println("Your choice?");
            int cardPlayed = 0;
            if (s.hasNext()) {
                cardPlayed = s.nextInt();
            }
            if (zeroCounter > 0 && cardPlayed != 0) {
                zeroCounter = 0;
            }
            if (cardPlayed == 0) {
                if (zeroCounter == 0) {
                    playerHand[currentPlayer][cardsLeft(currentPlayer)] = new UnoCard();
                    zeroCounter++;
                } else {
                    zeroCounter = 0;
                    nextPlayer();
                }
            } else if (!currentCard.isPlayable(playerHand[currentPlayer][cardPlayed - 1]) || cardPlayed > cardsLeft(currentPlayer)) {
                System.out.println("INVALID CHOICE!");
            } else {
                int player = currentPlayer;
                boolean special = false;
                currentCard = playerHand[currentPlayer][cardPlayed - 1];
                if (currentCard.isWild()) {
                    handleWild();
                } else if (currentCard.isWildDraw4()) {
                    handleWildDraw4();
                    special = true;
                } else if (currentCard.isReverse()) {
                    handleReverse();
                } else if (currentCard.isDraw2()) {
                    handleDraw2();
                } else if (currentCard.isSkip()) {
                    handleSkip();
                    special = true;
                }
                removeCardFromHand(played, cardPlayed - 1);
                System.out.println("Played " + currentCard.color + " " + currentCard.card);
                if (cardsLeft(played) == 0) {
                    winner = played;
                    break;
                }
                if (!special) {
                    nextPlayer();
                }
            }

        }
        System.out.println("Player " + (currentPlayer + 1) + " wins!");
        s.close();
    }

}
