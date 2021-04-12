package model;
import input.*;

import java.util.ArrayList;

import input.DocumentReader;
import input.DocumentReaderFactory;

public class Document 
{
	private ArrayList<String> contents;
	private TTSFacade audioManager;
	private DocumentReader documentReader;
	private DocumentReaderFactory docReaderFactory;
	private DocumentWriter documentWriter;
	private DocumentWriterFactory docWriterFactory;	
	
	public Document()
	{
		contents = new ArrayList<String>();
		audioManager = new TTSFacade();
		//documentReader = new DocumentReader();
		//docReaderFactory = new DocumentReaderFactory();
		documentWriter = new DocumentWriter();
		docWriterFactory = new DocumentWriterFactory();
	}
	
	public void setAudioManager(TTSFacade ttss)
	{
		audioManager = ttss;
	}
	
	public void setDocReaderFactory(DocumentReaderFactory doc)
	{
		docReaderFactory = doc;
	}
	
	public void setDocWriterFactory(DocumentWriterFactory doc)
	{
		docWriterFactory = doc;
	}

	public void open(String fileName, String path, String ifEncoded)
	{
		
	//	String extension = fileName.contains("Java8");
	//	DocumentReaderFactory doc = new DocumentReaderFactory("Excel", String ifDecoded);
	}
	
	public void playContents()
	{
		
	}
	
	public void playLine(int x)
	{
		
	}
	
	public void save(String a, String b, String c)
	{
		
	}
}

