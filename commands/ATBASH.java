package commands;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import input.*;
import javax.swing.JTextArea;

public class ATBASH implements ItemListener
{
	private ArrayList<String> content;
	private JTextArea ta;
	private String[] taString;
	
	public ATBASH(JTextArea ta)
	{
		this.ta = ta;
		taString = new String[1];
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getStateChange()==1)
		{
			taString[0] = ta.getText();
			content = new ArrayList<String>(Arrays.asList(taString)); // we add the contents of tect area to an arrray list
			ReaderAtbashDecorator atbash = new ReaderAtbashDecorator(content); // we take the list in order to decode it in the proper class
			taString[0]=atbash.decoder().get(0); // we add the decoded content back to the text area
			ta.setText(taString[0]);
		}
	}
}
