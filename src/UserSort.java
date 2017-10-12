import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UserSort {

	public static void main(String[] args) {
	
        int listSize = 0;
        
        //TODO: read filename from user instead of stating in program 
        //TODO: add intro to program to orient user
		
		//file reading sourced from https://www.roseindia.net/java/beginners/java-read-file-line-by-line.shtml
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("data/testdata.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  System.out.println (strLine);
			  listSize++;
			  }
			  System.out.println("Total items in list: " + listSize);
			  
			  String[] initialList = new String[listSize];
			  listSize = 0;
			  
			  //do steps again to fill initialList array
			  //I know this is technically not efficient, but computational time complexity of this program shouldn't matter
			  FileInputStream fstream1 = new FileInputStream("data/testdata.txt");
			  DataInputStream in1 = new DataInputStream(fstream1);
			  BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
			  String strLine1;
			  while ((strLine1 = br1.readLine()) != null)   {
			  // Add the content to the initialList array
			  initialList[listSize] = strLine1;
			  listSize++;
			  }
			  System.out.println("Initial Array: " + Arrays.toString(initialList));
			  
			  //Close the input stream
			  in1.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
			  	

	}

}
