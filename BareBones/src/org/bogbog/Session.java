package org.bogbog;

import java.util.logging.Logger;

public class Session {
	private static Character character;
	private static String characterFilePath;
	private static final Logger LOGGER = Logger.getLogger(Session.class.getName());

	public Session() {
		character = new Character();
		characterFilePath = "";
	}

	public static Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		Session.character = character;
	}

	public void save(String filename) {
		// save the session (character, prefs. etc?) to file
	}
	
	public static void loadCharacter(String filename) {
		// load the character
		characterFilePath = filename; // if valid?
	}

}
