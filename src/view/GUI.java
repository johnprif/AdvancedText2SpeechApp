package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import commands.CommandsFactory;

public class GUI 
{
	private ArrayList<JButton> buttonList;
	private ArrayList<JRadioButton> radioList;
	private JFrame frame;
	private JPanel upperPanel;
	private JTextArea textArea;
	private JPanel lowerPanel;
	private JPanel rightPanel;
	private JSlider slider;
	private TextField textField;
	
	public GUI()
	{
		buttonList = new ArrayList<JButton>();
		radioList = new ArrayList<JRadioButton>();
		createFrame();
		createUpperPanel();
		createTextArea();
		createLowerPanel();
		createRightPanel();
		createSlider();
		addLabelComponents();
	}
	
	private void createFrame()
	{
		frame = new JFrame("TextToSpeechAudio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createUpperPanel()
	{      
        upperPanel = new JPanel();
            
        Icon iconOpen = new ImageIcon(System.getProperty("user.dir") + "\\icons\\open-file-button.png");
        JButton open = new JButton("Open",iconOpen);
        upperPanel.add(open);
        buttonList.add(open);
        
        Icon iconSave = new ImageIcon(System.getProperty("user.dir") + "\\icons\\floppy-disk.png");
        JButton save = new JButton("Save", iconSave);
        upperPanel.add(save);
        buttonList.add(save);
        
        JButton clear = new JButton("Clear");
        upperPanel.add(clear);
        buttonList.add(clear);
              
        Border border = BorderFactory.createTitledBorder("ENTER TEXT IN THE WHITE SPACE BELLOW");
        upperPanel.setBorder(border);
	}
	
	private void createTextArea()
	{
		textArea = new JTextArea(100,100);
		textArea.setEditable(true); // in order to get access in text area
	}
	
	private void createLowerPanel()
	{
		// Creating icons for the buttons
		Icon iconPlay = new ImageIcon(System.getProperty("user.dir") + "\\icons\\play-button.png");
        Icon iconReplay = new ImageIcon(System.getProperty("user.dir") + "\\icons\\replay.png");
        
        //Creating the panel at bottom and adding components
        lowerPanel = new JPanel(); // the panel is not visible in output
        //Creating buttons
        JButton play = new JButton("Play",iconPlay);
        lowerPanel.add(play);
        buttonList.add(play);
        
        JButton replay = new JButton("Replay",iconReplay);
        lowerPanel.add(replay);
        buttonList.add(replay);
        
        JButton playLine = new JButton("PlayLine:", iconPlay);
        lowerPanel.add(playLine);
        buttonList.add(playLine);
        // Creating TextFiles for the play line button
        textField = new TextField(5);
        lowerPanel.add(textField);
	}
	
	private void createRightPanel()
	{
		Icon iconLock = new ImageIcon(System.getProperty("user.dir") + "\\icons\\lock.png");
        
        rightPanel = new JPanel();
        ButtonGroup G = new ButtonGroup();
        
        //Creating radio buttons for the decoding buttons
        JRadioButton atBash = new JRadioButton("At_Bash");
        G.add(atBash);
        rightPanel.add(atBash);
        radioList.add(atBash);
        
        JRadioButton rot13 = new JRadioButton("Rot_13"); 
        G.add(rot13);
        rightPanel.add(rot13);
        radioList.add(rot13);
        
        JRadioButton none = new JRadioButton("None");
        G.add(none);
        none.setSelected(true);
        rightPanel.add(none);
        radioList.add(none);
        
        JButton lock = new JButton("Lock",iconLock);              
        rightPanel.add(lock);
        buttonList.add(lock);
        
        rightPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.setPreferredSize(new Dimension(100, 500));
        rightPanel.setMaximumSize(new Dimension(100, 500));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Settings"));
	}
	
	private void createSlider()
	{
		 slider = new JSlider();
		 slider.setMinorTickSpacing(10);
		 slider.setPaintTicks(true);
		 // Set the labels to be painted on the slider
		 slider.setPaintLabels(true);
		 // Add positions label in the slider
	     Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
	     position.put(0, new JLabel("0"));
	     position.put(50, new JLabel("50"));
	     position.put(100, new JLabel("100"));
	     slider.setValue(0);
	     //slider.setMinimum(0);
	     //slider.setMaximum(100);
	     // Set the label to be drawn
	     slider.setLabelTable(position);
	     // Add the slider to the panel
	     lowerPanel.add(slider);
	}
	
	private void addLabelComponents()
	{
		// Adding contents in frame
		frame.getContentPane().add(BorderLayout.SOUTH, lowerPanel);
        frame.getContentPane().add(BorderLayout.NORTH, upperPanel);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.getContentPane().add(BorderLayout.EAST, rightPanel);
        frame.setSize(900,600);
        frame.setVisible(true);
	}
	
	public ArrayList<JButton> getButtonList()
	{
		return buttonList;
	}
	
	public ArrayList<JRadioButton> getRadioList()
	{
		return radioList;
	}
	
	public JSlider getSlider()
	{
		return slider;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	public JTextArea getTextArea()
	{
		return textArea;
	}
	
	public TextField getTextField()
	{
		return textField;
	}
}
