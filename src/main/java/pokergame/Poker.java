package pokergame;

import pokergame.domain.Card;
import pokergame.domain.Hand;
import pokergame.ui.pokerTable.PokerTableUI;
import pokergame.ui.pokerTable.shape.Circle;
import pokergame.ui.pokerTable.shape.Hexagon;
import pokergame.ui.pokerTable.shape.Shape;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Description: This is our driver class that contains main which
 * is the starting point when we execute our program.
 */
public class Poker {

    public static final String SPADES = "Spades";
    public static final String CLUBS = "Clubs";
    public static final String HEARTS = "Hearts";
    public static final String DIAMONDS = "Diamonds";

    private Poker() {


    }

    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(Poker.class.getName());

        Deck pokerDeck = generateDeck();

        Scanner scan = new Scanner(System.in);

        int decision = 0;
        while (decision != -1) {
            logger.log(Level.INFO,"1) Shuffle pokergame.Deck");
            logger.log(Level.INFO,"2) Deal pokergame.domain.Hand");
            logger.log(Level.INFO,"3) Show pokergame.Deck");
            logger.log(Level.INFO,"Enter Selection (-1 to quit)");
            decision = scan.nextInt();

            if (decision == 1) {
                pokerDeck.shuffle();
            } else if (decision == 2) {
                Hand hand = pokerDeck.deal(5);

                hand.sortCards();

                hand.showHand();

                boolean s = hand.checkStraight();
                boolean p = hand.checkPair();
                boolean f = hand.checkFlush();

                if (s) {
                    logger.log(Level.INFO,"You have a Straight!");
                }
                if (p) {
                    logger.log(Level.INFO,"You have a Pair!");
                }
                if (f) {
                    logger.log(Level.INFO,"You have a Flush!");
                }

            } else if (decision == 3) {
                pokerDeck.showAll();
            }
        }

    }

    private static void generateUI() {
        Shape pokerTableShape = new Circle();

        PokerTableUI pokerTableUI = new PokerTableUI().setColor("green").setSizeX(10).setSizeY(10).setTableShape(pokerTableShape);
    }

    /**
     * Generates a pokergame.Deck object that contains 52 pokergame.domain.Card objects. This
     * represents a standard deck of poker cards.
     *
     * @return A pokergame.Deck object containing all 52 cards found in a standard
     * poker deck.
     */
    private static Deck generateDeck() {
        // Instantiate an ArrayList of pokergame.domain.Card objects.
        ArrayList<Card> cards = new ArrayList<Card>();

        // Loop through all the face values that a card can be.
        for (int i = 2; i <= 14; i++) {
            // Loop through all the suits.
            for (int j = 0; j < 4; j++) {
                // Create a new pokergame.domain.Card object with the current value
                // that we're at in the loop and also the suit.
                switch (j) {
                    case 0:
                        cards.add(new Card(SPADES, i));
                        break;

                    case 1:
                        cards.add(new Card(CLUBS, i));
                        break;

                    case 2:
                        cards.add(new Card(HEARTS, i));
                        break;

                    case 3:
                        cards.add(new Card(DIAMONDS, i));
                        break;

                    default:
                        break;
                }
            }
        }

        // Return a new pokergame.Deck object with the cards generated above.
        return new Deck(cards);
    }
}
