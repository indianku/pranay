package util;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
   
	public static void captureScreeenshot(WebDriver driver,String screenshotName) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
	    File source=ts.getScreenshotAs(OutputType.FILE); 
	    
	    Date d=new Date();
	    SimpleDateFormat ac=new SimpleDateFormat("dd-MM-YYYY_HH mm ss");
	    String timestamp=ac.format(d);	
	//   File destination =new File ("F:\\manual 2\\snap"+"-"+screenshotName+"-"+timestamp+".png");
	   File destination =new File ("test-output\\Screenshot\\image"+"-"+screenshotName+"-"+timestamp+".png");
	    FileHandler.copy(source, destination);
	    	
	}
	public static String getexclesheetdata(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String data;
		
		//String path="C:\\Users\\PRANAY\\Desktop\\testng.xlsx";
	String path=".\\src\\test\\resources\\testng.xlsx";
		//String path="orangehrmautomation//src/test//resources//testng.xlsx";
		FileInputStream file=new FileInputStream(path);
	    Workbook book=WorkbookFactory.create(file);
//		Sheet sheet=book.getSheet(sheetName);
//		 Row rows=sheet.getRow(row);
//		Cell  cells=rows.getCell(cell);
	
		 try {
			 data=book.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
			// data=cells.getStringCellValue();
		 }
		catch(IllegalStateException e) {
			 double value=book.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
			 data=String.valueOf(value);
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	}
	

	
	
	
	
	
	
	

