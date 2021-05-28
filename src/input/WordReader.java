package input;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordReader implements DocumentReader
{
	public WordReader()
	{
		
	}
	
	public ArrayList<String> read()
	{
		XWPFDocument document = null;
		FileInputStream fileInputStream = null;
		XWPFWordExtractor extractor=null;
		ArrayList<String> list=new ArrayList<String>();
		try 
		{			//GET THE PATH AUTOMA...
			File fileToBeRead = new File("C:\\Users\\johnprif\\Desktop\\data2.docx");
			fileInputStream = new FileInputStream(fileToBeRead);
			document = new XWPFDocument(fileInputStream);
			extractor = new XWPFWordExtractor(document); 
			System.out.println("The Contents of the Word File are ::");
			System.out.println("--------------------------------------");
			System.out.println(extractor.getText());
			list.add(extractor.getText());
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
