/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Deck d1 = new Deck(new String[]{"jack", "queen", "king"}, new String[]{"spades", "clubs"}, new int[]{2, 5, 1});
		System.out.println(d1.toString());
		System.out.println(d1.deal().toString());
		System.out.println(d1.toString());
	}
}
