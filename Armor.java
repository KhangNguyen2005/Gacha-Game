package assign08;

/**
 * The Armor class represents an armor item in the GachaGame. It extends the
 * Item class and includes additional functionality specific to armors.
 */
public class Armor extends Item {

	private int armorValue;

	public Armor(String name, int defense) {
		super(name);
		this.armorValue = defense;
	}

	/**
	 * Compares this armor with another item for ordering. If the other item is also
	 * an Armor, comparison is based on armor defense value. If the other item is a
	 * Tool, this armor is considered less than the Tool. If the other item is not
	 * an Armor or Tool, this armor is considered greater.
	 *
	 * @param otherItem The item to be compared.
	 * @return A negative integer, zero, or a positive integer as this armor is less
	 *         than, equal to, or greater than the specified item.
	 */
	public int compareTo(Item otherItem) {
		if (otherItem instanceof Armor) {
			Armor other = (Armor) otherItem;
			if (this.armorValue > other.armorValue) {
				return 1;
			} else if (this.armorValue < other.armorValue) {
				return -1;
			} else {
				return 0;
			}

		} else if (otherItem instanceof Tool) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * Returns a description of the armor.
	 * 
	 * @return String describing the item.
	 */
	public String getDescription() {
		return "Armor: " + this.getName() + " - defense=" + armorValue;
	}

	/**
	 * Increases the defense value of the armor by 1.
	 */
	public void useUpgrade() {
		this.armorValue += 1;
	}
}
