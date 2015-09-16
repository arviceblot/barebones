package org.bogbog.shared;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(detachable = "true")
public class Skill implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	@Persistent
	public String name;
	@Persistent
	public Ability.Type ability;
	@Persistent
	public int level;
	@Persistent
	public boolean isPrimary;
	@Persistent
	public boolean isSecondary;
	@Persistent
	public String notes;
	@Persistent
	public boolean usableUntrained;

	public Skill() {

	}

	public Skill(String name, Ability.Type ability, int level,
			boolean isPrimary, boolean isSecondary, String notes,
			boolean usableUntrained) {
		this.name = name;
		this.ability = ability;
		this.level = level;
		if (isPrimary) {
			this.isPrimary = isPrimary;
		} else if (isSecondary) {
			this.isSecondary = isSecondary;
		} else {
			this.isPrimary = false;
			this.isSecondary = false;
		}
		this.notes = notes;
		this.usableUntrained = usableUntrained;
	}

	public Skill clone() {
		return new Skill(this.name, this.ability, this.level, this.isPrimary,
				this.isSecondary, this.notes, this.usableUntrained);
	}

	public String getId() {
		return this.id;
	}

	public int getScore(int ability) {
		if (!this.usableUntrained && this.level < 1) {
			return 0;
		}

		int score = ((int) Math.ceil(ability / 2.0)) + (level * 10);
		if (isPrimary) {
			score += 20;
		} else if (isSecondary) {
			score += 10;
		}
		return score;
	}

	public static final Skill CLERIC = new Skill("Cleric*", Ability.Type.WIL,
			0, false, false, "Blessings, Detect Aura, Miracles, Smite", false);

	public static final Skill ENCHANTER = new Skill("Enchanter*",
			Ability.Type.LOG, 0, false, false,
			"Alchemy, Enchantment, Runecraft, Familiar", false);

	public static final Skill LEADER = new Skill("Leader*", Ability.Type.WIL,
			0, false, false, "Battle Commander, Guardian, Leader, Warlord",
			false);

	public static final Skill SCHOLAR = new Skill("Scholar*", Ability.Type.LOG,
			0, false, false,
			"Diplomat, High Scholar, Historian, Signs & Portents", false);

	public static final Skill SCOUT = new Skill("Scout", Ability.Type.LOG, 0,
			false, false, "Animal Handling, Navigation, Survival, Tracking",
			true);

	public static final Skill SPELLCASTER = new Skill("Spellcaster*",
			Ability.Type.LOG, 0, false, false,
			"High Wizardry, Low Wizardry, Wizard Eye, Wizard Hand", false);

	public static final Skill THIEF = new Skill("Thief", Ability.Type.DEX, 0,
			false, false,
			"Deception, Security Systems, Sleight of Hand, Stealth", true);

	public static final Skill WARRIOR_MELEE = new Skill("Warrior (melee)",
			Ability.Type.STR, 0, false, false, "Melee, Unarmed combat", true);

	public static final Skill WARRIOR_RANGED = new Skill("Warrior (ranged)",
			Ability.Type.DEX, 0, false, false, "Marksman, Thrown weapons", true);
}
