package pack;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


@Listeners({ATUReportsListener.class,ConfigurationListener.class, MethodListener.class})
public class Wrappers {
	static{
		System.setProperty("atu.reporter.config", "C:\\Users\\Dinesh\\git\\Training\\atu.properties");}

	RemoteWebDriver driver ; 
	int i=1;
		
		public void launchbrowser(String brwsr , String URL)
		
		{
			if(brwsr.equalsIgnoreCase("chrome"))
					{
				System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver.exe");
				driver = new ChromeDriver();
				ATUReports.setWebDriver(driver);
				ATUReports.indexPageDescription = "FreeWheel MRM Project";
				ATUReports.setAuthorInfo("Dinesh",  Utils.getCurrentTime(), "1.0");
				ATUReports.add("Chrome Driver is instantiated",LogAs.PASSED ,new CaptureScreen(ScreenshotOf.DESKTOP));
					
		             }
		
			else if (brwsr.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver","C:\\Program Files\\Selenium\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				ATUReports.setWebDriver(driver);
				ATUReports.indexPageDescription = "FreeWheel MRM Project";
				ATUReports.setAuthorInfo("Dinesh",  Utils.getCurrentTime(), "1.0");
				ATUReports.add("InternetExplorer is instantiated",LogAs.PASSED ,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			else 
				
			{
				driver = new FirefoxDriver();
				ATUReports.setWebDriver(driver);
				ATUReports.indexPageDescription = "FreeWheel MRM Project";
				ATUReports.setAuthorInfo("Dinesh",  Utils.getCurrentTime(), "1.0");
				ATUReports.add("Firefox Driver is instantiated",LogAs.PASSED ,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(URL);
			ATUReports.add("Browser launched and URL got triggered ",LogAs.PASSED ,new CaptureScreen(ScreenshotOf.DESKTOP));
	}
		
	
		public void enterbyxpath(String xpt,String data)
		
		{
			try {
				driver.findElementByXPath(xpt).clear();
				driver.findElementByXPath(xpt).sendKeys(data);
				ATUReports.add("Data Entered as "+data,LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			
			} catch (NoSuchElementException e) {
				
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		      catch (WebDriverException e)
			{
			ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			finally
			{
				takeSnap();
			}
		}
		
		
		public void clickbyxpath(String xpt1)
		{
		 
	
	try {
		driver.findElementByXPath(xpt1).click();
		ATUReports.add("Network link got clicked ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
	} catch (NoSuchElementException e) {
		
	ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}
      catch (WebDriverException e)
	{
	ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
	}
	finally
	{
		takeSnap();
	}
	}
		
		
		
		

		
		
		public void clickbylinktext(String xpth , String lnk ) throws InterruptedException
		
		{
			

			try {
				Actions Builder = new Actions(driver);
			
				Builder.moveToElement(driver.findElementByXPath(xpth)).build().perform();
		
				Thread.sleep(5000);
				ATUReports.add("Mouse moved over to the Manage ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
				driver.findElementByLinkText(lnk).click();
				ATUReports.add("User clicked the "+lnk+ "link",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {
				
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		      catch (WebDriverException e)
			{
			ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			finally
			{
				takeSnap();
			}
		}
		
		
		public void clickBylinktext(String lnk)
		{
			
			try {
				driver.findElementByLinkText(lnk).click();
				ATUReports.add("User clicked the "+lnk+ "link",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {
				
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		      catch (WebDriverException e)
			{
			ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			finally
			{
				takeSnap();
			}
			
		}
		
		
		public void sendtextbyid(String id , String txt)
		{
			try {
				driver.findElementById(id).clear();
				driver.findElementById(id).sendKeys(txt);
				ATUReports.add(" User Entered the text as "+txt,LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {
				
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		      catch (WebDriverException e)
			{
			ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			finally
			{
				takeSnap();
			}
		}
		
		
		public void selectbyvalue(String idvalue ,String indx) throws InterruptedException
		{
			try {
				Select dropdown = new Select(driver.findElementById(idvalue));
				ATUReports.add(" List Values are loaded in to Dropdown ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
				Thread.sleep(5000);
				dropdown.selectByVisibleText(indx);
				ATUReports.add(" user selected the Rating ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {
				
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		      catch (WebDriverException e)
			{
			ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			finally
			{
				takeSnap();
			}
		}
		
		public void selectbyValue(String xp ,String indx) throws InterruptedException
		{
			try {
				Select dropdown = new Select(driver.findElementByXPath(xp));
				ATUReports.add(" List Values are loaded in to Dropdown ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
				Thread.sleep(5000);
				dropdown.selectByVisibleText(indx);
				ATUReports.add(" user selected the Rating ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {
				
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		      catch (WebDriverException e)
			{
			ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			finally
			{
				takeSnap();
			}
		}
		
		
		
		
		
		public void clickbyclassname(String name) 
		
		{ 
			try {
				driver.findElementByClassName(name).click();
				ATUReports.add("User clicked the Submit Button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {
				
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		      catch (WebDriverException e)
			{
			ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			finally
			{
				takeSnap();
			}
		}
		
public void clickbyid(String id) 
		
		{ 
			try {
				driver.findElementById(id).click();
				ATUReports.add("User clicked the Submit Button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {
				
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		      catch (WebDriverException e)
			{
			ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			finally
			{
				takeSnap();
			}
		}
		
		
		public void close()
		
		{
			driver.close();
			ATUReports.add("Browser got closed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
		}

		public void takeSnap(){
		
			   try {
					File src = driver.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(src, new File("C:\\project1"+"\\O_"+i+".png"));
				} catch (IOException e) {
					System.out.println("Snapshot could not be taken");
				}
				i++;
			
		   }
		
		public static String[][] getSheet(String fileName,String sheetname) throws IOException{
			
			String[][] data = null;
			
			try {
				FileInputStream fis = new FileInputStream(new File("D:\\Input\\"+fileName+".xlsx"));
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheet(sheetname);	
				
				// get the number of rows
				int rowCount = sheet.getLastRowNum();
				
				// get the number of columns
				int columnCount = sheet.getRow(0).getLastCellNum();
				data = new String[rowCount][columnCount];

				// loop through the rows
				for(int i=1; i <rowCount+1; i++){
					try {
						XSSFRow row = sheet.getRow(i);
						for(int j=0; j <columnCount; j++){ // loop through the columns
							try {
								String cellValue = "";
								try{
									if(cellValue!=null){
									cellValue = row.getCell(j).getStringCellValue();
									}
								}catch(NullPointerException e){
									
								}
								
								data[i-1][j]  = cellValue; // add to the data array
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}				
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				fis.close();
				workbook.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return data;
		
		}


		public void scrolldown(String id) {
			try {
				int y = driver.findElementById(id).getLocation().getY();
				((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+y+");");
				
				ATUReports.add("User scroll down the page ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		catch (NoSuchElementException e) {
			
		ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	      catch (WebDriverException e)
		{
		ATUReports.add("No driver found ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
		}
		finally
		{
			takeSnap();
		}
			
		}
		
		
		
		
		
		
		
		
		
		
		

}
