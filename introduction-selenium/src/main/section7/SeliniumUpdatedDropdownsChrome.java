package main.section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeliniumUpdatedDropdownsChrome {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(2000);
		
		for(int i = 0; i < 4; i++) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		String expected = "5";
		String actual = driver.findElement(By.xpath("//span[@id='spanAudlt']")).getText();
		Assert.assertEquals(actual, expected);
		
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		Thread.sleep(2000);
		
		String expextedB = "5 Adult";
		String actualB = driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText();
		Assert.assertEquals(actualB, expextedB);
		
		driver.close();

	}

}
