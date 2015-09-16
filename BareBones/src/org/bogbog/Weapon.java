package org.bogbog;

public class Weapon {
	private String name;
	private int range;
	private int score;
	private int damageDice;
	private int damageModifier;
	private int ammo;
	private String notes;

	public Weapon() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getDamageDice() {
		return damageDice;
	}

	public void setDamageDice(int damageDice) {
		this.damageDice = damageDice;
	}

	public int getDamgaeModifier() {
		return damageModifier;
	}

	public void setDamgaeModifier(int damageModifier) {
		this.damageModifier = damageModifier;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
