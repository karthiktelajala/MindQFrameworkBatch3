package genericActionsLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile 
{
	static String filePath = "./TestData/Credentials.xlsx";
	static String testData;
	public static String readExcel(int sheetNum, int rowNum, int cellNum)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(sheetNum);
			Row row = sheet.getRow(rowNum);
			testData = row.getCell(cellNum).getStringCellValue();
			wb.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while reading Excel: "+e.getMessage());
		}
		return testData;
	}
	
	public static void writeExcel(int sheetNum, int rowNum, int cellNum, String testResult)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(sheetNum);
			Row row = sheet.getRow(rowNum);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\VD57\\Desktop\\ExcelTestData\\Credentials.xlsx");
			Cell cell = row.createCell(cellNum);
			cell.setCellValue(testResult);
			wb.write(fos);
			wb.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while writing Excel: "+e.getMessage());
		}
	}
}
