package input;
import java.util.ArrayList;

public class ReaderAtbashDecorator implements DocumentDecoder
{
	private ArrayList<String> myText;
	
	public ReaderAtbashDecorator(ArrayList<String> myText)
	{
		this.myText = myText;
	}
	
	public ArrayList<String> decoder() // method that decodes a string into Rot13 and returns it
	{
		int k=0;
		char[] tempString=null;
		for(String str:  this.myText)
		{
			tempString = str.toCharArray();
			for(int j=0; j<str.length(); j++)
			{	
				if(tempString[j] >= 'a' && tempString[j] <= 'z')
				{
					tempString[j]=(char)((155+64 - tempString[j])); //based on ascii and wiki 219
		        }  
		        else if ((tempString[j]-'A'>=0) && ( 0<= 'Z'-tempString[j]))
		        {	
		        	tempString[j]=(char)((5+ tempString[j])); //based on wikipedia and ascii
		        }
		    }
			String decodedString = new String(tempString);
			this.myText.set(k, decodedString);
			k++;
		}
		return this.myText;
	}
}
