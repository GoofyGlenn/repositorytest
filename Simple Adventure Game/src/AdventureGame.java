import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import csvstuff.*;
public class AdventureGame {

	/**
	 * Appends an instance of {@link Adventurer} to the log file. The log file is
	 * formatted as a CSV-file with the following columns: <list>
	 * <li>Name</li></list> <list>
	 * <li>XP</li></list> <list>
	 * <li>Level</li></list> <list>
	 * <li>Weapon</li></list> <br/>
	 * 
	 * @param hero to be added to the log
	 */
	private static void addAdventurerToLog(Adventurer hero) {
		// hver gang write kaldes så laves der et nyt stykke i csv filen
		CsvWriter csv = new CsvWriter("output.csv");
		csv.addData(""+hero.getXP());
		csv.addData(hero.getName());
		csv.addData(hero.getWeapon());
		csv.write();
		csv.save();
		csv.addData(hero.getName());
		csv.write();
		csv.methodend();
		// Append to CSV-file
	}

	/**
	 * Prints the contents of the log file 
	 * appropriately formatted for screen output.
	 */
	private static void printHistory() {
		//HUSK AT LAVE INSTANCER OG DERFOR UNDGÅR MAN AT SKULLE LAVE ALT STATIC!!!!!!!!!!!!
		CsvReader csvread = new CsvReader("output.csv");
		csvread.read();
		// Print the CSV-file
	}

	public static void main(String[] args) {
		String name = null;
		String weapon = null;
		if (args != null && args.length >= 1) {
			name = args[0];
			if (args.length >= 2) {
				weapon = args[1];
			}
		}

		Adventurer hero;
		if (name != null)
			hero = loadAdventurer(name);
		else
			hero = new Adventurer();

		if (weapon != null)
			hero.useWeapon(weapon);

		System.out.println(hero.getName() + " has slain a dragon!");
		hero.giveXP();
		System.out.println(hero);

		if (!hero.getName().equals(Adventurer.STANDARD_NAME))
			saveAdventurer(hero);

		addAdventurerToLog(hero);
		printHistory();
	}

	private static Adventurer loadAdventurer(String name) {
		Adventurer adventurer;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(name + ".char"));
			adventurer = (Adventurer) is.readObject();
			is.close();
			System.out.println("Adventurer loaded: " + adventurer);
		} catch (Exception ioe) {
			System.out.println("No adventurer found. Creating a new adventurer!");
			adventurer = new Adventurer(name);
			System.out.println("Adventurer created: " + adventurer);
		}
		return adventurer;
	}

	private static void saveAdventurer(Adventurer adventurer) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream(adventurer.getName() + ".char"));
			os.writeObject(adventurer);
			os.close();
			System.out.println("Adventurer saved!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
