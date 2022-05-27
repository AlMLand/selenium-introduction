package main.section10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithScrollToSpecieficElement {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.xpath("//h4[text()='Cucumber - 1 Kg']/parent::div//button"))).build().perform();

		// scroll to the element
		WebElement element = driver.findElement(By.xpath("//h4[text()='Walnuts - 1/4 Kg']/parent::div//button"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
		waitDriver.until(ExpectedConditions.elementToBeClickable(element)).click();

	}

}
