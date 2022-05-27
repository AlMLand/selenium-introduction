package main.section5and6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumLocatorsEdge2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
		driver.navigate().to("https://rahulshettyacademy.com/");
		driver.navigate().back();
		driver.navigate().forward();

	}

}
