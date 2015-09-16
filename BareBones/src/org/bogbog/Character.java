package org.bogbog;

import java.util.ArrayList;
import java.util.List;

public class Character {
	public String name;
	public String race;

	public int str;
	public int dex;
	public int log;
	public int wil;

	public int bp;
	public int init;
	public int dr;
	public int move;
	public int fame;

	public List<Weapon> weapons;
	public List<Spell> spells;

	public Character() {
		name = "";
		race = "";
		str = 0;
		dex = 0;
		log = 0;
		wil = 0;
		bp = 0;
		init = 0;
		dr = 0;
		move = 0;
		fame = 0;
		weapons = new ArrayList<Weapon>();
		spells = new ArrayList<Spell>();
	}

	public int updateBp() {
		bp = str / 2;
		return bp;
	}

	public int updateInit() {
		init = 1;
		if (log >= 65)
			init += 1;
		if (dex >= 65)
			init += 1;
		return init;
	}
}
