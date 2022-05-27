package main.section7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeliniumAutoSuggestDropdownsChrome {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(3000);

		List<WebElement> webElements= driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));
		Assert.assertEquals(webElements.size(), 3);
		
		List<String> countrys = List.of("British Indian Ocean Territory", "India", "Indonesia");
		for (WebElement webElement : webElements) {
			Assert.assertTrue(countrys.contains(webElement.getText()));
		}
		
		webElements.get(1).click();
		
		driver.close();

	}

}
