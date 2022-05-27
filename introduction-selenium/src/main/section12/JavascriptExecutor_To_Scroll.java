package main.section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutor_To_Scroll {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		// scroll the complett browser window on specified position
		javascriptExecutor.executeScript("window.scrollBy(0, 500)");
		// scroll in a specified table on the page, damit alle elementer der tabelle einmal zu sehen werde, so werden diese registriert
		javascriptExecutor.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0, 5000)");
		// or: 							  document.querySelector(".tableFixHead").scrollTop=120

		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='product']//td[4]"));

		int actualSummeAmounts = tableRows.stream().map(webElement -> Integer.parseInt(webElement.getText().trim()))
				.reduce(0, (intA, intB) -> intA + intB);

		String pageAmountMessage = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText()
				.replaceAll("\\D", "");
		int expectedSummeAmounts = Integer.parseInt(pageAmountMessage);

		Assert.assertEquals(actualSummeAmounts, expectedSummeAmounts);

		driver.close();

	}

}
