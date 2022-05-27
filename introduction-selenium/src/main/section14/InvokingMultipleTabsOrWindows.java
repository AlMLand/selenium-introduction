package main.section14;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleTabsOrWindows {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.TAB);
		String[] allTabs = driver.getWindowHandles().toArray(new String[0]);
		driver.switchTo().window(allTabs[1]);
		driver.get("https://rahulshettyacademy.com/");

		String messageOnlyFirstElement = driver
				.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(1)
				.getText();

		driver.switchTo().window(allTabs[0]);

		WebElement inputName = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		inputName.sendKeys(messageOnlyFirstElement);
		createScreenShot(inputName);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String successMessage = driver.findElement(By.xpath("//a[@aria-label='close']/parent::div")).getText();
		System.out.println(successMessage);

		// validate height and width
		System.out.println(inputName.getRect().getHeight());
		System.out.println(inputName.getRect().getWidth());

		driver.quit();

	}

	private static void createScreenShot(final WebElement webElement) throws IOException {
		File photoInputName = webElement.getScreenshotAs(OutputType.FILE);
		File directory = new File("src/resources/testscreenshots/section14/");
		if (directory.exists()) {
			FileUtils.cleanDirectory(directory);
		}
		FileUtils.copyFile(photoInputName, new File(directory.getAbsolutePath() + "/" + photoInputName.getName()));
	}

}
