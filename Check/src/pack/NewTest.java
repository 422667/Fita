package pack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void pulsar() {
	  
	  System.out.println("pulsar is at outside");
  }
  @Test(priority=-1)
  public void suzuki() {
	  
	  System.out.println("suzuki is at outside");
  }
  
  @Test(priority=2)
  public void bajaz() {
	  
	  System.out.println("bajaz is at outside");
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("ignition on");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("ignition off");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Open the parking gate");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("close the parking gate");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Open the main gate");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("close the main gate");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("moving 2 wards parking building");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Moving 2 wards home");
  }

}
