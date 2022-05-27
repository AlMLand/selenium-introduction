package main.section9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

public class FluentWaitExample {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button")).click();
		// version nr. 1
//		WebElement webElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
		// version nr. 2
		WebElement webElement = fluentWait.until(d -> {
			if (d.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
				return d.findElement(By.xpath("//div[@id='finish']/h4"));
			} else {
				return null;
			}
		});

		String expectedMessage = "Hello World!";
		String actualMessage = webElement.getText();
		Assert.assertEquals(actualMessage, expectedMessage);

		driver.quit();

	}

}
