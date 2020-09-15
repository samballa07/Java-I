package foodManagement;

/**
 *  The Restaurant has a name (String), a menu (list of Entrees), an inventory
 *  (list of Food), and an amount of cash on hand, measured in pennies (int)
 * 
 *  This class facilitates orders being placed, deliveries being made to the
 *  inventory, and entrees being added to the menu.
 */
public class Restaurant {

	/*
	 * STUDENTS:  YOU MAY NOT ADD ANY OTHER INSTANCE VARIABLES OR 
	 * STATIC VARIABLES TO THIS CLASS!
	 */
	private String name;
	private SortedListOfImmutables menu;       // A list of Entree objects	
	private SortedListOfImmutables inventory;  // A list of Food objects
	private int cash;

	/**
	 * Standard constructor.  The menu and the inventory are both initialized as 
	 * empty lists.  The name and cash amount are set to match the parameters.
	 * 
	 * @param nameIn name of the restaurant
	 * @param startingCash cash amount that the restaurant will have, measured
	 * in pennies
	 */
	public Restaurant(String nameIn, int startingCash) {
		name = nameIn;
		menu = new SortedListOfImmutables();
		inventory = new SortedListOfImmutables();
		cash = startingCash;
		
	}

	/**
	 * Getter for the name of the restaurant.
	 * 
	 * @return reference to the name of the restaurant
	 */
	public String getName() {
		return name; 
	}

	/**
	 * Getter for the menu.
	 * 
	 * @return a reference to a copy of the menu
	 */
	public SortedListOfImmutables getMenu() {
		//calls the copy constructor returns a copy of menu
		SortedListOfImmutables copy = new SortedListOfImmutables(menu);
		return copy;
	}

	/**
	 * Adds an entree to the menu.
	 * 
	 * @param entreeToAdd reference to the entree to be added to the menu
	 */
	public void addEntree(Entree entreeToAdd) {
		//calls the SortedListOfImmutables add method
		menu.add(entreeToAdd); 
	}
	
	/**
	 * Getter for the inventory.
	 * 
	 * @return a reference to a copy of the inventory
	 */
	public SortedListOfImmutables getInventory() {
		//calls the copy constructor returns a copy of inventory
		SortedListOfImmutables copy = new SortedListOfImmutables(inventory);
		return copy;
	}

	/**
	 * Getter for the current amount of cash on hand
	 * 
	 * @return the current amount of cash, measured in pennies
	 */
	public int getCash() {
		return cash; //returns the integer type foe current cash value
	}

	/**
	 * Checks if the Food items contained in the specified Entree are 
	 * actually contained in the restaurant's inventory.
	 * 
	 * @param entree Entree that we are checking against the inventory
	 * @return true if the list of Food items contained in the Entree are
	 * all present in the inventory, false otherwise.
	 */
	public boolean checkIfInInventory(Entree entree) {
		/*
		 * calls the checkAvailability method in SortedListOfImmutables and
		 * returns true if that call returns true
		 */
		if (inventory.checkAvailability(entree.getFoodList())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds the specified list of food items to the inventory.  If the 
	 * total wholesale cost of all of the food items combined exceeds 
	 * the amount of cash on hand, then NONE of the food items are added 
	 * to the inventory.  If the amount of cash on hand is sufficient to
	 * pay for the shipment, then the amount of cash on hand is reduced by 
	 * the wholesale cost of the shipment.
	 * 
	 * @param list food items to be added to the inventory
	 * @return true if the food items are added; false if the food items are
	 * not added because their wholesale cost exceeds the current cash
	 * on hand
	 */
	public boolean addShipmentToInventory(SortedListOfImmutables list) {
		//checks if the wholesale cost is less than or equal to cash on hand
		if(list.getWholesaleCost() <= cash) {
			cash -= list.getWholesaleCost();//decrements cash by wholesale cost
			inventory.add(list); //adds the list to inventory
			return true;
		} 		
		return false;
	}

	/**
	 * Removes the food items contained in the specified Entree from the inventory.
	 * If the inventory does not contain all of the items required for this
	 * Entree, then NOTHING is removed from the inventory.  If the inventory contains
	 * all of the required items, then the amount of cash on hand is INCREASED by
	 * the retail value of the Entree.
	 *  
	 * @param entree Entree that has been ordered
	 * @return true if the food items are removed from the inventory; false
	 * if the food items were not removed because one or more required items
	 * were not contained in the inventory
	 */
	public boolean placeOrder(Entree entree) {
		//checks if the Entree type is in the current object's inventory
		if(checkIfInInventory(entree)) {
			cash += entree.getRetailValue();//increments cash by retail value
			inventory.remove(entree.getFoodList());
			return true;
		}
		return false;
	}

}
