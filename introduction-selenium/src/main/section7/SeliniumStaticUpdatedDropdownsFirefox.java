package main.section7;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeliniumStaticUpdatedDropdownsFirefox {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select sd = new Select(staticDropdown);
		
		sd.selectByIndex(3);
		String actualByIndex = sd.getFirstSelectedOption().getText();
		assertEquals(actualByIndex, "USD");
		
		sd.selectByValue("AED");
		String actualByValue = sd.getFirstSelectedOption().getText();
		assertEquals(actualByValue, "AED");
		
		sd.selectByVisibleText("INR");
		String actualByVisibleText = sd.getFirstSelectedOption().getText();
		assertEquals(actualByVisibleText, "INR");
		
		List<WebElement> webElements = sd.getOptions();
		assertEquals(webElements.size(), 4);
		
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		for(int i = 0; i < 7; i++) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		String expectedD = "8";
		String actualD = driver.findElement(By.xpath("//span[@id='spanAudlt']")).getText();
		assertEquals(actualD, expectedD);
		
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		
		String expectedE = "8 Adult";
		String actualE = driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText();
		assertEquals(actualE, expectedE);
		
		driver.quit();

	}

}
