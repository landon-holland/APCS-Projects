/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card c = new Card("Ace", "Spades", 1);
		Card c1 = new Card("Ace", "Spades", 1);
		Card c2 = new Card("2", "Spades", 1);
		System.out.println(c.toString());
		System.out.println(c1.matches(c));
		System.out.println(c2.matches(c1));
	}
}
