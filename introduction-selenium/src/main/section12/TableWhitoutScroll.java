package main.section12;

import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TableWhitoutScroll {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@name='courses']//td[3]"));
		int expextedSumPrices = 235;
		int actualSumPrices = tableRows.stream()
				.flatMapToInt(webElement -> IntStream.of(Integer.parseInt(webElement.getText().trim()))).sum();
		Assert.assertEquals(actualSumPrices, expextedSumPrices);
		
		driver.close();

	}

}
