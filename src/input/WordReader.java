package input;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordReader implements DocumentReader
{
	private String fileNameWithPath; 
	public WordReader(String fileNameWithPath)
	{
		this.fileNameWithPath=fileNameWithPath;
	}
	
	public ArrayList<String> read() // reads a word file and  and puts its content in an ArrayList
	{
		XWPFDocument document = null;
		FileInputStream fileInputStream = null;
		XWPFWordExtractor extractor=null;
		ArrayList<String> list=new ArrayList<String>();
		try 
		{
			File fileToBeRead = new File(fileNameWithPath);
			fileInputStream = new FileInputStream(fileToBeRead);
			document = new XWPFDocument(fileInputStream);
			extractor = new XWPFWordExtractor(document); 
			list.add(extractor.getText()+"\n");
		} catch (Exception e) 
		{
			System.out.println("We had an error while reading the Word Doc");
		} finally 
		{
			try 
			{
				if (document!=null) 
				{
					document.close();
				}
				if (fileInputStream!=null) 
				{
					fileInputStream.close();
				}
				if(extractor!=null)
				{
					extractor.close();
				}
			} catch (Exception ex) 
			{
			}
		}
		return list;
	}
}
