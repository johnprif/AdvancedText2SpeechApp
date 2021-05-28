package commands;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import input.ReaderRot13Decorator;
import javax.swing.JTextArea;

public class ROT13 implements ItemListener
{
	private ArrayList<String> content;
	private JTextArea ta;
	private String[] taString;
	
	public ROT13(JTextArea ta)
	{
		this.ta = ta;
		taString = new String[1];	
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getStateChange()==1) // flag , selected or unselected
		{
			taString[0] = ta.getText();
			content = new ArrayList<String>(Arrays.asList(taString));  // we add text area to a list in order to decode it 
			ReaderRot13Decorator atbash = new ReaderRot13Decorator(content); // we take the list in order to decode it in the proper class
			taString[0]=atbash.decoder().get(0); // we add the decoded content back to the text area
			ta.setText(taString[0]);
		}
	}
}
