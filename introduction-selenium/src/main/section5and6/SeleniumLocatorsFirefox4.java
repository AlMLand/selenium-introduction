package main.section5and6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLocatorsFirefox4 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@text='Male (MLE)']")).click();
		
		driver.findElement(By.xpath("//a[@text='Goa (GOI)']")).click();
		
		driver.findElement(By.xpath("//td[@data-month='5'][1]/a[text()='5']")).click();
		
		driver.findElement(By.xpath("//div[@id='Div1']/button")).click();
		driver.findElement(By.xpath("//td[@data-month='5'][1]/a[text()='12']")).click();
		
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")).click();
		driver.findElement(By.xpath("//option[@value='AED']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		
		driver.quit();

	}

}
