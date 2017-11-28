package csvstuff;

import csvstuff.CsvReader;
import csvstuff.CsvWriter;
public class Tester {


	public static void main(String [] args ) {
		String john = "john";
		String jane = "jane";
		String james = "james";
		CsvWriter csvwrite = new CsvWriter("names.csv");
		CsvReader csvread = new CsvReader("names.csv");
		csvwrite.addData(john);
		csvwrite.addData(jane);
		csvwrite.addData(james);
		csvwrite.write();
		csvwrite.save();
		
		csvread.read();
	}
}
