package input;
import java.util.ArrayList;

public class ReaderRot13Decorator implements DocumentDecoder
{
	private ArrayList<String> myText;
	
	public ReaderRot13Decorator(ArrayList<String> myText)
	{
		this.myText = myText;
	}
	
	public ArrayList<String> decoder() // method that decodes a string into Rot13 and returns it
	{
		int k=0;
		char[] tempString=null;
		for(String str:  this.myText)
		{
			tempString=str.toCharArray();
			for(int j=0; j<str.length(); j++)
			{
				if(tempString[j] >= 'a' && tempString[j] <= 'm')
				{
					tempString[j] += 13;
					
				}else if(tempString[j] >= 'A' && tempString[j] <= 'M') 
				{
					tempString[j] += 13;
					
				}else if  (tempString[j] >= 'n' && tempString[j] <= 'z')
				{
					tempString[j] -= 13;
					
				}else if  (tempString[j] >= 'N' && tempString[j] <= 'Z')
				{
					tempString[j] -= 13;
					
				}
			}
			String decodedString = new String(tempString);
			this.myText.set(k, decodedString);
			k++;
		}
		return this.myText; 
	}
}
