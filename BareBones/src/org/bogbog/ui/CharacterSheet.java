package org.bogbog.ui;

import org.bogbog.Character;
import org.bogbog.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class CharacterSheet extends Composite {

	private Composite featuresComposite;
	private Text strText;
	private Text dexText;
	private Text logText;
	private Text wilText;
	private Text bpValue;
	private Text initValue;
	private Text drValue;
	private Text moveValue;
	private Text fameValue;

	public CharacterSheet(Composite parent, int style, Session session) {
		super(parent, SWT.NONE);

		Character ch = Session.getCharacter();

		GridLayout gridLayout = new GridLayout();
		this.setLayout(gridLayout);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Composite descriptionComposite = new Composite(this, SWT.NONE);
		descriptionComposite.setLayout(new GridLayout(2, false));
		GridData gd_descriptionComposite = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		gd_descriptionComposite.widthHint = 853;
		descriptionComposite.setLayoutData(gd_descriptionComposite);

		featuresComposite = new Composite(descriptionComposite, SWT.NONE);
		GridData gd_featuresComposite = new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1);
		gd_featuresComposite.widthHint = 591;
		featuresComposite.setLayoutData(gd_featuresComposite);
		featuresComposite.setLayout(new GridLayout(4, false));

		Label nameLabel = new Label(featuresComposite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		nameLabel.setText("Name:");
		Text nameText = new Text(featuresComposite, SWT.BORDER | SWT.READ_ONLY);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1,
				1));
		nameText.setText(ch.name);

		Label rankLabel = new Label(featuresComposite, SWT.NONE);
		rankLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		rankLabel.setText("Rank:");
		Text rankText = new Text(featuresComposite, SWT.BORDER | SWT.READ_ONLY);
		rankText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1,
				1));

		Label raceLabel = new Label(featuresComposite, SWT.NONE);
		raceLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		raceLabel.setText("Race:");
		Text raceText = new Text(featuresComposite, SWT.BORDER | SWT.READ_ONLY);
		raceText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1,
				1));

		Label dpLabel = new Label(featuresComposite, SWT.NONE);
		dpLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		dpLabel.setText("DP:");
		Text dpText = new Text(featuresComposite, SWT.BORDER | SWT.READ_ONLY);
		dpText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		Label featuresLabel = new Label(featuresComposite, SWT.NONE);
		featuresLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		featuresLabel.setText("Hair/Eyes:");
		Text featuresText = new Text(featuresComposite, SWT.BORDER
				| SWT.READ_ONLY);
		featuresText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1));

		Label genderLabel = new Label(featuresComposite, SWT.NONE);
		genderLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		genderLabel.setText("Gender:");
		Text genderText = new Text(featuresComposite, SWT.BORDER
				| SWT.READ_ONLY);
		genderText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				1, 1));

		Label descLabel = new Label(featuresComposite, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		descLabel.setText("Descriptors:");
		Text descText = new Text(featuresComposite, SWT.BORDER | SWT.READ_ONLY);
		descText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3,
				1));
		new Label(featuresComposite, SWT.NONE);
		new Label(featuresComposite, SWT.NONE);
		new Label(featuresComposite, SWT.NONE);
		new Label(featuresComposite, SWT.NONE);

		Group moralCodeGroup = new Group(descriptionComposite, SWT.NONE);
		moralCodeGroup.setText("Moral Code");
		moralCodeGroup.setLayout(new GridLayout(2, false));

		Label aspectLabel = new Label(moralCodeGroup, SWT.NONE);
		aspectLabel.setText("Aspect");

		Label dedicationLabel = new Label(moralCodeGroup, SWT.NONE);
		dedicationLabel.setText("Dedication");

		Combo kindnessCombo = new Combo(moralCodeGroup, SWT.NONE);
		kindnessCombo.setEnabled(false);
		kindnessCombo.setItems(new String[] { "Kind", "Cruel" });
		kindnessCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		kindnessCombo.select(0);

		Combo kindnessValueCombo = new Combo(moralCodeGroup, SWT.NONE);
		kindnessValueCombo.setEnabled(false);
		kindnessValueCombo.setItems(new String[] { "Somewhat", "Very",
				"Totally" });
		kindnessValueCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		kindnessValueCombo.select(0);

		Combo focusedCombo = new Combo(moralCodeGroup, SWT.NONE);
		focusedCombo.setEnabled(false);
		focusedCombo.setItems(new String[] { "Focused", "Unfocused" });
		focusedCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		focusedCombo.select(0);

		Combo focusedValueCombo = new Combo(moralCodeGroup, SWT.NONE);
		focusedValueCombo.setEnabled(false);
		focusedValueCombo
				.setItems(new String[] { "Somewhat", "Very", "Totally" });
		focusedValueCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		focusedValueCombo.select(0);

		Combo selfishCombo = new Combo(moralCodeGroup, SWT.NONE);
		selfishCombo.setEnabled(false);
		selfishCombo.setItems(new String[] { "Selfless", "Selfish" });
		selfishCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		selfishCombo.select(0);

		Combo selfishValueCombo = new Combo(moralCodeGroup, SWT.NONE);
		selfishValueCombo.setEnabled(false);
		selfishValueCombo
				.setItems(new String[] { "Somewhat", "Very", "Totally" });
		selfishValueCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		selfishValueCombo.select(0);

		Combo honorCombo = new Combo(moralCodeGroup, SWT.NONE);
		honorCombo.setEnabled(false);
		honorCombo.setItems(new String[] { "Honorable", "Deceitful" });
		honorCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		honorCombo.select(0);

		Combo honorValueCombo = new Combo(moralCodeGroup, SWT.NONE);
		honorValueCombo.setEnabled(false);
		honorValueCombo
				.setItems(new String[] { "Somewhat", "Very", "Totally" });
		honorValueCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		honorValueCombo.select(0);

		Combo braveCombo = new Combo(moralCodeGroup, SWT.NONE);
		braveCombo.setEnabled(false);
		braveCombo.setItems(new String[] { "Brave", "Cowardly" });
		braveCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		braveCombo.select(0);

		Combo braveValueCombo = new Combo(moralCodeGroup, SWT.NONE);
		braveValueCombo.setEnabled(false);
		braveValueCombo
				.setItems(new String[] { "Somewhat", "Very", "Totally" });
		braveValueCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		braveValueCombo.select(0);

		Composite statsComposite = new Composite(this, SWT.NONE);
		GridData gd_statsComposite = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1);
		gd_statsComposite.widthHint = 962;
		statsComposite.setLayoutData(gd_statsComposite);
		statsComposite.setLayout(new GridLayout(2, false));

		Composite attributesComposite = new Composite(statsComposite, SWT.NONE);
		attributesComposite.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1));
		attributesComposite.setLayout(new GridLayout(2, false));

		Label strLabel = new Label(attributesComposite, SWT.NONE);
		strLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		strLabel.setAlignment(SWT.RIGHT);
		strLabel.setText("STR");

		strText = new Text(attributesComposite, SWT.BORDER | SWT.READ_ONLY);
		strText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		strText.setText(Integer.toString(ch.str));

		Label dexLabel = new Label(attributesComposite, SWT.NONE);
		dexLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		dexLabel.setText("DEX");

		dexText = new Text(attributesComposite, SWT.BORDER | SWT.READ_ONLY);
		dexText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		dexText.setText(Integer.toString(ch.dex));

		Label logLabel = new Label(attributesComposite, SWT.NONE);
		logLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		logLabel.setText("LOG");

		logText = new Text(attributesComposite, SWT.BORDER | SWT.READ_ONLY);
		logText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		logText.setText(Integer.toString(ch.log));

		Label wilLabel = new Label(attributesComposite, SWT.NONE);
		wilLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		wilLabel.setText("WIL");

		wilText = new Text(attributesComposite, SWT.BORDER | SWT.READ_ONLY);
		wilText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		wilText.setText(Integer.toString(ch.wil));

		Composite skillsComposite = new Composite(statsComposite, SWT.NONE);
		GridData gd_skillsComposite = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 2);
		gd_skillsComposite.widthHint = 697;
		skillsComposite.setLayoutData(gd_skillsComposite);
		skillsComposite.setLayout(new GridLayout(1, false));

		Group skillsGroup = new Group(skillsComposite, SWT.NONE);
		skillsGroup.setLayout(new GridLayout(6, false));
		skillsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		skillsGroup.setText("Skills");
		new Label(skillsGroup, SWT.NONE);

		Label abilityColumn = new Label(skillsGroup, SWT.NONE);
		abilityColumn.setText("Ability");

		Label lblLevel = new Label(skillsGroup, SWT.NONE);
		lblLevel.setText("Level");

		Label lblPs = new Label(skillsGroup, SWT.NONE);
		lblPs.setText("P/S");

		Label lblScore = new Label(skillsGroup, SWT.NONE);
		lblScore.setText("Score*");

		Label lblNotes = new Label(skillsGroup, SWT.NONE);
		lblNotes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		lblNotes.setText("Notes");

		Label lblCleric = new Label(skillsGroup, SWT.NONE);
		lblCleric.setText("Cleric**");

		Label lblWil_1 = new Label(skillsGroup, SWT.NONE);
		lblWil_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblWil_1.setText("WIL");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label lblBlessingsDetectAura = new Label(skillsGroup, SWT.NONE);
		lblBlessingsDetectAura
				.setText("Blessings, Detect Aura, Miracles, Smite");

		Label lblEnchanter = new Label(skillsGroup, SWT.NONE);
		lblEnchanter.setText("Enchanter**");

		Label lblLog_1 = new Label(skillsGroup, SWT.NONE);
		lblLog_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblLog_1.setText("LOG");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label lblAlchemyEnchantmentRunecraft = new Label(skillsGroup, SWT.NONE);
		lblAlchemyEnchantmentRunecraft
				.setText("Alchemy, Enchantment, Runecraft, Familiar");

		Label lblLeader = new Label(skillsGroup, SWT.NONE);
		lblLeader.setText("Leader**");

		Label lblWil_2 = new Label(skillsGroup, SWT.NONE);
		lblWil_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblWil_2.setText("WIL");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label lblBattleCommanderGuardian = new Label(skillsGroup, SWT.NONE);
		lblBattleCommanderGuardian
				.setText("Battle Commander, Guardian, Leader, Warlord");

		Label lblScholar = new Label(skillsGroup, SWT.NONE);
		lblScholar.setText("Scholar**");

		Label lblLog_2 = new Label(skillsGroup, SWT.NONE);
		lblLog_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblLog_2.setText("LOG");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label lblDiplomatHighScholar = new Label(skillsGroup, SWT.NONE);
		lblDiplomatHighScholar
				.setText("Diplomat, High Scholar, Historian, Signs & Portents");

		Label lblScout = new Label(skillsGroup, SWT.NONE);
		lblScout.setText("Scout");

		Label lblLog_3 = new Label(skillsGroup, SWT.NONE);
		lblLog_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblLog_3.setText("LOG");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label lblAnimalHandlingNavigation = new Label(skillsGroup, SWT.NONE);
		lblAnimalHandlingNavigation
				.setText("Animal Handling, Navigation, Survival, Tracking");

		Label lblSpellcaster = new Label(skillsGroup, SWT.NONE);
		lblSpellcaster.setText("Spellcaster**");

		Label lblLog_4 = new Label(skillsGroup, SWT.NONE);
		lblLog_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblLog_4.setText("LOG");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label lblHighWizardryLow = new Label(skillsGroup, SWT.NONE);
		lblHighWizardryLow
				.setText("High Wizardry, Low Wizardry, Wizard Eye, Wizard Hand");

		Label lblThief = new Label(skillsGroup, SWT.NONE);
		lblThief.setText("Thief");

		Label lblDex_1 = new Label(skillsGroup, SWT.NONE);
		lblDex_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblDex_1.setText("DEX");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label lblDeceptionSecuritySystems = new Label(skillsGroup, SWT.NONE);
		lblDeceptionSecuritySystems
				.setText("Deception, Security Systems, Sleight of Hand, Stealth");

		Label lblWarriotmelee = new Label(skillsGroup, SWT.NONE);
		lblWarriotmelee.setText("Warriot (melee)");

		Label lblStr_1 = new Label(skillsGroup, SWT.NONE);
		lblStr_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblStr_1.setText("STR");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label lblMeleeUnarmedCombat = new Label(skillsGroup, SWT.NONE);
		lblMeleeUnarmedCombat.setText("Melee, Unarmed combat");

		Label lblWarriorranged = new Label(skillsGroup, SWT.NONE);
		lblWarriorranged.setText("Warrior (ranged)");

		Label lblDex_2 = new Label(skillsGroup, SWT.NONE);
		lblDex_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblDex_2.setText("DEX");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label lblMarksmanThrownWeapons = new Label(skillsGroup, SWT.NONE);
		lblMarksmanThrownWeapons.setText("Marksman, Thrown weapons");
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);
		new Label(skillsGroup, SWT.NONE);

		Label note1Label = new Label(skillsComposite, SWT.NONE);
		note1Label
				.setText("* Half the listed Ability, +10 per Level, +20 if Primary skill, +10 if Secondary skill.");

		Label note2Label = new Label(skillsComposite, SWT.NONE);
		note2Label
				.setText("** These skills cannot be used unless you have at least one Level.");

		Composite derivedComposite = new Composite(statsComposite, SWT.NONE);
		derivedComposite.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1));
		derivedComposite.setLayout(new GridLayout(2, false));

		Label bpLabel = new Label(derivedComposite, SWT.NONE);
		bpLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		bpLabel.setText("BP");

		bpValue = new Text(derivedComposite, SWT.BORDER | SWT.READ_ONLY);
		bpValue.setText(Integer.toString(ch.bp));

		Label initLabel = new Label(derivedComposite, SWT.NONE);
		initLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		initLabel.setText("INIT");

		initValue = new Text(derivedComposite, SWT.BORDER | SWT.READ_ONLY);
		initValue.setText(Integer.toString(ch.init));

		Label drLabel = new Label(derivedComposite, SWT.NONE);
		drLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		drLabel.setText("DR");

		drValue = new Text(derivedComposite, SWT.BORDER | SWT.READ_ONLY);
		drValue.setText(Integer.toString(ch.dr));

		Label moveLabel = new Label(derivedComposite, SWT.NONE);
		moveLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		moveLabel.setText("MOVE");

		moveValue = new Text(derivedComposite, SWT.BORDER | SWT.READ_ONLY);
		moveValue.setText(Integer.toString(ch.move));

		Label fameLabel = new Label(derivedComposite, SWT.NONE);
		fameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		fameLabel.setText("FAME");

		fameValue = new Text(derivedComposite, SWT.BORDER | SWT.READ_ONLY);
		fameValue.setText(Integer.toString(ch.fame));
	}
}