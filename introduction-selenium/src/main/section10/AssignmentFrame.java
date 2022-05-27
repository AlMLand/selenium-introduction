package main.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AssignmentFrame {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']"))).switchTo()
				.frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));

		String message = driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println(message);

		driver.switchTo().defaultContent();
		driver.quit();

	}

}
