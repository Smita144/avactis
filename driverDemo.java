package scripts;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.grid.node.docker.DockerOptions;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterMethod;

public class driverDemo {
	 
	WebDriver driver;
	
	
  @Test
public void IndiaToday() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	
	//  WebDriver driver=new ChromeDriver();
	
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--no-sandbox");
	 options.addArguments("--disable-dev-shm-usage");
	//options.addArguments("--remote-allow-origins=*");
	 Thread.sleep(5000);
	  try {driver.switchTo().frame(  "google_ads_iframe_/1007232/IT_HP_Desktop_MTF_3_728x90_0" );

  }catch (NoSuchFrameException e) {
		  fail("Frame was expected but not found");}
	 
	 
	 
	  driver.findElement(By.xpath("//div [@class='ns-1bixw-e-18 flip-on-rtl button']")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver=new ChromeDriver();
	 // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 // driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://www.indiatoday.in ");
  }

  

  @AfterMethod
  public void afterMethod() {
	  

  }

}
