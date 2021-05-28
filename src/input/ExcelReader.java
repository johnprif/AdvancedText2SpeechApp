package input;
import java.io.File;  
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
//Project -> Properties and changing the "text file encoding" to UTF-8
//
//import statements
public class ExcelReader implements DocumentReader
{
	public ExcelReader()
	{
		
	}
	
	public ArrayList<String> read()
	{
		XSSFWorkbook workbook=null;
		FileInputStream file=null;
		XSSFSheet sheet=null;
		ArrayList<String> list=new ArrayList<String>();
		try
	      {
	          file = new FileInputStream(new File("C:\\Users\\johnprif\\Desktop\\example.xlsx"));

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
	                      case NUMERIC: 
	                          //System.out.print(cell.getStringCellValue() + "  ");
	                    	  list.add(cell.getStringCellValue());
	                          break;
	                      case STRING:
	                          //System.out.print(cell.getStringCellValue() + "  ");
	                    	  list.add(cell.getStringCellValue());
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

