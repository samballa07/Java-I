package poker;

public class Deck {

	private Card[] cards;

	public Deck() {
	
		cards = new Card[52]; //creates a new array of card type w/52 elements
		int valueCount = 1;
		int suitCount = 0;
		for(int i = 0; i < 52; i++) {
			if (valueCount == 14) { //resets the value count and updates suit
				valueCount = 1;
				suitCount++;
			}
			//initializes new card type
			cards[i] = new Card(valueCount, suitCount);
			valueCount++;
		}
	}

	public Deck(Deck other) { //copy constructor
		cards = new Card[other.cards.length];
		cards = other.cards;
	}

	public Card getCardAt(int position) {
		return cards[position]; //returns the single card at position
	}

	public int getNumCards() {
		return cards.length; //returns length of array
	}

	public void shuffle() {
		// makes a shallow copy of the current cards array
		Card[] tempArr = new Card[cards.length];
		for (int x = 0; x < tempArr.length; x++) {
			tempArr[x] = cards[x];
		}
		
		int numCards = cards.length;
		int top = 0;
		// checks to see if the length of the array is even or odd
		int bottom = numCards/2;
		if(numCards % 2 == 0) {
			bottom = numCards/2;
		} else {
			bottom = numCards/2 + 1;
		}
		
		//assigns new values to the cards array while switching between packs
		for (int i = 0; i < numCards; i ++) {
			if (i % 2 == 0) {
				cards[i] = tempArr[top];
				top++;
			} else if (i % 2 == 1) {
				cards[i] = tempArr[bottom];
				bottom++;
			}
		}
	}

	public void cut(int position) {
		//makes a new shallow copy of the cards arry
		Card[] temp = new Card[cards.length];
		for (int x = 0; x < temp.length; x++) {
			temp[x] = cards[x];
		}
		
		//updates the cards array to start at the position and run until length
		int count = 0;
		for(int i = position; i < cards.length; i++) {
			cards[count] = temp[i];
			count++;
		}
		//puts the initial cards at the end of the array
		for(int j = 0; j < position; j++) {
			cards[count] = temp[j];
			count++;
		}
	}

	public Card[] deal(int numCards) {
		//puts the first couple of cards into a new array depending on param
		Card[] dealArr = new Card[numCards];
		for(int j = 0; j < numCards; j++) {
			dealArr[j] = cards[j];
		}
		
		//resizes the cards array so that the array is updated depending on
		//what was put into the new array
		Card[] smaller = new Card[cards.length - numCards];
		int count = 0;
		for (int i = numCards; i < cards.length; i++) {
			smaller[count] = cards[i];
			count++;
		}
		cards = smaller;
		
		return dealArr;
	}
		
}
