package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Developersignup {
	
	RemoteWebDriver driver;
	@BeforeTest
	public void brwserlaunch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.get("https://developer.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement  wm = driver.findElementByPartialLinkText("Sign Up ›");
		wm.click();
	}
	
	@Parameters({"firstname","lastname","email"})
	@Test

	public void check(String firstname,String lastname,String email) {
		
		// TODO Auto-generated method stub

		driver.findElementById("first_name").sendKeys(firstname);
		driver.findElementById("last_name").sendKeys(lastname);
		driver.findElementById("email").sendKeys(email);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
