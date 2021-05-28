package view;

import commands.CommandsFactory;

public class AdvanceText2SpeechApp 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		GUI app = new GUI();
		System.out.println("Welcome to AdvancedText2SpeechApp!");
		CommandsFactory commands = new CommandsFactory(app.getButtonList(), app.getRadioList(), app.getSlider(), app.getFrame(), app.getTextArea(), app.getTextField());
	}
}
