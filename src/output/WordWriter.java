package output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTextArea;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWriter implements DocumentWriter 
{
	private String fileNameWithPath;
	private JTextArea ta;
	
	public WordWriter(String fileNameWithPath, JTextArea ta)
	{
		this.fileNameWithPath =fileNameWithPath;
		this.ta =ta;
	}
	
	public void write() // puts content from text area in excel file with the doc file structure
	{
		XWPFDocument document = new XWPFDocument();
  	  	FileOutputStream out;
		try {
			out = new FileOutputStream(new File(fileNameWithPath)); // saves the file in the path the user chooses
			XWPFParagraph paragraph = document.createParagraph();
	        XWPFRun run = paragraph.createRun();
	        run.setText(ta.getText());
	        document.write(out);
	        out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
