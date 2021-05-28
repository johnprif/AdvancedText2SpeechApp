package commands;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.TTSFacade;

public class SliderButton implements ChangeListener
{
	private TTSFacade ttsf;
	private float volumeSlider;
	
	public SliderButton() 
	{
		ttsf = new TTSFacade();
	}
	
	@Override
	public void stateChanged(ChangeEvent e) 
	{
		 new Thread(new Runnable() 
		 {
			    public void run() 
			    {
			    	JSlider source = (JSlider)e.getSource();
			        if (!source.getValueIsAdjusting()) 
			        {
			            volumeSlider = (float)source.getValue()/100; // gets volume value from the slider
			        }
			    }
		}).start();         
    }
	
	public float getVolumeSlider()
	{
		return volumeSlider;
	}
	
	public TTSFacade getTTSF()
	{
		return ttsf;
	}

	public void setTTSF(TTSFacade ttsf)
	{
		this.ttsf = ttsf;
		ttsf.getVol().setVolume(50);
	}
}
