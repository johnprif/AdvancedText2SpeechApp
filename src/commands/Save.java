package commands;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import output.DocumentWriterFactory;
public class Save implements ActionListener
{
	private JFrame fr;
	private JTextArea ta;
	private DocumentWriterFactory documentWriterFactory;
	
	public Save(JFrame frame, JTextArea ta)
	{
		this.fr = frame;
		this.ta = ta;
	}

	public void actionPerformed(ActionEvent eve)
	{
		  JFileChooser fc = new JFileChooser();
          fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
          int rsp = fc.showSaveDialog(fr);
          if( rsp == JFileChooser.APPROVE_OPTION )
          {
            File f = fc.getSelectedFile(); 
              f.setReadable(true);
              
              documentWriterFactory = new DocumentWriterFactory(f, ta);
              try {
				documentWriterFactory.newSave();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
      }
}

