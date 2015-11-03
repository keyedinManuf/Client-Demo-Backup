package pak1;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class SOManipulation extends Login
{
	public static String Str;
	
	@Test (priority=2)
	  public void AddSO() 
	  {
		System.out.println("************** SALES ORDER CREATION **************");
		//dr.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
		dr.findElement(By.xpath(".//a[@href='/Dev03/Form/Create/70']")).click();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[5]/div/input")).sendKeys("Test");
		dr.findElement(By.xpath("html/body/div[5]/ul/li[2]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[5]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[6]/div/input")).sendKeys("KI Bikes");
		dr.findElement(By.xpath("html/body/div[6]/ul/li[1]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[6]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[7]/div/input")).sendKeys("CAD - Canadian Dollars");
		dr.findElement(By.xpath("html/body/div[7]/ul/li[1]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[8]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[8]/div/input")).sendKeys("Mark B");
		dr.findElement(By.xpath("html/body/div[8]/ul/li[1]/div")).click();
		dr.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
		WebElement WE1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
		Str = WE1.getText();
		System.out.println("New Sales Order Created Succesfully & Order Number is: "+Str);
		  
	  }
	
	@Test (priority=3)
	  public void EditSO() throws IOException
	  {
		System.out.println("Created Order Number is : "+Str);
		System.out.println("************** SALES ORDER SEARCH **************");
		dr.get(Attributes().getProperty("URL"));
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).click();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).sendKeys(Str);
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[9]/button[1]")).click();

		List<WebElement> V2 = dr.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
		int C2 = V2.size();
			if(C2==0)
			{
				System.out.println("if : Entered Order Number "+ Str +" is not filtered in the below list");
			}
				else
				{
					System.out.println("Else : Entered Order Number "+ Str +" is fi ltered in the below list");
				}
	  }
	
	@Test (priority=4)
	  public void ViewSO() throws IOException
	  {
		System.out.println("************** SALES ORDER VIEW **************");
		dr.get(Attributes().getProperty("URL"));
		String x1 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x2 = "]/td[1]/div[2]/a[6]";
		String x3 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x4 = "]/td[1]/div[2]/ul/li[3]";
		WebElement table = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int TableSize = allRows.size()-1;
		Random rand = new Random(System.currentTimeMillis());
		int rval = rand.nextInt(TableSize);
		System.out.println("mber: "+rval);
		dr.findElement(By.xpath(x1+rval+x2)).click();
		dr.findElement(By.xpath(x3+rval+x4)).click();		
		WebElement WW2 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
		System.out.println("Order Number is: "+WW2.getText());
	  }
	
	@Test (priority=5)
	  public void DeleteSO() throws IOException
	  {
		System.out.println("************** SALES ORDER DELETE **************");
		dr.get(Attributes().getProperty("URL"));
		//Random Order Navigate
		String x1 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x2 = "]/td[1]/div[2]/a[6]";
		//Random Delete Button
		String x3 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x4 = "]/td[1]/div[2]/ul/li[5]";
		//Random Order Number
		String x5 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x6 = "]/td[3]/div/a";
		WebElement table = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int TableSize = allRows.size()-1;
		Random rand = new Random(System.currentTimeMillis());
		int rval = rand.nextInt(TableSize);
		System.out.println("Row Number: "+rval);
		dr.findElement(By.xpath(x1+rval+x2)).click();
		String S1 = dr.findElement(By.xpath(x5+rval+x6)).getText();
		System.out.println("Order Number to be Delete : "+S1);
		dr.findElement(By.xpath(x3+rval+x4)).click();	
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/button[1]")).click();
	  }
	
	@Test (priority=6)
	  public void T4()
	  {
		  dr.findElement(By.xpath("/html/body/div")).click();
		  System.out.println("***************************************@Testcase Skipped ***************************************");
		  throw new SkipException("Test");
	  }
}