package main.section7;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AssigmentFirefox {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.xpath("//form//input[@name='name']")).sendKeys("user");
		getScreenShot(driver);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("user@gmail.com");
		driver.findElement(By.xpath("id('exampleInputPassword1')")).sendKeys("secret");

		assertFalse(driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected());
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		assertTrue(driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected());

		WebElement webElement = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		Select gender = new Select(webElement);
		gender.selectByVisibleText("Male");

		assertFalse(driver.findElement(By.xpath("//input[@id='inlineRadio1']")).isSelected());
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		assertTrue(driver.findElement(By.xpath("//input[@id='inlineRadio1']")).isSelected());

		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("13052022");
		getScreenShot(driver);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String expectedSuccessMessage = "×\nSuccess! The Form has been submitted successfully!.";
		String actualSuccessMessage = driver.findElement(By.xpath("//form-comp//div[contains(@class, 'alert')]"))
				.getText();
		assertEquals(actualSuccessMessage, expectedSuccessMessage);
		System.out.println(actualSuccessMessage);

		driver.quit();

	}

	/**
	 * Create photo and save it in the locale directory.
	 * 
	 * @param driver the driver
	 * @throws IOException the ioexception
	 */
	private static void getScreenShot(final WebDriver driver) throws IOException {
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String className = AssigmentFirefox.class.getName();
		FileUtils.copyFile(screenShotFile,
				new File("C:/Users/morla/Documents/books/readed/udemy_selenium/test_screnshots" + "/"
						+ className.substring(className.indexOf('.') + 1).toLowerCase() + "/"
						+ screenShotFile.getName()));
	}

}
