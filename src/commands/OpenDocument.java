package commands;

import java.awt.event.ActionEvent;

import model.*;

public class OpenDocument implements ActionListener
{
	private Document doc;
	private ReplayManager rep;
	public OpenDocument()
	{
		
	}
	
	public void setDocument(Document doc)
	{
		this.doc = doc;
	}
	
	public void setReplayManager(ReplayManager rep)
	{
		this.rep = rep;
	}
	
	public void actionPerformed(ActionEvent eve)
	{
		
	}
}
