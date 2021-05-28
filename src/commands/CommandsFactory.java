//https://stackoverflow.com/questions/21090812/get-buttons-already-added-in-a-jframe
package commands;

import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import model.*;
public class CommandsFactory
{
	private ArrayList<JButton> buttonList;
	private ArrayList<JRadioButton> radioList;
	private JTextArea ta;
	private TextField text;
	private JFrame fr;
	private OpenDocument openobj;
	private JSlider slider;
	private SliderButton sliderButton;
	private TTSFacade ttsf;
	private ArrayList<String> replayArList;
	
	public CommandsFactory(ArrayList<JButton> buttonList, ArrayList<JRadioButton> radioList, JSlider slider, JFrame fr, JTextArea ta, TextField text)
	{
		this.fr = fr;
		this.ta = ta;
		this.text = text;
		this.buttonList = buttonList;
		this.radioList = radioList;
		this.slider = slider;
		createCommand();
	}
	
	private void createCommand()
	{
		openobj = new OpenDocument(fr,ta);
		buttonList.get(0).addActionListener(openobj);
		
		Save saveobj1 = new Save(fr,ta);
		buttonList.get(1).addActionListener(saveobj1);
		
		ClearDocument clear = new ClearDocument(ta);
		buttonList.get(2).addActionListener(clear);
		
		sliderButton = new SliderButton();
		slider.addChangeListener(sliderButton);
		
		Play play = new Play(ta, buttonList.get(3),sliderButton);
		buttonList.get(3).addActionListener(play);
		
		PlayLine playLine = new PlayLine(ta, text, buttonList.get(5), sliderButton, play);
		buttonList.get(5).addActionListener(playLine);
		
		replayArList = play.getArrayList();
		
		Replay rep = new Replay(sliderButton,buttonList.get(4), replayArList);
		buttonList.get(4).addActionListener(rep);
		
		LockDocument lock = new LockDocument(ta, buttonList.get(6));
		buttonList.get(6).addActionListener(lock);
		
		ATBASH atBash = new ATBASH(openobj.getTextArea());
		radioList.get(0).addItemListener(atBash);
		
		ROT13 rot = new ROT13(openobj.getTextArea());
		radioList.get(1).addItemListener(rot);
	}
}
