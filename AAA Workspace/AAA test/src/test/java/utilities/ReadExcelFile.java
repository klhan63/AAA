package utilities;
 
/* Notes:   HSSF is the POI Project's pure Java implementation of the Excel '97(-2007) file format.
 *          XSSF is the POI Project's pure Java implementation of the Excel 2007 OOXML (.xlsx) file format.
 *      *** IMPORTANT - POI-Cannot use a BufferReader on these Excel files, must be IO Stream instead. 
 */
 
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
 
public class ReadExcelFile {
 
    private File file;
    private FileInputStream fIP;
    //private BufferedReader reader; DOESN'T WORK WITH POI
 
    private XSSFWorkbook wb;
    private XSSFSheet sheet;
    Row row;
    Cell cell;
     
    public ReadExcelFile() {
        super();
    }
 
    public void openFile(String filename) throws IOException {
        file = new File(filename); 
        fIP = new FileInputStream(file);
    }
     
    public void openExistingWB() throws IOException {
        wb = new XSSFWorkbook(fIP);
    }
     
    public void setupSheet(int shtName) {
        sheet = wb.getSheetAt(shtName);
    }
     
    public Row stringRowSearch(String qual) throws IOException {
        Iterator<Row> rowIterator = sheet.iterator();  //Iterate through each row
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if(row.getCell(0).toString().equals(qual)) 
                return row;
        }
        return null;
    }
     
//    public Row integerRowSearch(String qual) throws IOException { //NOT USED YET
//        Iterator<Row> rowIterator = sheet.iterator();  //Iterate through each row
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            Iterator<Cell> cellIterator = row.cellIterator();  //each row, iterate through the columns until found
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                if (cell.getStringCellValue().equals(qual)) return row;
//            }
//        }
//        return null;
//    }
 
    public void getFileReady(String filename) throws Exception {
        openFile(filename);
        openExistingWB();
        setupSheet(0);
    }
     
    public void closeExcelDoc() throws IOException {
        fIP.close();
    }   
}