package main.section12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssingnmentEight {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		String expectedMessage = "United States (USA)";
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//input[@id='autocomplete']"))).click().sendKeys("uni")
				.build().perform();

		waitDriver.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']//li")));

		actions.moveToElement(driver.findElements(By.xpath("//ul[@id='ui-id-1']//li")).stream()
				.filter(webElement -> webElement.getText().equals(expectedMessage)).findFirst().get()).click().build()
				.perform();

		// becom the actual text from auto suggest dropdown
		String actualMessage = driver.findElement(By.xpath("//input[@id='autocomplete']")).getAttribute("value");
		Assert.assertEquals(actualMessage, expectedMessage);
		
		driver.close();

	}

}
