package Automate_Hotwire.Automate_Hotwire;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	
	
	
	
String Cars= "//button[text()='Car' and @class='hw-btn hw-btn-check']";
//String fligt= "//button[text()='Flight' and @class='hw-btn hw-btn-check']";
	
public String selectDate(int i) {
	SimpleDateFormat spf=new SimpleDateFormat("MM/dd/yyyy"); 
	Date cDate=new Date();
	Calendar c= Calendar.getInstance(); 

	c.setTime(cDate);

	c.add(Calendar.DAY_OF_YEAR,i);
	cDate=c.getTime();
	String strDate=spf.format(cDate);

	
return strDate;		
}





	WebDriver driver;
	
	
	
	@BeforeTest
	public void launchBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Chrome\\chromedriver.exe");
		driver=new ChromeDriver();
		
		
	}
	
	
	
	@Test(priority=1)
	public void launchWebSite()
	{
		driver.get("http://www.hotwire.com/");
	}
	
	@Test(priority=2)
	public void clickVacations() throws InterruptedException {
		driver.findElement(By.xpath("(//a[text()='Vacations'])[1]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void selectOptions()
	{
		if(driver.findElement(By.xpath(Cars)).isEnabled())
		{
			driver.findElement(By.xpath(Cars)).click();
		}
	}
	
	
	@Test(priority=4)
	public void selectFrom() throws InterruptedException {
		
//		driver.findElement(By.xpath("//div/div[text()='Bundles']")).click();
		
		driver.findElement(By.xpath("//label[text()='Fly from']/following-sibling::div/input[@id='farefinder-package-origin-location-input']")).sendKeys("SFO");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a/strong[text()='SFO']/..")).click();
			}
	
	@Test(priority=5)
	public void selectTo() throws InterruptedException {
		
//		driver.findElement(By.xpath("//div/div[text()='Bundles']")).click();
		
		driver.findElement(By.xpath("//label[text()='Fly to']/following-sibling::div/input[@id='farefinder-package-destination-location-input']")).sendKeys("LAX");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a/strong[text()='LAX']/..")).click();
			}	
	
	
	
	@Test(priority=6)
	public void selectDate()
	{
		driver.findElement(By.xpath("//label[text()='Departing']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[text()='Departing']/following-sibling::input")).sendKeys(selectDate(1));
		driver.findElement(By.xpath("//label[text()='Returning']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[text()='Returning']/following-sibling::input")).sendKeys(selectDate(22));
	    
		}
	
	@Test(priority=7)
	public void selectZone()
	{
		
		Select zone=new Select(driver.findElement(By.id("farefinder-package-pickuptime-input")));
		zone.selectByVisibleText("Evening");
	
		Select zone1=new Select(driver.findElement(By.id("farefinder-package-dropofftime-input")));
		zone1.selectByVisibleText("Morning");
		
	}
	
	@Test(priority=8)
	public void findingDeal()
	{
		
		driver.findElement(By.xpath("//button[text()='Find a deal']")).click();	
	}
	
	
	@Test(priority=9)
	public void end()
	{
		
		driver.quit();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
