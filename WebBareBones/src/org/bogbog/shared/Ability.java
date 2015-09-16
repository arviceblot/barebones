package org.bogbog.shared;

import java.io.Serializable;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(detachable = "true")
public class Ability implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	@Persistent
	@Embedded
	public Type type;
	@Persistent
	public int modifier;
	@Persistent
	public int value;

	public Ability() {

	}

	public Ability(Type type, int value, int modifier) {
		this.type = type;
		this.modifier = modifier;
		this.value = value;
	}

	public String getId() {
		return this.id;
	}

	public int getModifiedValue() {
		return this.value + this.modifier;
	}

	@PersistenceCapable(detachable = "true")
	@EmbeddedOnly
	public static class Type implements Serializable {

		@Persistent
		private String name;

		public Type() {

		}

		public Type(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public static Type STR = new Type("STR");
		public static Type DEX = new Type("DEX");
		public static Type LOG = new Type("LOG");
		public static Type WIL = new Type("WIL");
	}

}
