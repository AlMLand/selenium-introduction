package main.section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeliniumCheckboxesFirefox {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		
		int actualCountWebElements = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		Assert.assertEquals(actualCountWebElements, 6);
		
		driver.close();

	}

}
