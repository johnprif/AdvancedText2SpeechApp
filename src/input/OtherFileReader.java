package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OtherFileReader implements DocumentReader
{
	private String fileNameWithPath; 
	
	public OtherFileReader(String fileNameWithPath)
	{
		this.fileNameWithPath = fileNameWithPath;
	}
	
	public ArrayList<String> read() // we open any other kind of file and puts its content in an ArrayList
	{
		ArrayList<String> list = new ArrayList<String>();
		try {
	      File myObj = new File(fileNameWithPath);
	      Scanner input = new Scanner(myObj);
	      while (input.hasNextLine()) {
	        String data = input.nextLine(); // we read the file line by line and add it to a list
	        list.add(data+"\n");
	      }
	      input.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		return list;
	}
}
