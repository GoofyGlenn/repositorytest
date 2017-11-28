package csvstuff;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
	
	public CsvReader(String filename) {
		try {
			FileReader fr = new FileReader(filename);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
private	BufferedReader br = null;	// buffered reader som venter på flush() eller close før den læser det hele
private	String line  =""; // er med til at 
private String split= ",";
//private String [] values;
	
 public  void read() {	
	try {
		while((line = br.readLine()) != null) {
			// indsætter splitteren
			 String[] values = line.split(split);
			for(String part : values) {
				System.out.println(part);
			}
		}
		br.close();
	} catch (FileNotFoundException ex){
		System.out.println("you've dun goof'd fuckboy");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
