package Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class UrbanLadderLinkChek {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
	System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.urbanladder.com");
    WebElement popup = driver.findElement(By.xpath("//a[contains(text(),'Close')]"));
	 Thread.sleep(10000);
	 popup.click();
	
    Actions act=new Actions(driver);
	
	
    List<WebElement> modules = driver.findElements(By.xpath("//div[@id='topnav_wrapper']//li/span"));
	
    File file=new File("./data.xlsx");
	  FileInputStream fis=new FileInputStream(file);
	  Workbook wb = WorkbookFactory.create(fis);
	
	 
	
	for(int i=0;i<modules.size();i++)
	{
		String text = modules.get(i).getText();
		System.out.println("Module :"+text);
		WebElement module = modules.get(i);
		Thread.sleep(7000);
		act.moveToElement(module).perform();
		
		Thread.sleep(5000);
		List<WebElement> innerlinks = module.findElements(By.xpath("//span[contains(text(),'"+text+"')]/..//ul[contains(@class,'inline-list left')]//a"));
		String jscode="arguments[0].scrollIntoView";
		Thread.sleep(5000);
		
	   for(int j=0;j<innerlinks.size();j++)
		{
		     WebElement innerLink = innerlinks.get(j);
			  JavascriptExecutor je=(JavascriptExecutor)driver;
			  je.executeScript(jscode, innerLink);
		  String text3 = innerlinks.get(j).getText();
		  System.out.println(text3);
		  Row rw = wb.getSheet("Sheet2").createRow(j);
		  Cell cl=rw.createCell(i);
		  cl.setCellValue(text3);
		  FileOutputStream fos=new FileOutputStream(file);
		  wb.write(fos);
		  
		}
	   System.out.println("---------------------------------------------");
	
	
}
	wb.close();
}
}