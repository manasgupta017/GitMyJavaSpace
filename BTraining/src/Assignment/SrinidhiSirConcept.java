package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SrinidhiSirConcept {
public static void main(String[] args) throws InterruptedException {
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
	
	for(int i=0;i<modules.size();i++)
	{
		String text = modules.get(i).getText();
		System.out.println("Module :"+text);
		WebElement module = modules.get(i);
		Thread.sleep(7000);
		act.moveToElement(module).perform();
		
		Thread.sleep(5000);
		List<WebElement> subModules = module.findElements(By.xpath("//span[contains(text(),'"+text+"')]/parent::li//div[@class='taxontype']//a"));
		//List<WebElement> innerlinks = module.findElements(By.xpath("//span[contains(text(),'"+text+"')]/..//ul[contains(@class,'inline-list left')]//a"));
		
		String jscode="arguments[0].scrollIntoView";
	   for(int j=0;j<subModules.size();j++)
		{
		   String text1 = subModules.get(j).getText();
		  System.out.println(text1);
		  WebElement submodule = subModules.get(j);
		  Thread.sleep(5000);
		  List<WebElement> innerLinks = submodule.findElements(By.xpath("//a[text()='"+text1+"']/../following-sibling::ul[@class='taxonslist']//a")); 
		  for(int k=0;k<innerLinks.size();k++)
			{
			  WebElement innerLink = innerLinks.get(k);
			  JavascriptExecutor je=(JavascriptExecutor)driver;
			  je.executeScript(jscode, innerLink);
			  String text2 = innerLink.getText();
			  System.out.println(text2);
			}
		  
		}
	   System.out.println("---------------------------------------------");
	   
}
}
}
