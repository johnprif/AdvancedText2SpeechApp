package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextArea;

public class OtherFileWriter implements DocumentWriter
{
	private File f;
	private JTextArea ta;

	public OtherFileWriter(File f, JTextArea ta)
	{
		this.f = f;
		this.ta = ta;
	}
	
	public void write() // just writes text area contents in a file
	{
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			ta.write(fw);
	  	  	PrintWriter pw = new PrintWriter(fw);
	  	  	pw.close();
	  	  	fw.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
