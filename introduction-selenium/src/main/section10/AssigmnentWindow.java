package main.section10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssigmnentWindow {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		String[] windows = driver.getWindowHandles().toArray(new String[0]);

		driver.switchTo().window(windows[1]);
		String childMessage = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")))
				.getText();
		System.out.println("childMessage=" + childMessage);

		driver.switchTo().window(windows[0]);
		String parrentMessage = driver.findElement(By.xpath("//h3")).getText();
		System.out.println("parrentMessage=" + parrentMessage);

		driver.quit();

	}

}
