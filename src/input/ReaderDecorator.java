package input;

import java.util.ArrayList;
import java.util.List;


//abstract
public class ReaderDecorator implements DocumentReader
{
	public ReaderDecorator(DocumentReader doc)
	{
		
	}
	
	//abstract
	public ArrayList<String> read()
	{
		return null;
	}
}
