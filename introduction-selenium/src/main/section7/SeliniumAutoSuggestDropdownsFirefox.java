package main.section7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SeliniumAutoSuggestDropdownsFirefox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ni");
		Thread.sleep(3000);
		
		List<WebElement> webElements = driver.findElements(By.xpath("//ul[@id='ui-id-1']//a"));
		Assert.assertEquals(webElements.size(), 28);
		
		for(WebElement webElement : webElements) {
			if(webElement.getText().equalsIgnoreCase("United States (USA)")) {
				webElement.click();
				break;
			}
		}
		
		driver.quit();

	}

}
