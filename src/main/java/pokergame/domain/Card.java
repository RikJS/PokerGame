package pokergame.domain;

/**
 * Name: Jacob Ward
 * Course: CSE 110
 * Lab Section: <Insert your lab section here>
 * Date: April 17, 2013
 * Assignment: Programming Project 6 - pokergame.domain.Card.java
 * Description: This class represents a poker card. A poker card
 * consists of a value and a suit. This class provides a set of
 * getters and setters that allow us to access and change those
 * values.
 */
public class Card {
    // Instance variables.
    private String suit;
    private int value;

    /**
     * Constructor which takes in a card value and suit as an argument
     * and then sets the instance variables to those values.
     *
     * @param suit  The suit of the pokergame.domain.Card object that is being created.
     * @param value The value of the pokergame.domain.Card object that is being created.
     */
    public Card(String suit, int value) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * A getter method which returns the value of this pokergame.domain.Card instance.
     *
     * @return The value of this pokergame.domain.Card instance.
     */
    public int getValue() {
        return value;
    }

    /**
     * A setter method which sets the value of this pokergame.domain.Card instance.
     *
     * @param value The value to set this pokergame.domain.Card instance to.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * A getter method which returns the suit of this pokergame.domain.Card instance.
     *
     * @return The suit of this pokergame.domain.Card instance.
     */
    public String getSuit() {
        return suit;
    }

    /**
     * A setter method which sets the suit of this pokergame.domain.Card instance.
     *
     * @param value The suit to set this pokergame.domain.Card instance to.
     */
    public void setSuit(String value) {
        suit = value;
    }

    /**
     * This is a special method in Java that will print out the String
     * that is returned if a pokergame.domain.Card object is used as an argument in a print
     * statement. If this is implemented, we can do the following:
     * <p>
     * pokergame.domain.Card c = new pokergame.domain.Card(2, "Spades");
     * System.out.println(c);
     * // This will print out "2 of Spades" based
     * // on the implementation below
     *
     * @return A String that will be printed out if this instance
     * is passed in as an argument to a print statement.
     */
    @Override
    public String toString() {
        CardValue cardValue = new CardValue(value).invoke();

        // Change the value to the actual name when printing out
        // the card.

        return cardValue.getValueName() + " of " + suit;
    }

    private class CardValue {
        int value = 0;

        private CardValue(int value) {
            this.value = value;
        }
        private String getValueName() {
            switch (value) {
                case 11:
                    return "Jack";

                case 12:
                    return "Queen";

                case 13:
                    return "King";

                case 14:
                    return "Ace";

                default:
                    return Integer.toString(value);
            }
        }

        private CardValue invoke() {
            return this;
        }
    }
}