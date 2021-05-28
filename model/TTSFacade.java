package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTSFacade// implements Runnable
{
	private Voice voice;
	private VoiceManager freeVM;
	
	public TTSFacade()
	{
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		freeVM = VoiceManager.getInstance();
		Voice[] voices = freeVM.getVoices(); //get all the available voices from the voice manager
		voice = voices[1]; //chose this one because we liked it better
		voice.allocate();
	}
	
	public void play(String str, float vol, int pitch, int rate)
	{
		voice.allocate();
		voice.setVolume(vol);
		voice.setPitch(pitch);
		voice.setRate(rate);
		voice.speak(str);
	}
	
	public void pause() throws InterruptedException
	{
		voice.deallocate();
	}
	
	public Voice getVol() 
	{
		return voice;
	}
}
