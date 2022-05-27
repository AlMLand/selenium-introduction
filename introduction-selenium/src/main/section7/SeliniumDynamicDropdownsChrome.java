package main.section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeliniumDynamicDropdownsChrome {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		// the same variant without index and with full path
//		driver.findElement(By.xpath(
//				"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']/table[@id='citydropdown']/tbody/tr/td/div/div/div/ul/li/a[@value='MAA']"))
//				.click();
		// the same variant without index and with part path
//		driver.findElement(By.xpath(
//				"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
//				.click();
		
		driver.findElement(By.xpath("(//a[text()='10'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).click();

		driver.findElement(By.xpath("(//a[text()='11'])[2]")).click();
		
		driver.close();

	}

}
