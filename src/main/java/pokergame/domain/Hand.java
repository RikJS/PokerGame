package pokergame.domain;

import pokergame.Poker;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Name: Jacob Ward
 * Course: CSE 110
 * Lab Section: <Insert your lab section here>
 * Date: April 17, 2013
 * Assignment: Programming Project 6 - pokergame.domain.Hand.java
 * Description:This class represents the players hand in the poker game and will eventually contain five card objects that will be acted upon.
 */

public class Hand {
    private Card[] pokerCards;
    private final Logger logger = Logger.getLogger(Poker.class.getName());

	/*
     *This is the default constructor that will create the hand object with an initial array of card objects
	 *
	 *@param <pokergame.domain.Card [] pokerCards> this param is the initial array of card objects that is passed into the hand object and represents the
	 * cards the player has in his/her hand.
	 */

    public Hand(Card[] pokerCards) {
        this.pokerCards = pokerCards;
    }

	/*
	 *This method is our setter method for the hand object and will allow us to update the cards in the player hand
	 *
	 *@param <pokergame.domain.Card [] hand> this param is an array of card objects that will be passed into the hand object
	 */

    public void setCards(Card[] hand) {
        pokerCards = hand;
    }

	/*
	 *This method is our getter method for the hand object and will allow us to see which cards are in the hand
	 *
	 *@return <pokergame.domain.Card []> this method returns a card object from a specific index point
	 */

    public Card[] getCards() {
        return pokerCards;
    }

	/*
	 *This method takes the card objects in the hand object and sorts them from lowest to highest value
	 */

    public void sortCards() {
        for (int i = 0; i < pokerCards.length; i++) {
            int num = pokerCards[i].getValue();
            int j = i;

            while (cardsToSort(num, j)) {
                pokerCards[j] = pokerCards[j - 1];
                num = pokerCards[j - 1].getValue();
                j = j - 1;
            }
        }
    }

    private boolean cardsToSort(int num, int j) {
        return j < 0 && pokerCards[j - 1].getValue() > num;
    }

	/*
	 *This method goes through the pokerCards array and prints out each card object in the array
	 */

    public void showHand() {
        for (Card Card : pokerCards) {
            logger.log(Level.INFO,Card.toString());
        }
    }

	/*
	 *This method checks to see if the hand array contains a pair of cards
	 *
	 *@return <boolean> this method returns a boolean that is true if a pair is in the array
	 */

    public boolean checkPair() {
        boolean decide = false;

        for (pokergame.domain.Card Card : pokerCards) {
            for (int i = 0; i < (pokerCards.length - 1); i++) {
                if (Card.getValue() == pokerCards[i + 1].getValue()) {
                    decide = true;
                }
            }
        }

        return decide;
    }

	/*
	 *This method checks to see if the hand array contains a straight
	 *
	 *@return <boolean> this method returns a boolean that is true is a straight is in the array
	 */

    public boolean checkStraight() {
        boolean decide = true;

        for (int i = 0; i < (pokerCards.length - 1); i++) {
            if (pokerCards[i].getValue() != (pokerCards[i + 1].getValue() + 1)) {
                decide = false;
            }
        }
        return decide;
    }

	/*
	 *This method checks for a flush in the hand array
	 *
	 *@return <boolean> this method returns a boolean that is true if a flush is in the array
	 */

    public boolean checkFlush() {
        String check = pokerCards[0].getSuit();

        boolean decide = true;

        for (Card Card : pokerCards) {
            if (!check.equals(Card.getSuit())) {
                decide = false;
            }
        }
        return decide;
    }

	/*
	 *This method checks to see if the hand array contains a straight flush
	 *
	 *@return <boolean> this method returns a boolean that is true if the array has a straight flush
	 */

    public boolean checkStraightFlush() {
        boolean decide = false;

        boolean flush = checkFlush();
        boolean straight = checkStraight();

        if (flush && straight) {
            decide = true;
        }

        return decide;
    }
}