package input;

import java.util.ArrayList;

public class DocumentReaderFactory
{
	private ReaderAtbashDecorator readerAtbashDecorator;
	private ReaderRot13Decorator readerRot13Decorator;
	private WordReader wordDoc;
	private ExcelReader excelDoc;
	private String decodingMethod;
	public ArrayList<String> temp;
	
	public DocumentReaderFactory(String type, String ifDecoded, String fileNameWithPath)
	{
		if(type.equals("xlx"))
		{
			excelDoc = new ExcelReader(fileNameWithPath);
			if(ifDecoded.equals("Atbash"))
			{
				readerAtbashDecorator = new ReaderAtbashDecorator(excelDoc.read());
			}else if(ifDecoded.equals("Rot13"))
			{
				readerRot13Decorator = new ReaderRot13Decorator(excelDoc.read());
			}else
			{
				temp = excelDoc.read();
			}
		}else if(type.equals("docx"))
		{
			wordDoc = new WordReader(fileNameWithPath);
			if(ifDecoded.equals("Atbash"))
			{
				readerAtbashDecorator = new ReaderAtbashDecorator(wordDoc.read());
			}else if(ifDecoded.equals("Rot13"))
			{
				readerRot13Decorator = new ReaderRot13Decorator(wordDoc.read());
			}else
			{
				temp = wordDoc.read();
			}
		}else
		{
			System.exit(-1);
		}
	}
	
	public ArrayList<String> getList()
	{
		return temp;
	}
	
//	public DocumentReader createReader(String a, String b, String c)
//	{
//		return null;
//	}
}
