package assign08;

/**
 * The Item abstract class represents an item in the GachaGame.
 * It serves as the superclass for various item types such as Tool, Armor, Magic, and Upgrade.
 */
public abstract class Item implements Comparable<Item> {

	private String itemName;
	
	public Item(String name) {
	this.itemName = name;
	}
	/**
	 * Gets the name of the item.
	 * @return - The name of the item.
	 */
	public String getName() {
		return this.itemName;
	}
	/**
	 * Returns a description of the item.
	 * @return - A description of the item.
	 */
	public abstract String getDescription();
	
	/**
	 * Performs an upgrade action specific to the item.
	 */
	public abstract void useUpgrade() ;
		
}
