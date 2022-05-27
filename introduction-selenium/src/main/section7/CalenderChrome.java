package main.section7;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderChrome {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).isEnabled());
		assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		
		assertEquals(driver.findElement(By.xpath("//td[@data-month='4']//a[text()='14']")).getText(), "14");
		driver.findElement(By.xpath("//td[@data-month='4']//a[text()='14']")).click();
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).click();
		assertEquals(driver.findElement(By.xpath("//td[@data-month='5']//a[text()='12']")).getText(), "12");
		driver.findElement(By.xpath("//td[@data-month='5']//a[text()='12']")).click();
		
		driver.close();

	}

}
