package assign08;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The ItemTest class contains a set of JUnit test cases for the GachaGame
 * items. These tests cover the functionality and comparisons of Tool, Armor,
 * Magic, and Upgrade items.
 */
public class ItemTest {

	/**
	 * Tests for comparing two Magic items based on the power-to-cost ratio.
	 */
	@Test
	public void testCompareToTwoMagicsLessThan() {
		Magic testMagic = new Magic("testMagic", 30, 5); // name, power, cost
		Magic greaterMagic = new Magic("greater", 31, 5);
		assertTrue(testMagic.compareTo(greaterMagic) < 0);
	}

	@Test
	public void testCompareToTwoMagicsGreaterThan() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Magic lessMagic = new Magic("less", 29, 5);
		assertTrue(testMagic.compareTo(lessMagic) > 0);
	}

	@Test
	public void testCompareToTwoMagicsEqual() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Magic equalMagic = new Magic("equal", 30, 5);
		assertEquals(testMagic.compareTo(equalMagic), 0);
	}

	/**
	 * Tests for comparing different types of items: Tool, Armor, Magic, and
	 * Upgrade.
	 */
	@Test
	public void testToolCompareToArmor() {
		Armor testArmor = new Armor("testMagic", 30);
		Tool testTool = new Tool("testTool", 30);
		assertTrue(testTool.compareTo(testArmor) > 0);
	}

	@Test
	public void testArmorCompareToTool() {
		Armor testArmor = new Armor("testMagic", 30);
		Tool testTool = new Tool("testTool", 30);
		assertTrue(testArmor.compareTo(testTool) < 0);
	}

	@Test
	public void testArmorCompareToUpgrade() {
		Armor testArmor = new Armor("testMagic", 30);
		Upgrade testUpgrade = new Upgrade();
		assertTrue(testArmor.compareTo(testUpgrade) > 0);
	}

	@Test
	public void testCompareToTool() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Tool testTool = new Tool("testTool", 30);
		assertTrue(testMagic.compareTo(testTool) < 0);
	}

	@Test
	public void testCompareToArmor() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Armor testArmor = new Armor("testArmor", 30);

		assertTrue(testMagic.compareTo(testArmor) < 0);
	}

	@Test
	public void testCompareToUpgrade() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Upgrade testUpgrade = new Upgrade();
		assertTrue(testMagic.compareTo(testUpgrade) > 0);
	}

	@Test
	public void testCompareToTwoToolGreaterThan() {
		Tool testTool = new Tool("testTool", 32);
		Tool greaterTool = new Tool("greater", 31);
		assertTrue(testTool.compareTo(greaterTool) > 0);
	}

	@Test
	public void testCompareToTwoToolEqual() {
		Tool testTool = new Tool("testTool", 31);
		Tool greaterTool = new Tool("greater", 31);
		assertTrue(testTool.compareTo(greaterTool) == 0);
	}

	@Test
	public void testCompareToTwoToolLessThan() {
		Tool testTool = new Tool("testTool", 30);
		Tool greaterTool = new Tool("greater", 31);
		assertTrue(testTool.compareTo(greaterTool) < 0);
	}

	@Test
	public void testCompareToTwoArmorLessThan() {
		Armor testArmor = new Armor("testArmor", 50);
		Armor greaterArmor = new Armor("greater", 55);
		assertTrue(testArmor.compareTo(greaterArmor) < 0);
	}

	@Test
	public void testCompareToTwoArmorGreaterThan() {
		Armor testArmor = new Armor("testArmor", 60);
		Armor lesserArmor = new Armor("greater", 55);
		assertTrue(testArmor.compareTo(lesserArmor) > 0);
	}

	@Test
	public void testCompareToTwoArmorEqual() {
		Armor testArmor = new Armor("testArmor", 50);
		Armor greaterArmor = new Armor("greater", 50);
		assertTrue(testArmor.compareTo(greaterArmor) == 0);
	}
	
	/**
	 * Test edge cases for Tool, Armor, Magic, Upgrade.
	 */
	@Test
	public void testEdgeCaseTool() {
		Tool zeroTool =  new Tool("testTool", 0);
		assertEquals("Tool: testTool - power=0", zeroTool.getDescription());

	}
	
	@Test
	public void testEdgeCaseArmor() {
		Armor zeroArmor =  new Armor("testArmor", 0);
		assertEquals("Armor: testArmor - defense=0", zeroArmor.getDescription());
	}
	
	@Test
	public void testEdgeCaseMagic() {
        Magic zeroMagic = new Magic("Zero Magic", 0, 0);
		assertEquals("Magic: Zero Magic - power=0, cost=0", zeroMagic.getDescription());

	}
	
	@Test
	public void testEdgeCaseUpgrade() {
        Upgrade upgrade = new Upgrade();
        upgrade.useUpgrade();;
        assertEquals("Upgrade: used",upgrade.getDescription());
	}
	@Test
	public void testMagicUpgradeMultipleTime() {
		Magic description = new Magic("name", 50, 100);

		description.useUpgrade();
		description.useUpgrade();
		
		assertEquals("Magic: name - power=52, cost=102", description.getDescription());

	}
	/**
	 * Tests for getDescription and useUpgrade methods of Tool, Armor, Magic, and
	 * Upgrade items.
	 */
	@Test
	public void testToolGetDescription() {
		Tool description = new Tool("name", 50);
		String result = description.getDescription();
		assertEquals("Tool: name - power=50", result);
	}

	@Test
	public void testToolUseUpgrade() {
		Tool description = new Tool("name", 50);
		description.useUpgrade();
		assertEquals("Tool: name - power=51", description.getDescription());
	}

	@Test
	public void testArmorGetDescription() {
		Armor description = new Armor("name", 50);
		String result = description.getDescription();
		assertEquals("Armor: name - defense=50", result);

	}

	@Test
	public void testArmorUseUpgrade() {
		Armor description = new Armor("name", 50);
		description.useUpgrade();
		assertEquals("Armor: name - defense=51", description.getDescription());
	}

	@Test
	public void testMagicGetDescription() {
		Magic description = new Magic("name", 50, 100);
		String result = description.getDescription();
		assertEquals("Magic: name - power=50, cost=100", result);
	}

	@Test
	public void testMagicUseUpgrade() {
		Magic description = new Magic("name", 50, 100);
		description.useUpgrade();
		assertEquals("Magic: name - power=51, cost=101", description.getDescription());
	}

	@Test
	public void testUpgradeGetDescriptionFalse() {
		Upgrade description = new Upgrade();
		String result = description.getDescription();
		assertEquals("Upgrade: ready", result);
	}

	@Test
	public void testUpgradeUseUpgrade() {
		Upgrade description = new Upgrade();
		description.useUpgrade();
		String result = description.getDescription();
		assertEquals("Upgrade: used", result);
	}

	@Test
	public void testUpgradeIsUsed() {
		Upgrade description = new Upgrade();
		description.isUsed();
		String result = description.getDescription();
		assertEquals("Upgrade: ready", result);
	}

	@Test
	public void testUpgradeCompareToTwoUpgradeBothTrue() {
		Upgrade usedUpgrade = new Upgrade();
		usedUpgrade.useUpgrade();
		Upgrade usedUpgrade2 = new Upgrade();
		usedUpgrade2.useUpgrade();
		assertTrue(usedUpgrade.compareTo(usedUpgrade2) == 1);
	}

	@Test
	public void testUpgradeCompareToTwoUpgradeBothFalse() {
		Upgrade usedUpgrade = new Upgrade();
		usedUpgrade.useUpgrade();
		Upgrade unusedUpgrade2 = new Upgrade();

		assertTrue(usedUpgrade.compareTo(unusedUpgrade2) == -1);
	}

	@Test
	public void testUpgradeCompareToTwoUpgrade() {
		Upgrade unusedUpgrade = new Upgrade();
		Upgrade unusedUpgrade2 = new Upgrade();

		assertTrue(unusedUpgrade.compareTo(unusedUpgrade2) == 0);

	}
	
}