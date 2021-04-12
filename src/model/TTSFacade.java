//https://www.tutorialsfield.com/java-text-to-speech/
package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTSFacade 
{
	private VoiceManager vm;
	private Voice voice;
	
	public TTSFacade(/*TTSFacade kati*/)
	{
		//this.vm=kati;
		voice = VoiceManager.getInstance().getVoice("kevin");//Getting voice
	}
	
	public void play(String str)
	{
		voice.speak(str);//Calling speak() method
	}
	
	public void setVolume(int x)
	{
		voice.setVolume(x);//Setting the volume of the voice
	}
	
	public void setPitch(int x)
	{
		voice.setPitch(x);//Setting the Pitch of the voice
	}
	
	public void setRate(int x)
	{
		voice.setRate(x);//Setting the rate of the voice
	}
}
