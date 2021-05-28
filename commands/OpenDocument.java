package commands;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import model.Document;

public class OpenDocument extends JFrame implements ActionListener
{
	private Document doc;
	private JFrame fr;
	private JTextArea ta;
	private ArrayList<String> content;
	private String fileNameWithPath;
	
	public OpenDocument(JFrame fr,JTextArea ta)
	{
		this.fr = fr;
		this.ta=ta;
		doc = new Document();
	}
	
	public void setDocument(Document doc)
	{
		this.doc = doc;
	}

	public JTextArea getTextArea()
	{
		return ta;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		final JLabel label_open = new JLabel();
		JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(fr);
        if(option == JFileChooser.APPROVE_OPTION)
        {
           File file = fileChooser.getSelectedFile();
           fileNameWithPath = file.getPath();
           label_open.setText("File Selected: " + file.getName());           
           doc.setFileNameWithPath(fileNameWithPath);
           doc.open(file.getName());
           content=doc.getContent();
           ta.setText("");
           for(String str: content) {
        	   ta.append(str);
           } 
        }
	}
}
