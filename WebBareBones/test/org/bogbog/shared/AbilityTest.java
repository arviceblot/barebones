package org.bogbog.shared;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AbilityTest {

	@Test
	public void testValues() {
		Map<Ability.Type, Ability> abilities = new HashMap<Ability.Type, Ability>();
		abilities.put(Ability.Type.STR, new Ability(Ability.Type.STR, 50, 0));
		abilities.put(Ability.Type.DEX, new Ability(Ability.Type.DEX, 50, 0));
		abilities.put(Ability.Type.LOG, new Ability(Ability.Type.LOG, 50, 0));
		abilities.put(Ability.Type.WIL, new Ability(Ability.Type.WIL, 50, 0));

		for (Ability.Type ability : abilities.keySet()) {
			assertTrue(abilities.get(ability).value
					+ abilities.get(ability).modifier == 50);
		}
	}

}
