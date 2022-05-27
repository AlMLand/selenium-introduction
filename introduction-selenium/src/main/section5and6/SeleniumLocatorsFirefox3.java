package main.section5and6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SeleniumLocatorsFirefox3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//header/div[2]/following-sibling::div[1]/div/div/div[1]/following-sibling::div/nav/div[2]/ul/li[7]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//form[@id='form']/div/div[1]/input[@id='name']")).sendKeys("Alex");
		driver.findElement(By.xpath("//form[@id='form']/div/div[2]/input[@id='email']")).sendKeys("morlandalex@googlemail.com");
		driver.findElement(By.xpath("//input[@id='agreeTerms']")).click();
		driver.findElement(By.xpath("//button[@id='form-submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[1]/div[@class='container']/div[@class='projects-item'][1]/a[2]")).click();
		Thread.sleep(1000);
		
		var expected = "Practice";
		String actual = driver.findElement(By.xpath("//header/div/button[text()='Practice']")).getText();
		Assert.assertEquals(actual, expected);
		
		var expected2 = "Free Access to InterviewQues/ResumeAssistance/Material";
		String actual2 = driver.findElement(By.xpath("//header/div/button[text()='Practice']/parent::div/parent::header/a[@class='blinkingText']")).getText();
		Assert.assertEquals(actual2, expected2);
		
		driver.quit();

	}

}
