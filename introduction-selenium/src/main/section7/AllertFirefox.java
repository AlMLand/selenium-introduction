package main.section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class AllertFirefox {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Alex");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		Assert.assertEquals(driver.switchTo().alert().getText(), "Hello Alex, share this practice page and share your knowledge");
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Alex");
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		Assert.assertEquals(driver.switchTo().alert().getText(), "Hello Alex, Are you sure you want to confirm?");
		driver.switchTo().alert().dismiss();
		
		driver.quit();

	}

}
