package main.section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SeliniumStaticDropdownsChrome {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(3);
		String actualA = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(actualA, "USD");
		
		dropdown.selectByVisibleText("AED");
		String actualB = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(actualB, "AED");
		
		dropdown.selectByValue("INR");
		String actualC = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(actualC, "INR");
		
		driver.close();

	}

}
