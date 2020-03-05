package Assignment;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLinkCheck {
public static void main(String[] args){
		
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("java"+Keys.ENTER);
		boolean flag=false;
		int totalLinks=0;
		int fineLinks=0;
		int brokenLinks=0;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement ele:links)
		{
			try
			{
				ele.getAttribute("href");
				flag=true;
					
			}
			catch(Exception e){
				System.out.println("not a link");
			}
           
			if(flag)
			{
				try {
				totalLinks++;
				String link=ele.getAttribute("href");
			
		         URL u=new URL(link);
		 
			HttpsURLConnection conn=(HttpsURLConnection)u.openConnection();
			System.out.println(conn.getURL());
			if(conn.getResponseCode()==200)
			{
				fineLinks++;
				System.out.println(conn.getResponseMessage());
				System.out.println(conn.getResponseCode());
				System.out.println("link is not broken");
			}
			else
			{
				brokenLinks++;
				System.out.println(conn.getResponseMessage());
				System.out.println(conn.getResponseCode());
				System.out.println("link is broken");
			}
			
		}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		}
		
		System.out.println("Total links "+totalLinks);
		System.out.println("finelinks "+fineLinks);
		System.out.println("Broken links "+brokenLinks);
		driver.close();
}
}