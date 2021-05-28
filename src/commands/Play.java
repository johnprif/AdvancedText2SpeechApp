package commands;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import model.*;

public class Play extends JFrame implements ActionListener 
{
	private JTextArea ta;
	private Boolean flag;
	private ArrayList<String> textButtonList;
	private JButton button;
	private ArrayList<Icon> iconButtonList;
	private TTSFacade ttsf;
	private SliderButton sliderButton;
	private ArrayList<String> replayArList = new ArrayList<String>();
	
	public Play()
	{
		
	}
	
	public Play(JTextArea ta, JButton button, SliderButton sliderButton)
	{	
		this.ta = ta;
		this.button = button;
		this.sliderButton = sliderButton;
		
		
		flag=true;
		textButtonList = new ArrayList<String>();
		textButtonList.add("Play");
		textButtonList.add("Pause");
		
		Icon iconPlay = new ImageIcon(System.getProperty("user.dir") + "\\icons\\play-button.png");
		Icon iconPause = new ImageIcon(System.getProperty("user.dir") + "\\icons\\pause-button.png");
		
		iconButtonList = new ArrayList<Icon>();
		iconButtonList.add(iconPlay);
		iconButtonList.add(iconPause);
		
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
	    String allText = ta.getText();
	    ttsf = sliderButton.getTTSF();
	    if(!flag)
	    {
		    new Thread(new Runnable() {
			    public void run() {	
			    	String text = ta.getSelectedText();
			    	if(text != null)
			    	{
			    		replayArList.add(ta.getSelectedText());
			    		ttsf.play(ta.getSelectedText(), sliderButton.getVolumeSlider(), 130, 140);
			    	}else
			    	{
			    		replayArList.add(ta.getText());
			    		ttsf.play(allText, sliderButton.getVolumeSlider(), 130, 140);
			    	} 
			    	buttonStates();
			    }
			}).start();
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
	
	public ArrayList<String> getArrayList()
	{
		return replayArList;
	}
}    
