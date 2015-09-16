package org.bogbog.shared;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class CharacterTest {
	private static Character elf;

	@BeforeClass
	public static void setUpBeforeClass() {
		List<Ability> abilities = new ArrayList<Ability>();
		abilities.add(new Ability(Ability.Type.STR, 50, 0));
		abilities.add(new Ability(Ability.Type.DEX, 50, 0));
		abilities.add(new Ability(Ability.Type.LOG, 50, 0));
		abilities.add(new Ability(Ability.Type.WIL, 50, 0));

		List<Skill> skills = new ArrayList<Skill>();
		skills.add(Skill.CLERIC);
		skills.add(Skill.ENCHANTER);
		skills.add(Skill.LEADER);
		skills.add(Skill.SCHOLAR);
		skills.add(Skill.SCOUT);
		skills.add(Skill.SPELLCASTER);
		skills.add(Skill.THIEF);
		skills.add(Skill.WARRIOR_MELEE);
		skills.add(Skill.WARRIOR_RANGED);

		elf = new Character("Elf", Race.ELF, abilities, skills);
	}

	@Test
	public void testBp() {
		assertTrue(elf.bp == 25);
	}

	@Test
	public void testInit() {
		assertTrue(elf.init == 1);
	}

	@Test
	public void testRank() {
		System.err.println("Test Character Rank: " + elf.rank);
		assertTrue(elf.rank == 1);
	}
}
