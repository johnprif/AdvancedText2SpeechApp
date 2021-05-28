package input;

import java.util.ArrayList;

public class DocumentReaderFactory
{
	private WordReader wordDoc;
	private ExcelReader excelDoc;
	public ArrayList<String> temp;
	
	public DocumentReaderFactory(String type, String fileNameWithPath) // we check the file type and we create the proper class object
	{
		if(type.equals("xlsx"))
		{
			excelDoc = new ExcelReader(fileNameWithPath);
			temp = excelDoc.read();
		}else if(type.equals("docx"))
		{
			wordDoc = new WordReader(fileNameWithPath);
			temp = wordDoc.read();
		}
		else if(type.equals("other"))
		{
			OtherFileReader otherFile = new OtherFileReader(fileNameWithPath);
			temp = otherFile.read(); 
		}
		else
		{
			System.exit(-1);
		}
	}
	
	public ArrayList<String> getList()
	{
		return temp;
	}
}
