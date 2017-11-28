package csvstuff;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvWriter {

	// static String CSVFilename = "output.csv";

	// bufferedwriter wr ny writer = null
	/*
	 * String line som er ingenting array values string split som er , int, string,
	 * string public void write( name weapon) { filewriter fw = new filewriter
	 * (CSVfilename) fw.write name fw.write split fw.write.weapon disse skal være
	 * 
	 * }
	 * 
	 */
	public CsvWriter(String filename) {
		// constructor hvor filewriter erklæres bufferedwriter erklæres som instance
		// variable udenfor constructor

		// constructoren er der til at definere hvad der skal være når den CSvwriter
		// kaldes eller erklæres
		try {
			FileWriter fw = new FileWriter(filename);
			wr = new BufferedWriter(fw);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addData(String data) {

		datarow.add(data);
		datarow.add(split);
		
	}

	ArrayList<String> datarow = new ArrayList<String>();

	public void addData(double data) {

		datarow.add(data + "");
		datarow.add(split);
		
	}
		

	private BufferedWriter wr;
	private String split = ",";

	// data er variable som ikke skal defineres yderligere
	public void write() {
		try {
			if(datarow.size()==0) {
				System.out.println("please add data faggot");
			} else {
			datarow.remove(datarow.size()-1);
			String [] newdatarow = new String[datarow.size()];
			newdatarow= datarow.toArray(newdatarow);
			for (int x =0; x<newdatarow.length; x++) {
				wr.write(newdatarow[x]);
			}
			wr.newLine();
			}
//			wr.write(data);
//			wr.write(split);
//			wr.flush();
//			 skal gøres mere fleksibel med mulig for loop

		} catch (IOException ex) {
		
		}
		
	}
	// method end er med til at afslutte metoden write, så den kan adskilles hver
	// gang den kaldes uden at overskirve sig selv

	public void save () {
		try {
			wr.flush();
			datarow.clear();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void methodend() {
		try {
			wr.close();
			datarow.clear();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
