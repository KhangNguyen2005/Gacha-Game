package assign08;

/**
 * The Magic class represents a magic item in the GachaGame. It extends the Item
 * class and includes additional functionality specific to magic items.
 */
public class Magic extends Item {

	private int magicPower;
	private int cost;

	public Magic(String name, int power, int cost) {
		
		super(name);
		this.magicPower = power;
		this.cost = cost;
	
	}

	/**
	 * Compares this magic item with another item for ordering. If the other item is
	 * also a Magic item, comparison is based on the power-to-cost ratio. If the
	 * other item is a Tool or Armor, this magic item is considered less than Tools
	 * and Armors. If the other item is not a Magic, Tool, or Armor, this magic item
	 * is considered greater.
	 *
	 * @param otherItem - The item to be compared.
	 * @return A negative integer, zero, or a positive integer as this magic item is
	 *         less than, equal to, or greater than the specified item.
	 */
	public int compareTo(Item otherItem) {
		if (otherItem instanceof Magic) {
			Magic other = (Magic) otherItem;
			double obj = ((double) this.magicPower) / ((double) this.cost);
			double otherObj = ((double) other.magicPower) / ((double) other.cost);

			if (obj < otherObj) {
				return -1;

			} else if (obj > otherObj) {

				return 1;

			} else {
				return 0;
			}

		} else if (otherItem instanceof Tool || otherItem instanceof Armor) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * Returns a description of the magic item.
	 *
	 * @return A string of the magic item.
	 */
	public String getDescription() {
		return "Magic: " + this.getName() + " - power=" + magicPower + ", cost=" + cost;
		}

	/**
	 * Increases the magic power of the item by 1.
	 */
	public void useUpgrade() {
		this.magicPower += 1;
		this.cost += 1;
	}
}
