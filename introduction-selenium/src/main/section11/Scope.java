package main.section11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Scope {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		int expectedLinkAll = 27;
		int actualLinkAll = driver.findElements(By.xpath("//a")).size();
		Assert.assertEquals(actualLinkAll, expectedLinkAll);

		int expectedLinkFooter = 20;
		int actualLinkFooter = driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size();
		Assert.assertEquals(actualLinkFooter, expectedLinkFooter);

		int expectedLinkFooterLeft = 5;
		// example xpath backwards: "//a[text()='Discount Coupons']/parent::h3/parent::li/parent::ul//a"
		int actualLinkFooterLeft = driver.findElements(By.xpath("//div[@id='gf-BIG']//table//tbody//tr//td[1]//a"))
				.size();
		Assert.assertEquals(actualLinkFooterLeft, expectedLinkFooterLeft);

		// click and check the count of tabs
		String openTheNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		driver.findElements(By.xpath("//div[@id='gf-BIG']//table//tbody//tr//td[1]//a")).forEach(webElement -> {
			webElement.sendKeys(openTheNewTab);
		});
		Assert.assertEquals(driver.getWindowHandles().size(), 6);

		// print all titles from the pages
		driver.getWindowHandles().forEach(window -> {
			WebDriver windowDriver = driver.switchTo().window(window);
			WebDriverWait waitDriver = new WebDriverWait(windowDriver, Duration.ofSeconds(3));
			waitDriver.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div")));
			System.out.println(windowDriver.getTitle());
		});

		driver.quit();

	}

}
