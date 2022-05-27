package main.section5and6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLocatorsFirefox {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("alex");
		driver.findElement(By.name("inputPassword")).sendKeys("secret");
		driver.findElement(By.className("signInBtn")).click();
		String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorMessage);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Timur");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("notRightEmail@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("timur@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("13456789");
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		String sucsessfulMessage = driver.findElement(By.cssSelector(".infoMsg")).getText();
		System.out.println(sucsessfulMessage);
		String password = sucsessfulMessage.substring(sucsessfulMessage.indexOf('\'') + 1, sucsessfulMessage.lastIndexOf('\''));
		driver.findElement(By.xpath("//form[@action='#']/div/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'sign-in')]/form/input[1]")).sendKeys("rahul");
		driver.findElement(By.xpath("//div[contains(@class,'sign-in')]/form/input[2]")).sendKeys(password);
		driver.findElement(By.xpath("//div[contains(@class,'sign-in')]/form/div[1]/span[1]/input")).click();
		driver.findElement(By.xpath("//div[contains(@class,'sign-in')]/form/div[1]/span[2]/input")).click();
		driver.findElement(By.xpath("//form[@class='form']/button")).click();

//		driver.quit();

	}

}
