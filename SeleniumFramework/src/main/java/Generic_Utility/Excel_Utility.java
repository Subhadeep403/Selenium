package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this method is used for getting data from excel sheet
 * @author subha
 *
 */
public class Excel_Utility {
	public String getExcelData(String sheetName,int row,int cell) throws IOException,EncryptedDocumentException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	/**
	 * getExcelDataFormatter() method use to get any kind of data present in excel sheet
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * @author subhadeep
	 */
	
	public String getExcelDataFormatter(String sheetName,int row,int cell) throws IOException,EncryptedDocumentException {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter format =new DataFormatter();
	 String data = format.formatCellValue(wb.getSheet(sheetName).getRow(row).getCell(cell));
     return data;
	}
	/**
	 * This method is use to fetch multiple data from excel file
	 * @param SheetName
	 * @return
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String SheetName) throws IOException{
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj= new Object[lastRow][lastCell];
		for (int i=0;i<lastRow;i++) {
			for (int j=0;j<lastCell;j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
}
