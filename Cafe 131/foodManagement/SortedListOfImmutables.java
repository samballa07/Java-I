package foodManagement;

/**
 * A SortedListOfImmutables represents a sorted collection of immutable objects 
 * that implement the Listable interface.  
 * 
 * An array of references to Listable objects is used internally to represent 
 * the list.  
 * 
 * The items in the list are always kept in alphabetical order based on the 
 * names of the items.  When a new item is added into the list, it is inserted 
 * into the correct position so that the list stays ordered alphabetically
 * by name.
 */
public class SortedListOfImmutables {

	/*
	 * STUDENTS:  You may NOT add any other instance variables or
	 * static variables to this class!
	*/
	private Listable[] items;

	/**
	 * This constructor creates an empty list by creating an internal array
	 * of size 0.  (Note that this is NOT the same thing as setting the internal
	 * instance variable to null.) 
	 */
	public SortedListOfImmutables() {
		items = new Listable[0]; //array is initialized to size 0
	}

	/**
	 *  Copy constructor.  The current object will become a copy of the
	 *  list that the parameter refers to.  
	 *  
	 *  The copy must be made in such a way that future changes to
	 *  either of these two lists will not affect the other. In other words, 
	 *  after this constructor runs, adding or removing things from one of 
	 *  the lists must not have any effect on the other list.
	 *  
	 *  @param other the list that is to be copied
	 */
	public SortedListOfImmutables(SortedListOfImmutables other) {
		//initializes items to the size of the parameters array length
		items = new Listable[other.items.length];
		
		//loops through the array and copies each element exactly
		for(int index = 0; index < items.length; index++) {
			items[index] = other.items[index];
		}
	}

	/**
	 * Returns the number of items in the list.
	 * @return number of items in the list
	 */
	public int getSize() {
		return items.length; //length of the current object's items array
	}
	
	/**
	 * Returns a reference to the item in the ith position in the list.  (Indexing
	 * is 0-based, so the first element is element 0).
	 * 
	 * @param i index of item requested
	 * @return reference to the ith item in the list
	 */
	public Listable get(int i) {
		return items[i]; //returns the Listable object at index i
	}
	
	/**
	 * Adds an item to the list.  This method assumes that the list is already
	 * sorted in alphabetical order based on the names of the items in the list.
	 * 
	 * The new item will be inserted into the list in the appropriate place so
	 * that the list will remain alphabetized by names.
	 * 
	 * In order to accomodate the new item, the internal array must be re-sized 
	 * so that it is one unit larger than it was before the call to this method.
	 *  
	 * @param itemToAdd refers to a Listable item to be added to this list
	 */
	public void add(Listable itemToAdd) {
		//makes a temporary array that has one more element than items
		Listable[] newArr = new Listable[items.length + 1];
		
		int counter = 0;
		//iterates through the bigger array
		for(int i = 0; i < newArr.length; i++) {
			//checks to see whether the item doesn't belong in that index
			if(counter != items.length && (counter != i ||
			   items[counter].getName().compareTo(itemToAdd.getName()) < 0)){
				newArr[i] = items[counter];
				counter++;
			} else {
				newArr[i] = itemToAdd; //puts the item in that index
			}
		}
		
		items = newArr; //turns items into a reference copy of newArr
	}

	/**
	 * Adds an entire list of items to the current list, maintaining the 
	 * alphabetical ordering of the list by the names of the items.
	 * 
	 * @param listToAdd a list of items that are to be added to the current object
	 */
	public void add(SortedListOfImmutables listToAdd) {
		//loops through the size of the parameter array
		for(int index = 0; index < listToAdd.getSize(); index++) {
			add(listToAdd.get(index)); //adds each element to the current obj
		}
	}
	
	/**
	 * Removes an item from the list.
	 * 
	 * If the list contains the same item that the parameter refers to, it will be 
	 * removed from the list.  
	 * 
	 * If the item appears in the list more than once, just one instance will be
	 * removed.
	 * 
	 * If the item does not appear on the list, then this method does nothing.
	 * 
	 * @param itemToRemove refers to the item that is to be removed from the list
	 */
	public void remove(Listable itemToRemove) {
		int numInstance = 0;
		int index = 0;
		/*iterates the current object and finds how many instances of the object
		 * to remove. Also finds the stores the index where it lies in the arr
		 */
		for(int i = 0; i < items.length; i ++) {
			if(itemToRemove.equals(items[i])) {
				numInstance++;
				index = i;
			}
		}
             
		if(numInstance != 0) { //runs when there is an instance of the param obj
			//initializes a new array with one less element than items
			Listable[] newArr = new Listable[items.length -1];
			int counter = 0;
			for(int i = 0; i < newArr.length; i++) {
				/*will copy each element to new Arr normally until the index
				 * of the item to remove is found. That index is then skipped
				 * when adding the elements
				 */
				if (i < index) {
					newArr[i] = items[counter];
				} else {
					newArr[i] = items[counter+1];
				}
				counter++;
			}
			items = newArr; //makes items a reference to the updated array
		}	
	}

	/**
	 * Removes an entire list of items from the current list.  Any items in the
	 * parameter that appear in the current list are removed; any items in the
	 * parameter that do not appear in the current list are ignored.
	 * 
	 * @param listToRemove list of items that are to be removed from this list
	 */
	public void remove(SortedListOfImmutables listToRemove) {
		for(int i = 0; i < listToRemove.getSize(); i ++) {
			//removes each element in listToRemove from items
			remove(listToRemove.get(i));
		}
	}

	/**
	 * Returns the sum of the wholesale costs of all items in the list.
	 * 
	 * @return sum of the wholesale costs of all items in the list
	 */
	public int getWholesaleCost() {
		int sum = 0;
		
		for(int i = 0; i < items.length; i++) {
			//increments sum by the wholesale cost of each element in items
			sum += items[i].getWholesaleCost();
		}
		
		return sum;
	}

	/**
	 * Returns the sum of the retail values of all items in the list.
	 * 
	 * @return sum of the retail values of all items in the list
	 */
	public int getRetailValue() {
		int sum = 0;

		for(int i = 0; i < items.length; i++) {
			//increments sum by the retail cost of each element in items
			sum += items[i].getRetailValue();
		}

		return sum;
	}

	/**
	 * Checks to see if a particular item is in the list.
	 * 
	 * @param itemToFind item to look for
	 * @return true if the item is found in the list, false otherwise
	 */
	public boolean checkAvailability(Listable itemToFind) {
		for (int i = 0; i < items.length; i++) {
			//returns true if the parameter object is in the array
			if(itemToFind.equals(items[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a list of items is contained in the current list.
	 * (In other words, this method will return true if ALL of the items in 
	 * the parameter are contained in the current list. If anything is missing,
	 * then the return value will be false.)
	 * 
	 * @param listToCheck list of items that may or may not be a subset of the
	 * current list
	 * @return true if the parameter is a subset of the current list; false 
	 * otherwise
	 */
	public boolean checkAvailability(SortedListOfImmutables listToCheck) {
		//calls copy constructor and makes a copy of the current object
		SortedListOfImmutables copy = new SortedListOfImmutables(this);
			
		int paramLength = listToCheck.items.length;
		int counter = 0;
		//iterates through both the parameter array and items array
	    for(int i = 0; i < paramLength; i++){ 
	    	for(int j = 0; j < copy.items.length; j++) {
	    		//checks to see if a certain pair are equals
	    		if(copy.items[j].equals(listToCheck.items[i])){
		        	counter++;
		        	//removes that instance so it can't be checked again
		        	copy.remove(copy.items[j]);
		        	/*will return true when every element in listToCheck is 
		        	 * found in the items array
		        	 */
		            if (counter == paramLength) {
		            	return true;
		            }
		            break;
	    		}
	        
	        }
	    }
	
	    return false;
	}

	/*
	 * We'll give you this one for free.  Do not modify this method or you
	 * will fail our tests!
	 */
	public String toString() {
		String retValue = "[ ";
		for (int i = 0; i < items.length; i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += items[i];
		}
		retValue += " ]";
		return retValue;
	}
}
