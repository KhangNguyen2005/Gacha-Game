package assign08;

import java.util.Collections;

/**
 * The Tool class represents a tool item in the GachaGame. It extends the Item
 * class and includes additional functionality specific to tools.
 */
public class Tool extends Item {

	private int toolPower;

	public Tool(String name, int power) {
		super(name);
		this.toolPower = power;
	}

	/**
	 * Compares this tool with another item for ordering. If the other item is also
	 * a Tool, comparison is based on tool power. If the other item is not a Tool,
	 * this tool is considered greater.
	 *
	 * @param otherItem - The item to be compared.
	 * @return A negative integer, zero, or a positive integer as this tool is less
	 *         than, equal to, or greater than the specified item.
	 */
	@Override
	public int compareTo(Item otherItem) {
		if (otherItem instanceof Tool) {
			Tool other = (Tool) otherItem;
			if (this.toolPower > other.toolPower) {
				return 1;
			} else if (this.toolPower < other.toolPower) {
				return -1;
			} else {
				return 0;
			}

		}
		return 1;

	}
/**
 * Returns a description of the tool.
 * @return A String describing the item.
 */
	public String getDescription() {
		return "Tool: " + this.getName() + " - power=" + toolPower;
	}
/**
 * Increases the power of the tool by 1.
 */
	public void useUpgrade() {
		this.toolPower += 1;
	}
}
