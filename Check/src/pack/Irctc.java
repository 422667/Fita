package pack;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Irctc {

	@Test
	public void check() {
		// TODO Auto-generated method stub

		System.setProperty(
				"webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.findElementByXPath("//*[@id='demon_content']/div[2]/input").click();
		String parent = driver.getWindowHandle();
		driver.findElementByLinkText("Contact Us").click();
		Set<String> hndls = driver.getWindowHandles();
		for (String hndl : hndls) {
			
			if(!hndl.equals(parent))
			{
				driver.switchTo().window(hndl);
				System.out.println("switched to the new window");
				break;
			}
				
		}
		System.out.println(driver.findElementByXPath("/html/body/div[1]/div[2]/p[5]/b").getText());

	}

}
