package model;
import java.util.ArrayList;
import input.DocumentReaderFactory;

public class Document 
{
	private ArrayList<String> contents;
	private TTSFacade audioManager;
	private DocumentReaderFactory docReaderFactory;
	private String fileNameWithPath;
	
	public Document()
	{
		audioManager = new TTSFacade();
	}
	
	public void setFileNameWithPath(String fileNameWithPath) // gets the path of the file
	{
		this.fileNameWithPath = fileNameWithPath;
	}
	
	public ArrayList<String> getContent() // gets content of the file
	{
		contents = new ArrayList<String>(docReaderFactory.getList());
		return contents;
	}
	
	public void setAudioManager(TTSFacade ttss)
	{
		audioManager = ttss;
	}
	
	public void setDocReaderFactory(DocumentReaderFactory doc)
	{
		docReaderFactory = doc;
	}

	public void open(String fileName) // checks what kind of file we want to open and calls the proper class
	{
		if(fileName.contains("docx")) 
		{
			docReaderFactory = new DocumentReaderFactory("docx", fileNameWithPath);
		}else if(fileName.contains("xlsx"))
		{
			docReaderFactory = new DocumentReaderFactory("xlsx", fileNameWithPath);
		}
		else //other files include .doc and .xls
		{
			docReaderFactory = new DocumentReaderFactory("other", fileNameWithPath);
		}
	}
}

