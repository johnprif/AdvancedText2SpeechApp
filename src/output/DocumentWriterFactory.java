package output;

import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

public class DocumentWriterFactory 
{
	private File f;
	private JTextArea ta;
	
	public DocumentWriterFactory(File f,JTextArea ta)
	{
		this.f = f;
		this.ta = ta;
	}
	
	public void newSave() throws IOException // saves content in proper file type
	{
		if(f.getName().contains("docx"))
		{
			WordWriter wordWriter = new WordWriter(f.getAbsolutePath(), ta);
			wordWriter.write();
		}else if(f.getName().contains("xlsx"))
		{
			ExcelWriter excelWriter = new ExcelWriter(f.getAbsolutePath(), ta);
			excelWriter.write();
		}else // any other file type
		{
			OtherFileWriter otherFileWriter = new OtherFileWriter(f, ta);
			otherFileWriter.write();
		}
	}	
}
