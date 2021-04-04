package model;

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
		contents=new ArrayList<String>();
	}
	
	public void setAudioManager(TTSFacade ttsssssss)
	{
		
	}
	
	public void setDocReaderFactory(DocumentReaderFactory doc)
	{
		
	}
	
	public void setDocWriterFactory(DocumentWriterFactory doc)
	{
		
	}
	
	public void open(String a, String b, String c)
	{
		
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

