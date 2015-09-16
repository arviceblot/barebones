package org.bogbog.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(detachable = "true")
public class Character implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	@Persistent
	public String name;
	@Persistent(defaultFetchGroup = "true")
	public Race race;
	@Persistent
	public String eyes;
	@Persistent
	public String hair;
	@Persistent
	public String gender;
	@Persistent
	public String descriptors;
	@Persistent
	public int dpTotal;
	@Persistent
	public int dpUsed;
	@Persistent(defaultFetchGroup = "true")
	@Element(dependent = "true")
	public List<Ability> abilities;
	@Persistent(defaultFetchGroup = "true")
	@Element(dependent = "true")
	public List<Skill> skills;
	@Persistent
	public Date date;

	@NotPersistent
	public int rank;
	@NotPersistent
	public int bp;
	@NotPersistent
	public int init;
	@NotPersistent
	public int dr;
	@NotPersistent
	public int move;
	@NotPersistent
	public int fame;
	@NotPersistent
	public List<Weapon> weapons;
	@NotPersistent
	public List<Spell> spells;

	public Character() {
		this.abilities = new ArrayList<Ability>();
		this.weapons = new ArrayList<Weapon>();
		this.spells = new ArrayList<Spell>();
	}

	public Character(String name, Race race, List<Ability> abilities,
			List<Skill> skills) {
		this.name = name;
		this.race = race;
		this.eyes = "";
		this.hair = "";
		this.descriptors = "";
		this.gender = "";
		this.abilities = abilities;
		this.bp = 0;
		this.init = 0;
		this.dr = 0;
		this.move = 0;
		this.fame = 0;
		this.weapons = new ArrayList<Weapon>();
		this.spells = new ArrayList<Spell>();
		this.skills = skills;
		this.abilities = abilities;
		this.dpTotal = 0;
		this.dpUsed = 0;

		this.updateAbilities();
		this.updateBp();
		this.updateInit();
		this.updateRank();
	}

	public String getId() {
		return this.id;
	}

	public Race getRace() {
		return this.race;
	}

	public List<Ability> getAbilities() {
		return this.abilities;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public Ability getAbility(Ability.Type type) {
		for (Ability ability : this.abilities) {
			if (ability.type.equals(type)) {
				return ability;
			}
		}
		return null;
	}

	public Skill getSkill(Skill type) {
		for (Skill skill : skills) {
			if (skill.name.equals(type.name)) {
				return skill;
			}
		}
		return null;
	}

	public void updateAbilities() {
		// update each ability for any racial modifiers
		for (Ability modifier : race.abilityModifiers) {
			this.getAbility(modifier.type).modifier = modifier.modifier;
		}
	}

	public int updateBp() {
		Ability ability = this.getAbility(Ability.Type.STR);
		bp = (int) Math.ceil((ability.getModifiedValue()) / 2.0);
		bp += race.baseBpModifier;
		return bp;
	}

	public int updateInit() {
		init = 1;
		Ability ability = this.getAbility(Ability.Type.STR);
		if (ability.getModifiedValue() >= 65)
			init += 1;
		ability = this.getAbility(Ability.Type.DEX);
		if (ability.getModifiedValue() >= 65)
			init += 1;
		return init;
	}

	public int updateRank() {
		// reset the rank
		rank = 0;

		// get the two highest skill scores
		int firstMax = skills.get(0).level;
		int secondMax = skills.get(1).level;
		if (firstMax < secondMax) {
			int tempMax = firstMax;
			firstMax = secondMax;
			secondMax = tempMax;
		}

		for (Skill skill : skills) {
			int score = skill.level;
			if (score > firstMax) {
				secondMax = firstMax;
				firstMax = score;
			}
		}

		// account for the highest skill level
		if (firstMax == 6) {
			rank += 3;
		} else if (firstMax >= 4) {
			rank += 2;
		} else if (firstMax >= 2) {
			rank += 1;
		}

		// account for the second highest skill level
		if (secondMax == 6) {
			rank += 2;
		} else if (secondMax >= 3) {
			rank += 1;
		}

		// get the highest ability score
		int maxAbility = this.getAbility(Ability.Type.STR).value;
		for (Ability ability : this.abilities) {
			if (ability.getModifiedValue() > maxAbility) {
				maxAbility = ability.getModifiedValue();
			}
		}

		// account for the highest ability score
		if (maxAbility >= 100) {
			rank += 2;
		} else if (maxAbility >= 50) {
			rank += 1;
		}

		System.err.println("Character rank highest skill: " + firstMax);
		System.err.println("Character rank second highest skill: " + secondMax);
		System.err.println("Character rank max ability: " + maxAbility);
		return rank;
	}
}
