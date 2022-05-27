package main.section7;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumFullCheckFirefox {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[text()=' Bangkok (BKK)']")).click();
		String expectedDeparture = "Bangkok (BKK)";
		String actualDeparture = driver
				.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"))
				.getAttribute("selectedtext");
		assertEquals(actualDeparture, expectedDeparture);

		driver.findElement(By.xpath(
				"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[text()=' Dubai, All Airports(DWC) (DXB)']"))
				.click();
		String actualArrival = driver
				.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"))
				.getAttribute("selectedtext");
		String expectedArrival = "Dubai, All Airports(DWC) (DXB)";
		assertEquals(actualArrival, expectedArrival);

		driver.findElement(By.xpath("//td[@data-month='4']//a[text()='19']")).click();
		String expectedDepartDate = "Thu, May 19 2022";
		String actualDepartDate = driver.findElement(By.xpath("//span[@id='view_fulldate_id_1']")).getText();
		assertEquals(actualDepartDate, expectedDepartDate);

		String actualReturnDateDisabled = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style");
		assertTrue(actualReturnDateDisabled.equals("display: block; opacity: 0.5;"));
		assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).isSelected());
		assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).isSelected());
		assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		String actualReturnDateEnabled = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style");
		assertTrue(actualReturnDateEnabled.equals("display: block; opacity: 1;"));

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).click();
		driver.findElement(By.xpath("//td[@data-month='5']//a[text()='26']")).click();
		String expectedArrivalDate = "Sun, Jun 26 2022";
		String actualArrivalDate = driver.findElement(By.xpath("//span[@id='view_fulldate_id_2']")).getText();
		assertEquals(actualArrivalDate, expectedArrivalDate);

		assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());

		String expectedPassengerForAction = "1 Adult";
		String actualPassengerForAction = driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText();
		assertEquals(actualPassengerForAction, expectedPassengerForAction);
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		assertTrue(driver.findElement(By.xpath("//span[@id='spanChild']")).getText().equals("0"));
		driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
		assertTrue(driver.findElement(By.xpath("//span[@id='spanChild']")).getText().equals("1"));
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		String expectedPassengerAfterAction = "2 Adult, 1 Child";
		String actualPassengerAfterAction = driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText();
		assertEquals(actualPassengerAfterAction, expectedPassengerAfterAction);

		WebElement currency = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select currencySelect = new Select(currency);
		currencySelect.selectByValue("USD");

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		String expectedAlertMessage = "Family and Friends discount is applicable for a minimum of 4 passenger (excluding infant) on a single booking. Terms and conditions apply.";
		String actualAlertMessage = driver.switchTo().alert().getText();
		assertEquals(actualAlertMessage, expectedAlertMessage);
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();

		driver.quit();

	}

}
