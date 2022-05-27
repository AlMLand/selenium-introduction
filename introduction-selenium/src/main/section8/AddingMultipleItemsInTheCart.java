package main.section8;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class AddingMultipleItemsInTheCart {

	private WebDriver driver;
	private String className;
	private String directory;

	{
		className = AddingMultipleItemsInTheCart.class.getName();
		directory = "src/resources/testscreenshots" + "/"
				+ className.substring(className.indexOf('.') + 1).toLowerCase();
		// only if test files saves in the system
//		directory = "C:/Users/morla/Documents/books/readed/udemy_selenium/test_screnshots" + "/"
//				+ className.substring(className.indexOf('.') + 1).toLowerCase();
	}

	public static void main(String[] args) throws IOException {

		new AddingMultipleItemsInTheCart().testMethod();

	}

	private void testMethod() throws IOException {
		driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		cleanScreenShotDirectory();
		getScreenShot();

		List<String> toTestProductNames = List.of("Cucumber - 1 Kg", "Tomato - 1 Kg", "Raspberry - 1/4 Kg",
				"Pista - 1/4 Kg");
		List<WebElement> webElementsNames = driver.findElements(By.xpath("//h4[@class='product-name']"));
		List<WebElement> webElementsToAdd = driver.findElements(By.xpath("//div[@class='product-action']//button"));
		for (int index = 0, count = 0; index < webElementsNames.size(); index++) {
			if (toTestProductNames.contains(webElementsNames.get(index).getText())) {
				webElementsToAdd.get(index).click();
				getScreenShot();
				count++;
				if (count == toTestProductNames.size()) {
					break;
				}
			}
		}

		String expectedItemsCount = Integer.valueOf(toTestProductNames.size()).toString();
		String actualItemsCount = driver.findElement(By.xpath("//td[text()='Items']/parent::tr//strong")).getText();
		Assert.assertEquals(actualItemsCount, expectedItemsCount);

		driver.quit();
	}

	private void cleanScreenShotDirectory() throws IOException {
		if (Path.of(directory).toFile().exists()) {
			FileUtils.cleanDirectory(new File(directory));
		}
	}

	private void getScreenShot() throws IOException {
		byte[] screenSchot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(
				directory + "/" + LocalTime.now().format(DateTimeFormatter.ofPattern("hh_mm_ss")) + ".png")))) {
			bos.write(screenSchot);
		}
//		File screenSchot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screenSchot, new File(directory + "/" + screenSchot.getName()));
	}

}
