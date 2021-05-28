package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.TTSFacade;

public class Replay  extends JFrame implements ActionListener {

	private TTSFacade ttsf;
	private SliderButton sliderButton;
	private ArrayList<String> arrlist;
	
	public Replay(SliderButton sliderButton, JButton button, ArrayList<String> arrlist)
	{
		ttsf = new TTSFacade();
		this.sliderButton = sliderButton;
		this.arrlist = arrlist;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(String str: arrlist)
		{
			System.out.println(str);
			ttsf.play(str, sliderButton.getVolumeSlider(), 130, 140);
		}
	}
}
