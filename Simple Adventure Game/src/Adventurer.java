import java.io.Serializable;

public class Adventurer implements Serializable {

	private static final long serialVersionUID = 1973122780481441326L;

	public static final String STANDARD_NAME = "Nameless Hero";
	
	private int xp = 0;
	private String name = STANDARD_NAME;
	private String weapon = "Sword";
	
	public Adventurer() {
		
	}

	public Adventurer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void giveXP() {
		xp += (int)(Math.random()*400);
	}
	
	public int getXP() {
		return xp;
	}
	
	public void useWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public String getWeapon() {
		return weapon;
	}

	/**
	 * Calculates and returns the level of the character based on the amount of XP.
	 * The character begins at level 1 (0 XP and gains 1 level per 1000 XP).
	 * 
	 * @return the level of the character
	 * @see Adventurer
	 */
	public int getLevel() {
		return xp / 1000 + 1;
	}

	public String toString() {
		return getName() + " is level " + getLevel() + " (" + getXP()
				+ " XP) + and armed with a " + getWeapon();
	}

}
