package main.section5and6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocatorsChrome {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("alex");
		driver.findElement(By.name("inputPassword")).sendKeys("secret");
		driver.findElement(By.className("signInBtn")).click();
		String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();		//browser console: $('p.error')
		System.out.println(errorMessage);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);		// daju vremja stranice polnostju progrusitsja
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Timur");		//browser console: $x('//input[@placeholder="Name"]')
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("notRightEmail@gmail.com");		//browser console: $('input[placeholder="Email"]')
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();		//browser console: $x('//input[@type="text"][2]')
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("timur@gmail.com");		//browser console: $('input[type="text"]:nth-child(3)')
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0176 123456789");		//browser console: $x('//form/input[3]')
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();		//browser console: $('.reset-pwd-btn')
		String sucsessfulMessage = driver.findElement(By.cssSelector("form p")).getText();		//browser console: $('form p')
		System.out.println(sucsessfulMessage);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(		// dinamicheskij cssSelector: * esli value mozhet menjatsja i konstanta tolko 'pass'
				sucsessfulMessage.substring(sucsessfulMessage.indexOf('\'') + 1, sucsessfulMessage.lastIndexOf('\'')));
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();	// dinamicheskih xpath, value - 'submit' eto konstatna, i k nemu mogut dobavljatsja drugie znachenija

		driver.close();

	}

}
