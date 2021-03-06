import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class UserSort {
	 static int listSize = 0;
	 static int listSize1 = 0;
     static String[] initialList = null;
     static String[] outputList = null;
     static int outputListSize = 0;

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	
       
        
        
        //TODO: read filename from user instead of stating in program 
        //TODO: add intro to program to orient user
		
		//file reading sourced from https://www.roseindia.net/java/beginners/java-read-file-line-by-line.shtml
		try{
			
			  Scanner filenameScanner = new Scanner(System.in); 
			  System.out.println("Please enter the name of the input file (with .txt extension)");
			  String inputFileName = filenameScanner.nextLine();
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("data/" + inputFileName);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			      listSize++;
			  }
			  System.out.println("Total items in list: " + listSize);

			  initialList = new String[listSize];
			  outputList = new String[listSize];

			  
			  //do steps again to fill initialList array
			  //I know this is technically not efficient, but computational time complexity of this program shouldn't matter
			  FileInputStream fstream1 = new FileInputStream("data/testdata.txt");
			  DataInputStream in1 = new DataInputStream(fstream1);
			  BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
			  String strLine1;
			  while ((strLine1 = br1.readLine()) != null)   {
			  // Add the content to the initialList array
			  initialList[listSize1] = strLine1;
			  listSize1++;
			  }
			  System.out.println("Initial Array: " + Arrays.toString(initialList));
			  
			  //Close the input stream
			  in1.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		
		
		//add the first element of the initial list to the output list
		outputList[0] = initialList[0];
		outputListSize = 1;
		
		for(int i=1; i<listSize; i++){
			insert(initialList[i]);
		}	
		//print the final ordering to the console
		System.out.println(Arrays.toString(outputList));
		//write the ordering to a text file
		Scanner filenameScanner2 = new Scanner(System.in); 
		System.out.println("Please enter the name of the output file (with .txt extension)");
		String outputFileName = filenameScanner2.nextLine();
		//TODO: generate filenames based on date/time so as not to overwrite previous outputs
		PrintWriter writer = new PrintWriter("data/" + outputFileName, "UTF-8");
		writer.println("Final list ordering");
		for(int j = 0; j < outputListSize; j++){
			writer.println("Item " + (j + 1) + ": " + outputList[j]);
		}
		writer.close();
	}
	

	private static void insert(String string) {
		int insertSpot = 0;
		System.out.println(Arrays.toString(outputList));
		insertSpot = findSpot(string);
		System.out.println("Insert spot: " + insertSpot);
		shiftUp(insertSpot, string);
	    outputListSize++;	
	}
	
	private static int findSpot(String string){
        int checkBound0 =  0;
        int checkBound1 =  outputListSize; // - 1;
        int checkPoint = 0;
        do  {
        	checkPoint = (int) Math.floor( (checkBound0 + checkBound1) / 2);
        	System.out.println("enter 1 to select " + outputList[checkPoint] + " , enter 2 to select " + string);
        	Scanner in = new Scanner(System.in);
        	int oneOrTwo = in.nextInt();		
        	if(oneOrTwo == 1){
        		if(checkBound0 != checkPoint){
        			checkBound0 = checkPoint;
        		}
        		checkBound0 = checkBound0 + 1;
        	} else if (oneOrTwo == 2) {
        		checkBound1 = checkPoint;
        	} else {
        		System.out.println("Must enter 1 or 2");
        	}
        	
        } while (checkBound0 != checkBound1 && checkBound0 < checkBound1);
		return checkBound0;
	}
	
	private static void shiftUp(int shiftSpot, String string){
		for(int i = outputListSize; i > shiftSpot; i--) {
			outputList[i] = outputList[i-1];
		}
		//String temp = outputList[shiftSpot];
		outputList[shiftSpot] = string;
	}

}
