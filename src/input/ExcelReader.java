package input;
import java.io.File;  
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class ExcelReader implements DocumentReader
{
	private String fileNameWithPath; 
	public ExcelReader(String fileNameWithPath)
	{
		this.fileNameWithPath=fileNameWithPath;
	}
	
	public ArrayList<String> read() // reads an excel file and  and puts its content in an ArrayList
	{
		XSSFWorkbook workbook=null;
		FileInputStream file=null;
		XSSFSheet sheet=null;
		ArrayList<String> list=new ArrayList<String>();
		try
	      {
			  String temp;
	          file = new FileInputStream(new File(fileNameWithPath));
	          //Create Workbook instance holding reference to .xlsx file
	          workbook = new XSSFWorkbook(file);
	          //Get first/desired sheet from the workbook
	          sheet = workbook.getSheetAt(0);

	          //Iterate through each rows one by one
	          Iterator<Row> rowIterator = sheet.iterator();
	          while (rowIterator.hasNext()) 
	          {	   
	              Row row = rowIterator.next();
	              //For each row, iterate through all the columns
	              Iterator<Cell> cellIterator = row.cellIterator();
	              while (cellIterator.hasNext()) 
	              {
	                  Cell cell =(Cell) cellIterator.next();
	                  //Check the cell type and format accordingly
	                  switch (cell.getCellType()) 
	                  {
	                  	case STRING:
	                  		list.add(cell.getStringCellValue()+"\n");
	                  		break;
	                    case NUMERIC:  
	                    	temp=""+cell.getNumericCellValue();
	                    	list.add(temp+"\n");
	                        break;	                      
	                  }
	              }
	              System.out.println("");
	          }
	      } 
	      catch (Exception e) 
	      {
	          e.printStackTrace();
	      }finally 
	      {
				try 
				{
					if (workbook != null) 
					{
						workbook.close();
					}
					if (file != null) 
					{
						file.close();
					}
				} catch (Exception ex) 
				{
				}
	      }
		return list;
	}
}

