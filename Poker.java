import java.util.ArrayList;
import java.util.Scanner;

/*
 * Description: This is our driver class that contains main which
 * is the starting point when we execute our program.
 */
public class Poker
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		Deck pokerDeck = generateDeck();

		Scanner scan = new Scanner(System.in);

		int decision = 0;

		while (decision != -1)
		{
			System.out.println("1) Shuffle Deck");
			System.out.println("2) Deal Hand");
			System.out.println("3) Show Deck");
			System.out.println("Enter Selection (-1 to quit)");

			decision = scan.nextInt();

			if (decision == 1)
			{
				pokerDeck.shuffle();
			}

			else if (decision == 2)
			{
				Hand hand = pokerDeck.deal(5);

				hand.sortCards();

				hand.showHand();

				boolean s = hand.checkStraight();
				boolean p = hand.checkPair();
				boolean f = hand.checkFlush();
				boolean sf = hand.checkStraightFlush();

				if (s == true)
				{
					System.out.println("You have a Straight!");
					System.out.println();
				}

				if (p == true)
				{
					System.out.println("You have a Pair!");
					System.out.println();
				}

				if (f == true)
				{
					System.out.println("You have a Flush!");
					System.out.println();
				}

			}

			else if (decision == 3)
			{
				pokerDeck.showAll();
			}
		}
	}

	/**
	 * Generates a Deck object that contains 52 Card objects. This
	 * represents a standard deck of poker cards.
	 *
	 * @return A Deck object containing all 52 cards found in a standard
	 * poker deck.
	 */
	public static Deck generateDeck()
	{
		// Instantiate an ArrayList of Card objects.
		ArrayList<Card> cards = new ArrayList<Card>();

		// Loop through all the face values that a card can be.
		for (int i = 2; i <= 14; i++)
		{
			// Loop through all the suits.
			for (int j = 0; j < 4; j++)
			{
				// Create a new Card object with the current value
				// that we're at in the loop and also the suit.
				switch(j)
				{
					case 0:
						cards.add(new Card(i, "Spades"));
						break;

					case 1:
						cards.add(new Card(i, "Clubs"));
						break;

					case 2:
						cards.add(new Card(i, "Hearts"));
						break;

					case 3:
						cards.add(new Card(i, "Diamonds"));
						break;

					default:
						break;
				}
			}
		}

		// Return a new Deck object with the cards generated above.
		return new Deck(cards);
	}
}
