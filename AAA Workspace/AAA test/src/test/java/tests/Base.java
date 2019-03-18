package tests;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import utilities.ReadExcelFile;

public class Base {
	
	protected WebDriver driver;
	
	public static Boolean pFlag = true;  //use to turn on/off print to screen
	String baseURL = "https://www.aaalife.com/term-life-insurance-quote-input";
	String filename = System.getProperty("user.dir")+"\\datasource\\test.xlsx";
	ReadExcelFile rf;
	
	public Row getCredentials(String tcNo) throws Exception {
		rf = new ReadExcelFile();
		rf.getFileReady(filename);
		return rf.stringRowSearch(tcNo);
	}
	
	public void closeExcel() throws IOException {
		rf.closeExcelDoc();
	}
}
 