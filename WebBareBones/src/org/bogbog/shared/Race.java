package org.bogbog.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(detachable = "true")
public class Race implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	@Persistent
	public String name;
	@Persistent
	public String description;
	@Persistent(defaultFetchGroup = "true")
	@Element(dependent = "true")
	public List<Ability> abilityModifiers;
	@Persistent
	public List<String> abilities;
	@Persistent
	public int move;
	@Persistent
	public int baseBpModifier;
	@Persistent
	public List<String> languages;

	public Race() {
		this.abilities = new ArrayList<String>();
		this.abilityModifiers = new ArrayList<Ability>();
	}

	public Race(String name, String description,
			List<Ability> abilityModifiers, List<String> abilities, int move,
			int baseBpModifier, List<String> languages) {
		this.name = name;
		this.description = description;
		this.abilityModifiers = abilityModifiers;
		this.abilities = abilities;
		this.move = move;
		this.baseBpModifier = baseBpModifier;
		this.languages = languages;
	}

	public Race clone() {
		return new Race(this.name, this.description, this.abilityModifiers,
				this.abilities, this.move, this.baseBpModifier, this.languages);
	}

	public String getId() {
		return this.id;
	}

	public List<Ability> getAbilityModifiers() {
		return this.abilityModifiers;
	}

	public static final Race ELF = new Race(
			"Elf",
			"Elves are tall, magical, pointed-eared beings at home in forests.",
			Arrays.asList(new Ability(Ability.Type.LOG, 0, 10)),
			Arrays.asList(
					"Darkvision (12 spaces, allows normal sight in low-light, as long as a single star is present in the sky).",
					"Natural Spellcaster (can wear any armor and cast spells without penalty, regardless of STR).",
					"Elf Resilience (+10 resist charm spells)."), 9, 0, Arrays
					.asList("Elven", "Tradespeak"));

	public static final Race DWARF = new Race(
			"Dwarf",
			"Dwarves are short, sturdy, bearded men and women who prefer to live in or near mountains.",
			Arrays.asList(new Ability(Ability.Type.STR, 0, 10)),
			Arrays.asList(
					"Infravision (12 spaces, sight using heat signatures in the infra-red spectrum when light is not present).",
					"Dwarf Resilience (+10 resist poison and magic)."), 6, 5,
			Arrays.asList("Dwarfish", "Tradespeak"));

	public static final Race HALFLING = new Race(
			"Halfling",
			"Halflings are small, wiry people who dwell in the hills and valleys of the realm.",
			Arrays.asList(new Ability(Ability.Type.DEX, 0, 10)), Arrays.asList(
					"Luck (each encounter, re-roll one failed check).",
					"Footpad (+10 any check to hide or sneak)."), 7, 0, Arrays
					.asList("Halfling", "Tradespeak"));

	public static final Race HUMAN = new Race(
			"Human",
			"Humans are a sturdy, passionate race who dwell in the plains and valleys of the realm.",
			Arrays.asList(new Ability(Ability.Type.WIL, 0, 10)), Arrays.asList(
					"Human Versatility (one additional descriptor).",
					"Human Resilience (+10 to all resistance checks)."), 8, 0,
			Arrays.asList("Anglish", "Tradespeak"));
}
