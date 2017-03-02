package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Developersignup2 {
	
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
	
	
	@Test(dataProvider="dp")

	public void check(String firstname,String lastname, String email) {
		
		// TODO Auto-generated method stub

		driver.findElementById("first_name").clear();
		driver.findElementById("first_name").sendKeys(firstname);
		
		driver.findElementById("last_name").clear();
		driver.findElementById("last_name").sendKeys(lastname);
		
		driver.findElementById("email").clear();
		driver.findElementById("email").sendKeys(email);
		
		
	}
	
	@DataProvider(name="dp")
	public Object[][] dp()
	{
		Object[][] data = new Object[3][3];
		data[0][0]="Dinesh";
		data[0][1]="Reddy";
		data[0][2]="j.dinesh@gmail.com";
		data[1][0]="Ramesh";
		data[1][1]="Reddy";
		data[1][2]="j.dinesh@gmail.com";
		data[2][0]="Ganesh";
		data[2][1]="Reddy";
		data[2][2]="j.dinesh@gmail.com";
		return data;
		
	}
	
	
	
	
	
	
	
	
	

}
