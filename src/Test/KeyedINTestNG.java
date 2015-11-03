package Test;

import org.testng.SkipException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class KeyedINTestNG 
{
  public static WebDriver dr = new FirefoxDriver();
  @Test
  public void Login() 
  {
	  System.out.println("***************************************@Test Login()***************************************");
  }
  
  @Test (enabled = true)
  public void CreateSO1()
  {
	  System.out.println("***************************************@Test CreateSO1***************************************");
  }
  
  @Test
  public void CreateSO2()
  {
	  dr.findElement(By.xpath("/html/body/div")).click();
	  System.out.println("***************************************@Test CreateSO2***************************************");
	  throw new SkipException("Test");
  }
  
  @Test
  public void CreateSO3() 
  {
	  System.out.println("***************************************@Test CreateSO3***************************************");
	  throw new SkipException("Test");
  }
 
  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("***************************************@BeforeTest***************************************");

  }

  @AfterTest
  public void afterTest()
  {
	  System.out.println("***************************************@AfterTest***************************************");
	  dr.quit();
  }
}
