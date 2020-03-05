package package1;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingBrokenLinks {
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("C:/Users/Logeshwar/Desktop/brokenlink.html");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement ele:links)
		{
			String link=ele.getAttribute("href");
			
		    URL u=new URL(link);
		 
			HttpsURLConnection conn=(HttpsURLConnection)u.openConnection();
			System.out.println(conn.getURL());
			if(conn.getResponseCode()==200)
			{
				System.out.println(conn.getResponseMessage());
				System.out.println(conn.getResponseCode());
				System.out.println("link is not broken");
			}
			else
			{
				System.out.println(conn.getResponseMessage());
				System.out.println(conn.getResponseCode());
				System.out.println("link is broken");
			}
			
		} 
		driver.close();
	}

}
