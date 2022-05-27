package main.section10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WindowHandler {

	public static void main(String[] args) {
		
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setHeadless(true);
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		String [] windows = driver.getWindowHandles().toArray(new String[0]);
		driver.switchTo().window(windows[1]);
		String expectedMessage = "Learn Earn & Shine";
		String actualMessage = waitDriver.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Academy')]//strong")))
				.getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		
		driver.switchTo().window(windows[0]);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(actualMessage);
		
		driver.quit();

	}

}
