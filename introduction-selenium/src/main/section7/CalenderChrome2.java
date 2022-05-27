package main.section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderChrome2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		String elementDisabled = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style");
		String expectedDisabledElementStyle = "display: block; opacity: 0.5;";
		Assert.assertEquals(elementDisabled, expectedDisabledElementStyle);
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		String elementEnabled = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style");
		String expectedEnabledElementStyle = "display: block; opacity: 1;";
		Assert.assertEquals(elementEnabled, expectedEnabledElementStyle);
		
		driver.close();

	}

}
