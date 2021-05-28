package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.util.ArrayList;

public class LockDocument implements ActionListener 
{
	private JTextArea ta;
	private Boolean flag;
	private ArrayList<String> textButtonList;
	private JButton button;
	private ArrayList<Icon> iconButtonList;
	
	public LockDocument(JTextArea ta, JButton button)
	{
		this.ta = ta;
		this.button = button;
		flag=true;
		textButtonList = new ArrayList<String>();
		textButtonList.add("Lock");
		textButtonList.add("UnLock");
		
		Icon iconLock = new ImageIcon(System.getProperty("user.dir") + "\\icons\\lock.png");
		Icon iconUnlock = new ImageIcon(System.getProperty("user.dir") + "\\icons\\unlock.png");
		
		iconButtonList = new ArrayList<Icon>();
		iconButtonList.add(iconLock);
		iconButtonList.add(iconUnlock);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		flag=!flag;
        ta.setEditable(flag);
        button.setText(textButtonList.get(flag? 0 : 1));
        button.setIcon(iconButtonList.get(flag? 0 : 1));
    }
}
