package BootCamp2022.ExpediaWebSiteBootCamp;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;

public class ExpidaWebSiteTest {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  
	  //LEAVING FORM
	  driver.findElement(By.xpath("//*[@aria-label='Leaving from']")).click();
	  driver.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("Dubai");
	  driver.findElement(By.xpath("//*[@class='uitk-icon uitk-icon-leading uitk-icon-small']")).click();
	  //GOING TO
	  driver.findElement(By.xpath("//*[@aria-label='Going to']")).click();
	  driver.findElement(By.xpath("(//*[@type='text'])[9]")).sendKeys("Lahore");
	 driver.findElement(By.xpath("//*[@aria-label='Search for “Lahore”']")).click();
	 // CheckIn//Checkout
	 driver.findElement(By.id("d1-btn")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//*[@data-stid=\"date-picker-paging\"])[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//tbody//tr//button)[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[@aria-label='Dec 2, 2022 selected, current check in date.']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@data-stid=\"apply-date-picker\"]")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("d2-btn")).click();
    driver.findElement(By.xpath("(//*[@data-stid=\"date-picker-paging\"])[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//tbody//tr//button)[5]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@data-stid=\"apply-date-picker\"]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//*[@type=\"submit\"])[1]")).click();
	
  }
  @BeforeClass
 
	  public void BeforeClass() {
		  Ibrowsers("Chrome");
	  }
	  public  void Ibrowsers(String NameOfBrowser) {
			if(NameOfBrowser.equals("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.navigate().to("https://www.expedia.com/Flights");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}else if(NameOfBrowser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new EdgeDriver();
				driver.navigate().to("https://www.expedia.com/Flights");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
			  }
		  
		@AfterClass
		public void Afterclass() throws IOException{
			
		}
	  public void Screenshot() throws IOException  {
		  String jk = System.getProperty("user.dir");//any other want ur project
		  System.out.println(jk);
		  Date ob = new Date();
		  System.out.println(ob);
		  String files=ob.toString().replace(" ", "_").replace(":", "_");
		  System.out.println(files);
		  File pages=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(pages, new File(jk+"\\pictures\\"+files+"Home1.jpg"));
		  }

		 	  
	}

  

  
