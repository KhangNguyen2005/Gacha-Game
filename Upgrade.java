package assign08;

/**
 * The Upgrade class represents an upgrade item in the GachaGame. It extends the
 * Item class and includes additional functionality specific to upgrade items.
 */
public class Upgrade extends Item {

	private boolean used;

	public Upgrade() {
		super("Upgrade");
		this.used = false;
	}

	/**
	 * Returns a description of the upgrade item, indicating whether it is used or
	 * ready.
	 *
	 * @return A description of the upgrade item.
	 */
	public String getDescription() {
		if (this.used == true) {
			return "Upgrade: used";
		} else {
			return "Upgrade: ready";
		}
	}

	/**
	 * Marks the upgrade as used.
	 */
	public void useUpgrade() {
		this.used = true;
	}

	/**
	 * Checks whether the upgrade has been used.
	 * 
	 * @return true - if the upgrade has been used, false - otherwise.
	 */

	public boolean isUsed() {
		if (this.used == true) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Compares this upgrade item with another item for ordering. If the other item
	 * is also an Upgrade, comparison is based on whether both are used or not. If
	 * the other item is not an Upgrade, this upgrade item is considered less than
	 * non-upgrade items.
	 *
	 * @param otherItem - The item to be compared.
	 * @return A negative integer, zero, or a positive integer as this upgrade item
	 *         is less than, equal to, or greater than the specified item.
	 */
	public int compareTo(Item otherItem) {
		// TODO Auto-generated method stub
		if (otherItem instanceof Upgrade) {
			Upgrade other = (Upgrade) otherItem;
			if (this.used == true && other.used == true) {
				return 1;

			} else if (this.used == true && other.used == false) {
				return -1;
			} else {
				return 0;
			}
		} else {
			return -1;

		}

	}
}