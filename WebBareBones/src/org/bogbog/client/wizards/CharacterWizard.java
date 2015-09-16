package org.bogbog.client.wizards;

import java.util.ArrayList;
import java.util.List;

import org.bogbog.shared.Ability;
import org.bogbog.shared.Character;
import org.bogbog.shared.Race;
import org.bogbog.shared.Skill;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CharacterWizard extends Composite {

	private static CharacterWizardUiBinder uiBinder = GWT
			.create(CharacterWizardUiBinder.class);
	@UiField
	IntegerBox randStrValue;
	@UiField
	IntegerBox randDexValue;
	@UiField
	IntegerBox randLogValue;
	@UiField
	IntegerBox randWilValue;
	@UiField
	Button randAbilityButton;
	@UiField
	Button clearAbilityButton;
	@UiField
	ListBox raceListBox;
	@UiField
	TextBox nameValue;
	@UiField
	TextBox genderValue;
	@UiField
	TextBox eyesValue;
	@UiField
	TextBox hairValue;
	@UiField
	TextBox descriptorsValue;
	@UiField
	ListBox primarySkillComboBox;
	@UiField
	ListBox secondarySkillComboBox;
	@UiField
	ListBox levedSkillComboBox;

	private Character character;
	private List<Race> races;
	private List<Skill> skills;
	private Random rand;

	interface CharacterWizardUiBinder extends UiBinder<Widget, CharacterWizard> {
	}

	public CharacterWizard() {
		initWidget(uiBinder.createAndBindUi(this));

		this.races = new ArrayList<Race>();
		races.add(Race.HUMAN.clone());
		races.add(Race.ELF.clone());
		races.add(Race.DWARF.clone());
		races.add(Race.HALFLING.clone());

		for (Race race : races) {
			this.raceListBox.addItem(race.name);
		}

		skills = new ArrayList<Skill>();
		skills.add(Skill.CLERIC.clone());
		skills.add(Skill.ENCHANTER.clone());
		skills.add(Skill.LEADER.clone());
		skills.add(Skill.SCHOLAR.clone());
		skills.add(Skill.SCOUT.clone());
		skills.add(Skill.SPELLCASTER.clone());
		skills.add(Skill.THIEF.clone());
		skills.add(Skill.WARRIOR_MELEE.clone());
		skills.add(Skill.WARRIOR_RANGED.clone());

		for (Skill skill : skills) {
			this.primarySkillComboBox.addItem(skill.name);
			this.levedSkillComboBox.addItem(skill.name);
		}
	}

	private void buildCharacter() {
		List<Ability> abilities = new ArrayList<Ability>();
		abilities.add(new Ability(Ability.Type.STR, this.randStrValue
				.getValue(), 0));
		abilities.add(new Ability(Ability.Type.DEX, this.randDexValue
				.getValue(), 0));
		abilities.add(new Ability(Ability.Type.LOG, this.randLogValue
				.getValue(), 0));
		abilities.add(new Ability(Ability.Type.WIL, this.randWilValue
				.getValue(), 0));

		// get the race
		String raceText = this.raceListBox.getItemText(this.raceListBox
				.getSelectedIndex());
		Race selectedRace = Race.HUMAN.clone();
		for (Race race : races) {
			if (race.name.equals(raceText)) {
				selectedRace = race;
				break;
			}
		}

		// get the skills
		String primarySkillText = this.primarySkillComboBox
				.getItemText(this.primarySkillComboBox.getSelectedIndex());
		for (Skill skill : skills) {
			if (skill.name.equals(primarySkillText)) {
				skill.isPrimary = true;
				break;
			}
		}
		String secondarySkillText = this.secondarySkillComboBox
				.getItemText(this.secondarySkillComboBox.getSelectedIndex());
		for (Skill skill : skills) {
			if (skill.name.equals(secondarySkillText)) {
				skill.isSecondary = true;
				break;
			}
		}
		String levedSkillText = this.levedSkillComboBox
				.getItemText(this.levedSkillComboBox.getSelectedIndex());
		for (Skill skill : skills) {
			if (skill.name.equals(levedSkillText)) {
				skill.level = 1;
				break;
			}
		}

		character = new Character(this.nameValue.getValue(), selectedRace,
				abilities, skills);
		character.gender = this.genderValue.getValue();
		character.eyes = this.eyesValue.getValue();
		character.hair = this.hairValue.getValue();
		character.descriptors = this.descriptorsValue.getValue();
	}

	public Character getCharacter() {
		this.buildCharacter();
		return this.character;
	}

	@UiHandler("randAbilityButton")
	void onRandAbilityButtonClick(ClickEvent event) {
		// set the random ability values
		this.randStrValue.setValue(rand.nextInt(81 - 34) + 34);
		this.randDexValue.setValue(rand.nextInt(81 - 34) + 34);
		this.randLogValue.setValue(rand.nextInt(81 - 34) + 34);
		this.randWilValue.setValue(rand.nextInt(81 - 34) + 34);
	}

	@UiHandler("clearAbilityButton")
	void onClearAbilityButtonClick(ClickEvent event) {
		this.randStrValue.setValue(0);
		this.randDexValue.setValue(0);
		this.randLogValue.setValue(0);
		this.randWilValue.setValue(0);
	}

	@UiHandler("levedSkillComboBox")
	void onLevedSkillComboBoxChange(ChangeEvent event) {
	}

	@UiHandler("primarySkillComboBox")
	void onPrimarySkillComboBoxChange(ChangeEvent event) {
		int selectedIndex = this.primarySkillComboBox.getSelectedIndex();
		this.secondarySkillComboBox.clear();
		// add every item to the secondary skill box BUT the one selected as
		// primary
		for (int i = 0; i < this.primarySkillComboBox.getItemCount(); i++) {
			if (i == selectedIndex) {
				continue;
			} else {
				this.secondarySkillComboBox.addItem(this.primarySkillComboBox
						.getItemText(i));
			}
		}
	}
}
