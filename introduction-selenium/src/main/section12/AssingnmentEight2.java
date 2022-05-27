package main.section12;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssingnmentEight2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");

		waitDriver.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']//li")));
		// the Keys.DOWN -> dwigaetsja wniz po spisku, kotorij wipadaet
//		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN));
		// or
		driver.findElement(By.xpath("//input[@id='autocomplete']"))
				.sendKeys(Keys.chord(Collections.nCopies(2, Keys.DOWN)));

		String expectedMessage = "India";
		String actualMessage = driver.findElement(By.xpath("//input[@id='autocomplete']")).getAttribute("value");
		Assert.assertEquals(actualMessage, expectedMessage);

		driver.close();

	}

}
