package poker;
public class PokerHandEvaluator {

	public static boolean hasPair(Card[] cards) {
		
		int count = 1;
		int count2 = 1;
		// checks to see whether two cards at different places are equal
		for(int i = 0; i < cards.length; i++) {
			while(count < cards.length) {
				if(cards[i].getValue() == cards[count].getValue()) {
					return true; 
				}
				count++;
			}
			count2++;
			count = count2;
		}
		return false;
	}
	
	public static boolean hasTwoPair(Card[] cards) {
		
		int tempPairVal = -1;
		boolean onePair = false;

		//uses the same logic as hasPair but now checks for two distinct pairs
		for(int i = 0; i < cards.length - 1; i++) {
			if(cards[i].getValue() == tempPairVal)
				continue;
			int count = i + 1;
			while(count < cards.length) {
				/*checks to see if a pair is equal and makes sure it is 
				not the same as the other pair*/
				if (cards[i].getValue() == cards[count].getValue() &&
				    cards[i].getValue() != tempPairVal) {
					if (onePair == true) {
						return true;
					}
					tempPairVal = cards[i].getValue();
					onePair = true;
					break;
				}
				count++;
			}
		}
		return false;

	}

	public static boolean hasThreeOfAKind(Card[] cards) {
	
		/*uses the same concept as hasPair but checks if three elements are
		the same*/
		for(int i = 0; i < cards.length; i++) {
			for(int j = i + 1; j < cards.length; j++) {
				for(int k = j +1; k < cards.length; k++) {
					//exits method if it finds three that are the same
					if(cards[i].getValue() == cards[j].getValue() && 
					   cards[i].getValue() == cards[k].getValue() &&
					   cards[j].getValue() == cards[k].getValue()) {
						return true;
					}
				}
			}
		}
		return false;
	}


	public static boolean hasStraight(Card [] cards) {
		
		Card temp;
		// this code segment puts the cards array(value) in ascending order
		for (int i = 0; i < cards.length; i++) {
			for(int j = i+1; j < cards.length; j++) {
				if (cards[j].getValue() < cards[i].getValue()) {
					temp = cards[i];
					cards[i] = cards[j];
					cards[j] = temp;
				}
			}
		}
		//checks if the 1(ace) is in the array and determines how it is used
		if(cards[0].getValue() == 1 && cards[4].getValue() == 13) {
			Card temp1 = cards[0];
			for(int i = 0; i < cards.length-1; i++) {
				cards[i] = cards[i+1];
			}
			cards[4] = temp1;
		}

		
		int curr = cards[0].getValue();
		int second = cards[1].getValue();
		int third = cards[2].getValue();
		int fourth = cards[3].getValue();
		int fifth = cards[4].getValue();
		//checks if all the values are in ascending order, one digit away
		if (second == (curr+1) && third == (second+1) && 
				fourth ==(third+1) && 
				(fifth == fourth+1 || (fifth == 1 && fourth == 13))) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean hasFlush(Card[] cards) {
		
		int spades = 0;
		int hearts = 0;
		int clubs = 0;
		int diamonds = 0;
		int checkFlush = 5;

		for(int i = 0; i < cards.length; i++) {
			//increments the correct suit of that element index
			if(cards[i].getSuit() == 0) {
				spades++;
			} else if(cards[i].getSuit() == 1){
				hearts++;
			} else if(cards[i].getSuit() == 2) {
				clubs++;
			} else if(cards[i].getSuit() == 3) {
				diamonds++;
			}
		}
		//checks if there are 5 of any of the suits 
		if(spades == checkFlush || hearts == checkFlush || 
				clubs == checkFlush || diamonds == checkFlush) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasFullHouse(Card[] cards) {
		
		int threeVal = 0;
		boolean threeCheck = false;
		//this code segment checks if there are three elements of the same val
		for(int i = 0; i < cards.length; i++) {
			for(int j = i + 1; j < cards.length; j++) {
				for(int k = j +1; k < cards.length; k++) {
					if(cards[i].getValue() == cards[j].getValue() && 
					   cards[i].getValue() == cards[k].getValue() &&
					   cards[j].getValue() == cards[k].getValue()) {
						threeCheck = true;
						threeVal = cards[i].getValue();
					}
				}
			}
		}
		
		//if there are three of a kind, then this will run
		if (threeCheck == true) {
			for (int i = 0; i < cards.length; i++) {
				for (int j = i+1; j < cards.length; j++) {
					/*checks that there are 2 that are the same but is a diff
					 *value from the three of a kind*/
					if(cards[i].getValue() != threeVal &&
					   cards[j].getValue() != threeVal &&
					   cards[i].getValue() == cards[j].getValue()) {
						return true;
					}
				}
			}
			
		} 
		return false;
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		/* uses the same concept as hasPair, but checks if four of the 
		 * elements are the same in the array*/
		for(int i = 0; i < cards.length; i++) {
			for(int j = i + 1; j < cards.length; j++) {
				for(int k = j +1; k < cards.length; k++) {
					for(int l = k + 1; l < cards.length; l++) {
						if(cards[i].getValue() == cards[j].getValue() && 
						   cards[i].getValue() == cards[k].getValue() &&
						   cards[j].getValue() == cards[k].getValue() &&
						   cards[l].getValue() == cards[i].getValue() &&
						   cards[l].getValue() == cards[k].getValue() &&
						   cards[l].getValue() == cards[j].getValue()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static boolean hasStraightFlush(Card[] cards) {
		/*calls the straight and flush methods and returns true only if both
		 * are true*/
		if(hasStraight(cards) == true && hasFlush(cards) == true) {
			return true;
		} else {
			return false;
		}
	}
}

