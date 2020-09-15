package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	/* Use the @Test annotation for JUnit 4 
	 * [This is just an example, please erase
	 * it and write some real tests.]    */
	@Test
	public void testConstructor() {
		Deck cards = new Deck();
		
		Card testCard1 = cards.getCardAt(0);
		int value1 = testCard1.getValue();
		int suit1 = testCard1.getSuit();
		
		Card testCard2 = cards.getCardAt(51);
		int value2 = testCard2.getValue();
		int suit2 = testCard2.getSuit();
		
		assertTrue(value1 == 1 && suit1 ==0);
		assertTrue(value2 == 13 && suit2 == 3);
	}
	
	
	@Test
	public void testOnePair() {
		Card[] test1 = new Card[5];
		test1[0] = new Card(5, 0);
		test1[1] = new Card(11, 1);
		test1[2] = new Card(9, 3);
		test1[3] = new Card(11, 2);
		test1[4] = new Card(3, 2);
		assertTrue(PokerHandEvaluator.hasPair(test1));
		
		test1[0] = new Card(5, 0);
		test1[1] = new Card(11, 1);
		test1[2] = new Card(9, 3);
		test1[3] = new Card(1, 2);
		test1[4] = new Card(3, 2);
		assertFalse(PokerHandEvaluator.hasPair(test1));
		
	}
	@Test
	public void testHasTwoPair() {
		Card[] test1 = new Card[5];
		test1[0] = new Card(5, 1);
		test1[1] = new Card(8, 0);
		test1[2] = new Card(9, 3);
		test1[3] = new Card(9, 2);
		test1[4] = new Card(5, 0);
		assertTrue(PokerHandEvaluator.hasTwoPair(test1));
		
		test1[0] = new Card(1, 1);
		test1[1] = new Card(8, 0);
		test1[2] = new Card(9, 3);
		test1[3] = new Card(9, 2);
		test1[4] = new Card(5, 0);
		assertFalse(PokerHandEvaluator.hasTwoPair(test1));
		
	}
	
	@Test
	public void testHasThreeOfAKind() {
		Card[] test1 = new Card[5];
		test1[0] = new Card(1, 1);
		test1[1] = new Card(2, 0);
		test1[2] = new Card(4, 3);
		test1[3] = new Card(4, 2);
		test1[4] = new Card(4, 0);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(test1));
		
		test1[0] = new Card(1, 1);
		test1[1] = new Card(2, 0);
		test1[2] = new Card(4, 3);
		test1[3] = new Card(2, 2);
		test1[4] = new Card(4, 0);
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(test1));
	}
	
	@Test
	public void testHasStraight() {
		Card[] test1 = new Card[5];
		test1[0] = new Card(1, 1);
		test1[1] = new Card(5, 0);
		test1[2] = new Card(2, 3);
		test1[3] = new Card(4, 2);
		test1[4] = new Card(3, 0);
		assertTrue(PokerHandEvaluator.hasStraight(test1));
		
		test1[0] = new Card(1, 1);
		test1[1] = new Card(10, 0);
		test1[2] = new Card(13, 3);
		test1[3] = new Card(11, 2);
		test1[4] = new Card(12, 0);
		assertTrue(PokerHandEvaluator.hasStraight(test1));
		
		test1[0] = new Card(1, 1);
		test1[1] = new Card(10, 0);
		test1[2] = new Card(13, 3);
		test1[3] = new Card(1, 2);
		test1[4] = new Card(12, 0);
		assertFalse(PokerHandEvaluator.hasStraight(test1));
	}
	
	@Test
	public void testHasFlush() {
		Card[] test1 = new Card[5];
		test1[0] = new Card(1, 1);
		test1[1] = new Card(5, 1);
		test1[2] = new Card(2, 1);
		test1[3] = new Card(4, 1);
		test1[4] = new Card(3, 1);
		assertTrue(PokerHandEvaluator.hasFlush(test1));
		
		test1[0] = new Card(1, 1);
		test1[1] = new Card(5, 2);
		test1[2] = new Card(2, 1);
		test1[3] = new Card(4, 1);
		test1[4] = new Card(3, 1);
		assertFalse(PokerHandEvaluator.hasFlush(test1));
		
		test1[0] = new Card(1, 0);
		test1[1] = new Card(5, 0);
		test1[2] = new Card(2, 0);
		test1[3] = new Card(4, 0);
		test1[4] = new Card(3, 0);
		assertTrue(PokerHandEvaluator.hasFlush(test1));
	}
	
	@Test
	public void testHasFullHouse() {
		Card[] test1 = new Card[5];
		test1[0] = new Card(1, 1);
		test1[1] = new Card(2, 1);
		test1[2] = new Card(1, 1);
		test1[3] = new Card(2, 1);
		test1[4] = new Card(1, 1);
		assertTrue(PokerHandEvaluator.hasFullHouse(test1));
		
		test1[0] = new Card(1, 0);
		test1[1] = new Card(2, 1);
		test1[2] = new Card(9, 2);
		test1[3] = new Card(2, 1);
		test1[4] = new Card(1, 3);
		assertFalse(PokerHandEvaluator.hasFullHouse(test1));
	}
	
	@Test
	public void testHasFourOfAKind() {
		Card[] test1 = new Card[5];
		test1[0] = new Card(9, 2);
		test1[1] = new Card(9, 3);
		test1[2] = new Card(2, 0);
		test1[3] = new Card(9, 1);
		test1[4] = new Card(9, 1);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(test1));
		
		test1[0] = new Card(9, 2);
		test1[1] = new Card(9, 3);
		test1[2] = new Card(3, 0);
		test1[3] = new Card(3, 1);
		test1[4] = new Card(9, 1);
		assertFalse(PokerHandEvaluator.hasFourOfAKind(test1));
	}
	
	@Test
	public void testHasStraightFlush() {
		Card[] test1 = new Card[5];
		test1[0] = new Card(1, 2);
		test1[1] = new Card(3, 2);
		test1[2] = new Card(2, 2);
		test1[3] = new Card(5, 2);
		test1[4] = new Card(4, 2);
		assertTrue(PokerHandEvaluator.hasStraightFlush(test1));
		
		test1[0] = new Card(1, 1);
		test1[1] = new Card(3, 2);
		test1[2] = new Card(2, 2);
		test1[3] = new Card(5, 2);
		test1[4] = new Card(4, 2);
		assertFalse(PokerHandEvaluator.hasStraightFlush(test1));
		
		test1[0] = new Card(1, 1);
		test1[1] = new Card(13, 1);
		test1[2] = new Card(10, 1);
		test1[3] = new Card(12, 1);
		test1[4] = new Card(11, 1);
		assertTrue(PokerHandEvaluator.hasStraightFlush(test1));
	}

}
