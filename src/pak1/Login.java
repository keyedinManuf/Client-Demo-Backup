package pak1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class Login 
{
	public static WebDriver dr = new FirefoxDriver();
	@BeforeTest
	  public void beforeTest() throws IOException 
	  {
		  dr.manage().window().maximize();
		  dr.get(Attributes().getProperty("URL"));
	  }

	@Test
	  public Properties Attributes() throws IOException
	  {
		FileReader ff = new FileReader("D:/test/0_KeyedTestNG/src/pak2/KeyedIN_Attributes");
		Properties pp = new Properties();
		pp.load(ff);
		return(pp);
	  }
	
	@Test
	  public Properties Testdata() throws IOException 
	  {
		FileReader ff = new FileReader("D:/test/0_KeyedTestNG/src/pak2/KeyedIN_TestData");
		Properties pp = new Properties();
		pp.load(ff);
		return(pp);  
	  }
	
	@Test (priority=1)
	  public void Login1() throws IOException 
	  {
		try{
			dr.findElement(By.xpath(Attributes().getProperty("UN"))).sendKeys(Testdata().getProperty("UN"));
			dr.findElement(By.xpath(Attributes().getProperty("Pwd"))).sendKeys(Testdata().getProperty("Pwd"));
			dr.findElement(By.xpath(Attributes().getProperty("Click"))).click();
			String Str1 = dr.getPageSource();
			String Str2 = "User Name";
			if(Str1.contains(Str2))
			{
				System.out.println("Yet To Login");
			}
			else
			{
				System.out.println("Logged In Successfully");
			}	
			//dr.findElement(By.xpath(Attributes().getProperty("Home"))).click();
			}catch(NullPointerException e){
				System.out.println(e);
				System.out.println("rest of the code...");
			}
	  }
}
