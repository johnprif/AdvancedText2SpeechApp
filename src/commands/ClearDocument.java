package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class ClearDocument implements ActionListener
{
	JTextArea ta;
	
	public ClearDocument(JTextArea ta)
	{
		this.ta=ta;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
        ta.setText("");
    }
}
