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
           //   if(f.getName().contains("docx")) //for the newest MS word files (not .doc)
           //   {
//            	  XWPFDocument document = new XWPFDocument();
//            	  FileOutputStream out = new FileOutputStream(new File
//            		         (f.getAbsolutePath()));
//
//                  XWPFParagraph paragraph = document.createParagraph();
//                  XWPFRun run = paragraph.createRun();
//                  run.setText(ta.getText());
//                  document.write(out);
//                  out.close();
           //   }else if(f.getName().contains("xlsx")) //for the newest excel files (not .xls)
           //   {
//            	  XSSFWorkbook workbook = new XSSFWorkbook();
//            	  XSSFSheet spreadsheet = workbook.createSheet("mySheet"); 
//            	  XSSFRow row;
//            	  Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
//                  empinfo.put( "1", new Object[] {ta.getText() }); 
//                  Set < String > keyid = empinfo.keySet();
//                  int rowid = 0;
//                  for (String key : keyid) {
//                     row = spreadsheet.createRow(rowid++);
//                     Object[] objectArr = empinfo.get(key);
//                     int cellid = 0;
//                     for (Object obj : objectArr){
//                        Cell cell = row.createCell(cellid++);
//                        cell.setCellValue((String)obj);
//                     }
//                  }
//                  FileOutputStream out = new FileOutputStream(
//                	         new File(f.getAbsolutePath()));
//                  workbook.write(out);
//                  out.close();
             // }else //for other file types including .doc and .xls
             // {
//            	  System.out.println("HERE");
//            	  FileWriter fw = new FileWriter(f);
//            	  ta.write(fw);
//            	  PrintWriter pw = new PrintWriter(fw);
//            	  pw.close();
//            	  fw.close();
            //  };
          }
        }
	}

