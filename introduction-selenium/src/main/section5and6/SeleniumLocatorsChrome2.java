package main.section5and6;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocatorsChrome2 {

	public static void main(String[] args) throws InterruptedException {
		
		String name = "alex";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(getPassword(driver));
		driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
		driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'signInBtn')]")).click();
		
		Thread.sleep(1000);
		String actualA = driver.findElement(By.tagName("p")).getText();
		System.out.println(actualA);
		var expectedA = "You are successfully logged in.";
		assertEquals(actualA, expectedA);
		
		String actualB = driver.findElement(By.xpath("//h2")).getText();
		assertEquals(actualB, "Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.close();

	}

	private static String getPassword(final WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		String message = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		driver.findElement(By.xpath("//button[contains(@class, 'go-to')]")).click();
		Thread.sleep(1000);
		return extractPassword(message);
	}
	
	private static String extractPassword(final String message) {
		return message.substring(message.indexOf("\'") + 1, message.lastIndexOf("\'"));
	}
	
}
