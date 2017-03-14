package pokergame; /**
 * Name: Jacob Ward
 * Course: CSE 110
 * Lab Section: <Insert your lab section here>
 * Date: April 17, 2013
 * Assignment: Programming Project 6 - pokergame.Deck.java
 * Description: This class simulates a 52 card deck that can be shuffled, dealt, and shown. It is made up of card objects that hae value and suit.
 */

import pokergame.domain.Card;
import pokergame.domain.Hand;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Deck {
    private ArrayList<Card> cards;
    private final Logger logger = Logger.getLogger(Poker.class.getName());

	/*
     *This is the default constructor that takes in a set of card objects and sets the deck array to those objects
	 *
	 *@param <ArrayList<pokergame.domain.Card> cards> this param is an array of card objects that will be "put into" the deck.
	 */

    Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

	/*
	 *This method "randomly shuffles" the deck object's card objects.
	 */

    public void shuffle() {
        Random ran = new Random();

        ArrayList<Card> shuffle = new ArrayList<Card>();

        int cardNum = cards.size();

        for (int i = 0; i < cardNum; i++) {
            int num = ran.nextInt(cards.size());

            shuffle.add(cards.get(num));
            cards.remove(num);
        }

        cards = shuffle;
    }

	/*
	 *This method prints out each card object stored in the deck object array
	 */

    void showAll() {
        for (Card Card : cards) {
            logger.log(Level.INFO,Card.toString());
        }
    }

	/*
	 *This method takes a given number of cards and deals those cards from the deck to another hand object
	 *
	 *@param <numberOfCards> this param dictates how many card objects will be removed from the deck and placed in a hand object
	 */

    Hand deal(int numberOfCards) {
        Card[] pokerCards = new Card[numberOfCards];

        for (int i = 0; i < numberOfCards; i++) {
            pokerCards[i] = cards.get(0);
            cards.remove(0);
        }

        return new Hand(pokerCards);
    }
}