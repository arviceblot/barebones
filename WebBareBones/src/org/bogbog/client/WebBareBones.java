package org.bogbog.client;

/*
 * File: WebBareBones.java
 * 
 * Item 1. BASIC INFORMATION
 * Name: Logan Sales
 * Class: CS 5551
 * Section: 2, TA: Sakethram Karumuri
 * Instructor: Dr. Doug Dunham
 * Assignment: Project Implementation - Phase II, Final Demo, December 11, 2014
 */

import java.util.ArrayList;
import java.util.List;

import org.bogbog.client.dao.CharacterService;
import org.bogbog.client.dao.CharacterServiceAsync;
import org.bogbog.client.dao.LoginService;
import org.bogbog.client.dao.LoginServiceAsync;
import org.bogbog.client.wizards.CharacterWizard;
import org.bogbog.shared.Ability;
import org.bogbog.shared.Character;
import org.bogbog.shared.LoginInfo;
import org.bogbog.shared.Race;
import org.bogbog.shared.Skill;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WebBareBones extends Composite implements EntryPoint {
	private static WebBareBonesUiBinder uiBinder = GWT
			.create(WebBareBonesUiBinder.class);
	@UiField
	FlowPanel mainPanel;
	@UiField
	MenuBar mainMenuBar;
	@UiField
	MenuItem saveMenuItem;
	@UiField
	MenuItem openMenuItem;
	@UiField
	MenuItem newCharacterMenuItem;
	@UiField
	TabLayoutPanel tabPanel;
	@UiField
	FlowPanel characterPanel;
	/*
	 * @UiField ListBox kindnessMajor;
	 * 
	 * @UiField ListBox kindnessMinor;
	 * 
	 * @UiField ListBox focusedMajor;
	 * 
	 * @UiField ListBox focusedMinor;
	 * 
	 * @UiField ListBox selflessMajor;
	 * 
	 * @UiField ListBox selflessMinor;
	 * 
	 * @UiField ListBox honorableMajor;
	 * 
	 * @UiField ListBox honorableMinor;
	 * 
	 * @UiField ListBox braveMajor;
	 * 
	 * @UiField ListBox braveMinor;
	 */
	@UiField
	MenuItem loginMenu;
	@UiField
	MenuItem loginMenuItem;
	@UiField
	TextBox nameValue;
	@UiField
	TextBox raceValue;
	@UiField
	TextBox dpValue;
	@UiField
	IntegerBox bpValue;
	@UiField
	IntegerBox initValue;
	@UiField
	IntegerBox drValue;
	@UiField
	IntegerBox movValue;
	@UiField
	IntegerBox rankValue;
	@UiField
	IntegerBox strValue;
	@UiField
	IntegerBox dexValue;
	@UiField
	IntegerBox logValue;
	@UiField
	IntegerBox wilValue;
	@UiField
	TextBox features;
	@UiField
	TextBox descriptors;
	@UiField
	TextBox gender;
	@UiField(provided = true)
	CellTable<Skill> skillsTable;

	private Character character;
	private LoginInfo login;
	// private static final String[] MORALITY_VALUES = { "Somewhat", "Totally",
	// "Very" };
	private static CharacterServiceAsync characterService = GWT
			.create(CharacterService.class);
	private static LoginServiceAsync loginService = GWT
			.create(LoginService.class);

	interface WebBareBonesUiBinder extends UiBinder<Widget, WebBareBones> {
	}

	public WebBareBones() {
		skillsTable = new CellTable<Skill>();

		initWidget(uiBinder.createAndBindUi(this));

		login = null;

		List<Ability> abilities = new ArrayList<Ability>();
		abilities.add(new Ability(Ability.Type.STR, 65, 0));
		abilities.add(new Ability(Ability.Type.DEX, 60, 0));
		abilities.add(new Ability(Ability.Type.LOG, 55, 0));
		abilities.add(new Ability(Ability.Type.WIL, 50, 0));

		List<Skill> skills = new ArrayList<Skill>();
		skills.add(Skill.CLERIC.clone());
		skills.add(Skill.ENCHANTER.clone());
		skills.add(Skill.LEADER.clone());
		skills.add(Skill.SCHOLAR.clone());
		skills.add(Skill.SCOUT.clone());
		skills.add(Skill.SPELLCASTER.clone());
		skills.add(Skill.THIEF.clone());
		skills.add(Skill.WARRIOR_MELEE.clone());
		skills.add(Skill.WARRIOR_RANGED.clone());

		character = new Character("Jeffrey", Race.HUMAN.clone(), abilities,
				skills);
		character.gender = "Male";
		character.hair = "Purple";
		character.eyes = "Orange";
		character.descriptors = "Brash, Cowardly";

		character.getSkill(Skill.CLERIC).level = 1;
		character.getSkill(Skill.WARRIOR_MELEE).isPrimary = true;
		character.getSkill(Skill.THIEF).isSecondary = true;
	}

	public void updateCharacterUI() {
		nameValue.setText(character.name);
		raceValue.setText(character.race.name);
		rankValue.setValue(character.rank);
		dpValue.setText(character.dpUsed + "/" + character.dpTotal);

		gender.setText(character.gender);
		features.setText(character.hair + "/" + character.eyes);
		descriptors.setText(character.descriptors);

		strValue.setValue(character.getAbility(Ability.Type.STR)
				.getModifiedValue());
		dexValue.setValue(character.getAbility(Ability.Type.DEX)
				.getModifiedValue());
		logValue.setValue(character.getAbility(Ability.Type.LOG)
				.getModifiedValue());
		wilValue.setValue(character.getAbility(Ability.Type.WIL)
				.getModifiedValue());

		this.bpValue.setValue(character.bp);
		this.initValue.setValue(character.init);
		this.drValue.setValue(character.dr);
		this.movValue.setValue(character.move);

		/*
		 * for (String item : WebBareBones.MORALITY_VALUES) {
		 * this.kindnessMinor.addItem(item); this.braveMinor.addItem(item);
		 * this.focusedMinor.addItem(item); this.honorableMinor.addItem(item);
		 * this.selflessMinor.addItem(item); }
		 */

		// update skills
		this.skillsTable.setRowCount(0, true);
		skillsTable.setRowCount(character.skills.size(), true);
		skillsTable.setRowData(0, character.skills);
	}

	@Override
	public void onModuleLoad() {
		/*
		 * // Get rid of scrollbars, and clear out the window's built-in margin,
		 * // because we want to take advantage of the entire client area.
		 * Window.enableScrolling(false); Window.setMargin("0px");
		 */

		// create the skills table
		Column<Skill, String> nameColumn = new Column<Skill, String>(
				new TextCell()) {
			@Override
			public String getValue(Skill skill) {
				return skill.name;
			}
		};
		skillsTable.addColumn(nameColumn, "Skills");
		Column<Skill, String> abilityColumn = new Column<Skill, String>(
				new TextCell()) {
			@Override
			public String getValue(Skill skill) {
				return skill.ability.getName();
			}
		};
		skillsTable.addColumn(abilityColumn, "Ability");
		Column<Skill, Number> levelColumn = new Column<Skill, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Skill skill) {
				return skill.level;
			}
		};
		skillsTable.addColumn(levelColumn, "Level");
		Column<Skill, String> primarySecondaryColumn = new Column<Skill, String>(
				new TextCell()) {
			@Override
			public String getValue(Skill skill) {
				if (skill.isPrimary) {
					return "P";
				} else if (skill.isSecondary) {
					return "S";
				} else {
					return "";
				}
			}
		};
		skillsTable.addColumn(primarySecondaryColumn, "P/S");
		Column<Skill, Number> scoreColumn = new Column<Skill, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Skill skill) {
				return skill.getScore(character.getAbility(skill.ability)
						.getModifiedValue());
			}
		};
		skillsTable.addColumn(scoreColumn, "Score");
		Column<Skill, String> notesColumn = new Column<Skill, String>(
				new TextCell()) {
			@Override
			public String getValue(Skill skill) {
				return skill.notes;
			}
		};
		skillsTable.addColumn(notesColumn, "Notes");

		// Check login status using login service.
		loginService.login(GWT.getHostPageBaseURL(),
				new AsyncCallback<LoginInfo>() {
					public void onFailure(Throwable error) {
					}

					public void onSuccess(LoginInfo result) {
						login = result;
						if (login.isLoggedIn()) {
							loginMenu.setText(login.getNickname());
							loginMenuItem.setText("Logout");
							// also change the url to logout
						} else {
							loginMenu.setText("Login");
							loginMenuItem.setText("Login");
						}
					}
				});
		loginMenuItem.setScheduledCommand(new ScheduledCommand() {
			@Override
			public void execute() {
				// login or logout
				if (login.isLoggedIn()) {
					Window.Location.assign(login.getLogoutUrl());
				} else {
					Window.Location.assign(login.getLoginUrl());
				}
			}
		});

		saveMenuItem.setScheduledCommand(new ScheduledCommand() {
			@Override
			public void execute() {
				if (login.isLoggedIn()) {
					// update the character if it exists, otherwise create it
					characterService.create(character,
							new AsyncCallback<Character>() {
								@Override
								public void onFailure(Throwable caught) {
								}

								@Override
								public void onSuccess(Character result) {
									// update the local character
									character = result;

									// add the character to the list of
									// characters for the user
									login.characters.add(character);

									// update the login info so that it is
									// current with the stored characters
									loginService.update(login, login.getId(),
											new AsyncCallback<Void>() {
												@Override
												public void onFailure(
														Throwable caught) {
												}

												@Override
												public void onSuccess(
														Void result) {
												}
											});
								}
							});
				}
			}
		});

		this.newCharacterMenuItem.setScheduledCommand(new ScheduledCommand() {
			@Override
			public void execute() {
				// display the login popup
				final DialogBox characterDialog = new DialogBox();
				final CharacterWizard charWiz = new CharacterWizard();
				VerticalPanel charPanel = new VerticalPanel();
				charPanel.add(charWiz);

				HorizontalPanel buttons = new HorizontalPanel();
				Button acceptButton = new Button("Accept", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						character = charWiz.getCharacter();
						updateCharacterUI();
						characterDialog.hide();
					}
				});
				buttons.add(acceptButton);
				Button cancelButton = new Button("Cancel", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						characterDialog.hide();
					}
				});
				buttons.add(cancelButton);

				charPanel.add(buttons);

				characterDialog.setText("New Character");
				characterDialog.setWidget(charPanel);
				characterDialog.setGlassEnabled(true);
				characterDialog.setAnimationEnabled(true);
				characterDialog.center();
				characterDialog.show();
			}
		});

		this.openMenuItem.setScheduledCommand(new ScheduledCommand() {
			@Override
			public void execute() {
				if (login.isLoggedIn()) {
					// create the character chooser dialog with the characters
					// of the user
					final DialogBox characterDialog = new DialogBox();

					VerticalPanel characterPanel = new VerticalPanel();
					final ListBox characterList = new ListBox();
					final List<Character> characters = new ArrayList<Character>();
					for (Character saved : login.characters) {
						characterList.addItem(saved.name + " "
								+ saved.race.name + " " + saved.rank);
					}
					characterPanel.add(characterList);

					HorizontalPanel buttons = new HorizontalPanel();
					Button acceptButton = new Button("Accept",
							new ClickHandler() {
								@Override
								public void onClick(ClickEvent event) {
									character = characters.get(characterList
											.getSelectedIndex());
									updateCharacterUI();
									characterDialog.hide();
								}
							});
					buttons.add(acceptButton);
					Button cancelButton = new Button("Cancel",
							new ClickHandler() {
								@Override
								public void onClick(ClickEvent event) {
									characterDialog.hide();
								}
							});
					buttons.add(cancelButton);

					characterPanel.add(buttons);

					characterDialog.setText("Open Character");
					characterDialog.setWidget(characterPanel);
					characterDialog.setGlassEnabled(true);
					characterDialog.setAnimationEnabled(true);
					characterDialog.center();
					characterDialog.show();
				}
			}

		});

		updateCharacterUI();

		RootLayoutPanel root = RootLayoutPanel.get();
		root.add(this);
	}
}
