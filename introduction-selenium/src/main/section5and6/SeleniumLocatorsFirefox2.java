package main.section5and6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SeleniumLocatorsFirefox2 {

	public static void main(String[] args) throws InterruptedException {
		
		String name = "alex";
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.cssSelector("#chkboxTwo")).click();
		driver.findElement(By.cssSelector(".signInBtn")).click();
		Thread.sleep(1000);
		var actual = driver.findElement(By.cssSelector("p")).getText();
		Assert.assertEquals(actual, "You are successfully logged in.");
		
		var actual2 = driver.findElement(By.cssSelector("h2")).getText();
		Assert.assertEquals(actual2, "Hello " + name + ",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		driver.quit();

	}

}
