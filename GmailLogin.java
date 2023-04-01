package scripts;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class GmailLogin {
	WebDriver driver;
  @Test
  public void gMailLogin() throws InterruptedException {
	  
	 
	  
	
	 
 
	 Actions builder=new Actions(driver);
	// driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a")).click();---> to open gmail in same tab
	// driver.findElement(By.xpath("//*[@id=\"cookieBar\"]/div/span[2]/a[2]")).click();
	 
	 
	 String clicklnk=Keys.chord(Keys.CONTROL,Keys.ENTER);
	 
	driver.findElement(By.xpath("//a[text()='Gmail']")).sendKeys(clicklnk);
	 String Parentwindowhandle=driver.getWindowHandle();
	  Set<String> allopenWindowsByThisDriver1=driver.getWindowHandles();
	  for(String oneWindow:allopenWindowsByThisDriver1) {
		 if(!oneWindow.equals(Parentwindowhandle)) {
		 driver.switchTo().window(oneWindow);
		  driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ketanvj@gmail.com");
		 
		  
		  driver.close();
		  driver.switchTo().window(Parentwindowhandle);
		  //driver.navigate().back();
		//  driver.navigate().back();
		  driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Selenium is easy");
		  builder.sendKeys(Keys.ENTER).build().perform();}}}
		
	 
	 
	 
	 
	 
		
	  
	   
  
  @BeforeMethod
  public void beforeMethod() {
	//  WebDriverManager.chromedriver().setup();
		 WebDriverManager.chromedriver().setup();
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		 // options.addArguments("--disable notifications");
		  DesiredCapabilities cp=new DesiredCapabilities();
		  cp.setCapability(ChromeOptions.CAPABILITY, options);
		  options.merge(cp);
		 driver=new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.get("https://www.google.com/");
  }

  @AfterMethod
  public void afterMethod() {
  }

}
