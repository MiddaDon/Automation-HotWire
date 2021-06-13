package Automate_Hotwire.Automate_Hotwire;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {

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
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before the class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before every method");
	}
	
	@Test(priority=2)
	public void test1() {
		System.out.println("Testing 1");
	}
	@Test(priority=3)
	public void test2() {
		System.out.println("Test 2");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After every method");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("After the class");
	}

	
	@Test(priority=4)
	public void test3() {
		driver.quit();
	}
	
	
	
	
	
	
}
