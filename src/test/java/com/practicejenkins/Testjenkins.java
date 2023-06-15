package com.practicejenkins;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testjenkins {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() 
	{
		driver = new ChromeDriver();
		//driver.get("https://testgloballogic.learnupon.com/users/sign_in");
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30,timeunits.of)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test(priority=1)

	public void hotel() throws MalformedURLException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Hotels']"));
		String name = driver.getTitle();
		assertEquals(name, "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
}
	@Test(priority=2)

	public void bus()
	{
		driver.findElement(By.partialLinkText("Buses")).click();
		String bustitle = driver.getTitle();
		//assertEquals(bustitle,"Online Bus Booking";)
		assertEquals(bustitle, "Online Bus Booking - Book online AC, Non AC, Volvo, Sleeper & Luxury Buses with Yatra.com");
	}
	@Test(priority=3)

	public void holidays()
	{
		driver.findElement(By.partialLinkText("Holidays")).click();
		WebElement tavel = driver.findElement(By.xpath("(//span[text()='Month of Travel (Optional)'])[1]"));
		tavel.click();
		Actions a=new Actions(driver);
		WebElement month = driver.findElement(By.xpath("//span[text()='July 2023']"));
		a.moveToElement(month).build().perform();
		driver.findElement(By.id("BE_holiday_search_btn")).click();
		
		
	}
}
