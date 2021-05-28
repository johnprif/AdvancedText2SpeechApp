package output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JTextArea;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter implements DocumentWriter 
{
	private String fileNameWithPath;
	private JTextArea ta;
	
	public ExcelWriter(String fileNameWithPath, JTextArea ta)
	{
		this.fileNameWithPath = fileNameWithPath;
		this.ta = ta;
	}
	
	public void write() // puts content from text area in excel file with the excel file structure
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
  	  	XSSFSheet spreadsheet = workbook.createSheet("mySheet"); 
  	  	XSSFRow row;
  	  	Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
        empinfo.put( "1", new Object[] {ta.getText() }); 
        Set < String > keyid = empinfo.keySet();
        int rowid = 0;
        for (String key : keyid) 
        {
           row = spreadsheet.createRow(rowid++);
           Object[] objectArr = empinfo.get(key);
           int cellid = 0;
           for (Object obj : objectArr)
           {
        	   Cell cell = row.createCell(cellid++);
        	   cell.setCellValue((String)obj);
           }
        }
        FileOutputStream out;
		try {
			out = new FileOutputStream(new File(fileNameWithPath));
			workbook.write(out);
	        out.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
        
	}
}
