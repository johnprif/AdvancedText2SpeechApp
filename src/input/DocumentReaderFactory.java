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
	
	
	public DocumentReaderFactory(DocumentReader lol)
	{
//		wordDoc = new WordReader();
//		excelDoc = new ExcelReader();
		readerAtbashDecorator = new ReaderAtbashDecorator(lol.read());
		readerRot13Decorator = new ReaderRot13Decorator(lol.read());
	}
	
	//default
	public DocumentReader createReader(String a, String b, String c)
	{
		return null;
	}
}
