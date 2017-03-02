package pack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Googlelinks {

	@Test
	public void check1(){
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		List<WebElement> lnks = driver.findElementsByTagName("a");
		System.out.println(lnks.size());
		
		for (WebElement lnk : lnks) {
			System.out.println(lnk.getText());
			
			
		}
		
		
		
	}

}
