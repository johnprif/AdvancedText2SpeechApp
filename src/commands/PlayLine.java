package commands;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import commands.Play;

import model.TTSFacade;

public class PlayLine extends JFrame implements ActionListener
{
	private JTextArea ta;
	private Boolean flag;
	private ArrayList<String> textButtonList;
	private JButton button;
	private ArrayList<Icon> iconButtonList;
	private TTSFacade ttsf;
	private TextField text;
	private SliderButton sliderButton;
	public int line = 0;
	private ArrayList<String> replayArList; 
	
	public PlayLine(JTextArea ta, TextField text, JButton button, SliderButton sliderButton, Play pl)
	{
		ttsf = new TTSFacade();
		this.ta = ta;
		this.text = text;
		this.button = button;
		this.sliderButton = sliderButton;
		flag=true;
		textButtonList = new ArrayList<String>();
		replayArList = pl.getArrayList();
		textButtonList.add("PlayLine");
		textButtonList.add("PauseLine");
		
		Icon iconPlay = new ImageIcon(System.getProperty("user.dir") + "\\icons\\play-button.png");
		Icon iconPause = new ImageIcon(System.getProperty("user.dir") + "\\icons\\pause-button.png");
		
		iconButtonList = new ArrayList<Icon>();
		iconButtonList.add(iconPlay);
		iconButtonList.add(iconPause);
	}
	
	private boolean isNumber(String linestr)
	{
		for (char c : linestr.toCharArray())
		{
			if (!Character.isDigit(c))
			{
				return false;
			}
		}
		return true;
	}
	
	private void buttonStates()
	{
		flag=!flag; // changing state to the button 0 is play 1 is pause
	    button.setText(textButtonList.get(flag? 0 : 1));
	    button.setIcon(iconButtonList.get(flag? 0 : 1));
	}
	
	public void actionPerformed(ActionEvent eve) 
	{
		buttonStates();

	    if(!flag)
	    {
	    	if(isNumber(text.getText()) && !text.getText().equals("")) //if input is valid number
	    	{
	    		new Thread(new Runnable() 
	    		{
	    			public void run() 
	    			{	
	    				line = Integer.parseInt(text.getText())-1;
						String[] textArea = ta.getText().split("\n");
						if(line<textArea.length && line>=0) //not out of bounds case
						{
							replayArList.add(textArea[line]);
							ttsf.play(textArea[line], sliderButton.getVolumeSlider(),130,140); //Calling speak() method
						}

						buttonStates();
					    }
	    			}).start();
	    		}else {
	    			buttonStates();
	    		}
	    }else if(flag)
	    {
	    	try {
				ttsf.pause();
				buttonStates();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
}
