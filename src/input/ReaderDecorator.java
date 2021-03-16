package input;

import java.util.List;


//abstract
public class ReaderDecorator implements DocumentReader
{
	public ReaderDecorator(DocumentReader doc)
	{
		
	}
	
	//abstract
	public List<String> read()
	{
		return null;
	}
}
