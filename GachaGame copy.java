package assign08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * This class handles the interactive mechanics of a gacha game, in which a
 * player collects four types of items: 1. Tools with a power number 2. Armor
 * with a defense number 3. Magic with a power and cost numbers 4. Upgrades that
 * can be used to improve those
 * 
 * The goal is to get the best set of items. Upgrades can be used to improve the
 * best items.
 * 
 * The game repeatedly asks for commands (get n, upgrade, exit) and prints the
 * resulting set of best items.
 * 
 * @author Eric Heisler, Prof. Parker, Prof. Martin, and Khang Hoang Nguyen
 * @version Nov 06 2023
 */
public class GachaGame {

	/**
	 * Generates an array of new items by populating it with randomly generated
	 * items.
	 * 
	 * @param howMany - The number of items to generate in the array.
	 * @return - An array of new items with length equal to parameter howMany.
	 */
	public static Item[] getNewItems(int howMany) {
		// TODO: Create an array of new items
		Item[] newItems = new Item[howMany];
		for (int i = 0; i < howMany; i++) {
			newItems[i] = getRandomItem();
		}
		return newItems;
	}

	/**
	 * getRandomItem() creates a new Item object of one of the four subclasses at
	 * random. Use a Random object to generate a random number from 0 to 3
	 * (inclusive) to choose the subclass.
	 * 
	 * @return Random item object from random subclass.
	 */
	public static Item getRandomItem() {
		// TODO: Create a new item at random
		Random random = new Random();
		int subClass = random.nextInt(4);
		String itemName = makeItemName(subClass, random);
		int powerValue = random.nextInt(100) + 1;
		Random randomCost = new Random();
		int cost = randomCost.nextInt(100) + 1;

		if (subClass == 0) {
			return new Tool(itemName, powerValue);
		} else if (subClass == 1) {
			return new Armor(itemName, powerValue);
		} else if (subClass == 2) {
			return new Magic(itemName, powerValue, cost);
		} else {
			return new Upgrade();
		}
	}

	/////////////////////////////////////////////////////
	// Everything below is complete.
	// Do not modify code below this line.
	/////////////////////////////////////////////////////

	/**
	 * Makes an item name by randomly choosing a prefix, noun, and suffix.
	 * 
	 * @param itemType  - 0 for tool, 1 for armor, 2 for magic, any other integer
	 *                  for upgrade
	 * @param generator - a random number generator
	 * @return a randomly-generated name for the item type given
	 */
	public static String makeItemName(int itemType, Random generator) {
		String[] toolNames = { "stick", "rock", "chain", "wrench", "scissors" };
		String[] armorNames = { "helmet", "boots", "gloves", "jacket", "mask" };
		String[] magicNames = { "sparks", "ice", "rain", "flame", "quake" };

		String[] adjectives = { "mighty", "shining", "powerful", "quick", "appropriate" };
		String[] modifiers = { "the moon", "the ancients", "satisfaction", "doom", "time" };

		String name;
		if (itemType == 0)
			name = toolNames[generator.nextInt(toolNames.length)];
		else if (itemType == 1)
			name = armorNames[generator.nextInt(armorNames.length)];
		else if (itemType == 2)
			name = magicNames[generator.nextInt(magicNames.length)];
		else
			return "Upgrade";

		return adjectives[generator.nextInt(adjectives.length)] + " " + name + " of "
				+ modifiers[generator.nextInt(modifiers.length)];
	}

	/**
	 * Finds and prints the best items of each type, also shows the number of
	 * available upgrades.
	 * 
	 * @param inventory - the list of items in a player's inventory
	 */
	public static void printBestItems(ArrayList<Item> inventory) {
		int[] bestIndex = getBestItemIndices(inventory);

		System.out.println("Best equipment:");
		System.out.println(" - " + inventory.get(bestIndex[0]).getDescription());
		System.out.println(" - " + inventory.get(bestIndex[1]).getDescription());
		System.out.println(" - " + inventory.get(bestIndex[2]).getDescription());
		System.out.println("   (" + bestIndex[3] + " upgrades ready)");
	}

	/**
	 * Prints the entire inventory, sorted.
	 * 
	 * @param inventory - the list of items in a player's inventory
	 */
	public static void printSortedInventory(ArrayList<Item> inventory) {
		Collections.sort(inventory);

		System.out.println("Inventory:");
		for (Item item : inventory)
			System.out.println(" - " + item.getDescription());
	}

	/**
	 * Gets the indices in a sorted inventory of the best items, as well as the
	 * number of available upgrades.
	 * 
	 * (indices[3] contains the number of available upgrades)
	 * 
	 * @param inventory - the list of items in a player's inventory
	 * @return indices of best items and number of upgrades
	 */
	public static int[] getBestItemIndices(ArrayList<Item> inventory) {
		Collections.sort(inventory);

		int[] indices = new int[4];
		indices[0] = inventory.size() - 1; // best tool
		indices[1] = indices[0]; // best armor
		indices[2] = indices[0]; // best magic
		indices[3] = 0; // number of ready upgrades

		for (Item item : inventory)
			if (item instanceof Tool) {
				indices[1]--;
				indices[2]--;
			} else if (item instanceof Armor)
				indices[2]--;
			else if (item instanceof Upgrade) {
				Upgrade upgradeItem = (Upgrade) item;
				if (!upgradeItem.isUsed())
					indices[3]++;
			}

		return indices;
	}

	/**
	 * Applies any unused upgrades.
	 * 
	 * @param inventory - the list of items in a player's inventory
	 * @return the number of upgrades applied
	 */
	public static int useUpgrades(ArrayList<Item> inventory) {
		// The number of unused upgrades are in bestIndex[3]
		int[] bestIndex = getBestItemIndices(inventory);

		// Apply that many upgrades
		for (int i = 0; i < bestIndex[3]; i++) {
			inventory.get(bestIndex[0]).useUpgrade();
			inventory.get(bestIndex[1]).useUpgrade();
			inventory.get(bestIndex[2]).useUpgrade();
		}

		// Mark upgrades as used
		for (Item item : inventory)
			if (item instanceof Upgrade)
				item.useUpgrade();
			else
				break; // end of upgrades

		return bestIndex[3];
	}

	public static void main(String[] args) {
		ArrayList<Item> inventory = new ArrayList<Item>();
		Scanner input = new Scanner(System.in);
		boolean running = true;
		String command;

		// Start with weak items
		inventory.add(new Tool("soggy banana", 0));
		inventory.add(new Armor("garbage bag", 0));
		inventory.add(new Magic("sneeze", 0, 1000));
		System.out.println("Start with weak items:");
		printBestItems(inventory);

		// Repeatedly ask for input and process until "exit" command
		while (running) {
			System.out.println("\nNext command? (get n (0<n<11), upgrade, show, exit)");

			// Wait for the next command
			command = input.next();

			if (command.equals("get"))
				if (input.hasNextInt()) {
					int num = input.nextInt();
					if (0 < num && num < 11) {
						System.out.println("Getting " + num + " new items.");
						Item[] newItems = getNewItems(num);
						for (Item item : newItems)
							inventory.add(item);
						printBestItems(inventory);
					} else
						System.out.println("Can only get 1 to 10 items at a time. Try again.");
				} else {
					System.out.println("get needs a number between 1 and 10. Example: get 7");
					input.next();
				}
			else if (command.equals("upgrade")) {
				int num = useUpgrades(inventory);
				System.out.println("Using " + num + " upgrades.");
				printBestItems(inventory);
			} else if (command.equals("show"))
				printSortedInventory(inventory);
			else if (command.equals("exit")) {
				System.out.println("Exiting. Thanks for playing.");
				running = false;
			} else
				System.out.println("Unknown command " + command + ". Try: get n (0<n<11), upgrade, show, exit");
		}

		input.close();
	}
}