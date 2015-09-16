package org.bogbog.shared;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SkillTest {
	
	private static Skill skill;
	
	@Test
	public void testScore() {
		skill = Skill.WARRIOR_MELEE;
		skill.isPrimary = false;
		skill.isSecondary = false;

		int score = skill.getScore(50);
		System.err.println("Test Score:" + score);
		assertTrue(skill.getScore(50) == 25);
	}

	@Test
	public void testScorePrimary() {
		skill = Skill.WARRIOR_MELEE;
		skill.isPrimary = true;
		skill.isSecondary = false;

		int score = skill.getScore(50);
		System.err.println("Test Score Primary:" + score);
		assertTrue(score == 45);
	}
	
	@Test
	public void testScoreSecondary() {
		skill = Skill.WARRIOR_MELEE;
		skill.isPrimary = false;
		skill.isSecondary = true;

		int score = skill.getScore(50);
		System.err.println("Test Score Secondary:" + score);
		assertTrue(score == 35);
	}
}
