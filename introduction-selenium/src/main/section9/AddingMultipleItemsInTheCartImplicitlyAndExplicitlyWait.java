package main.section9;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddingMultipleItemsInTheCartImplicitlyAndExplicitlyWait {

	private WebDriver driver;
	private static String directory;

	public static void main(String[] args) throws IOException {

		new AddingMultipleItemsInTheCartImplicitlyAndExplicitlyWait().testMethod();

	}

	private void testMethod() throws IOException {
		driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// implicitly wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// explicitly wait
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		createOrCleanScreenShotDirectory();

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

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		getScreenShot();
		int expectedCountItemsInCart = toTestProductNames.size();
		int actualCountItemsInCart = driver
				.findElements(By.xpath("//div[@class='cart-preview active']//ul[@class='cart-items']//li")).size();
		Assert.assertEquals(actualCountItemsInCart, expectedCountItemsInCart);
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		// explicitly wait
		webDriverWait.until(ExpectedConditions.urlMatches("https://rahulshettyacademy.com/seleniumPractise/#/cart"));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("fail");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		// explicitly wait
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		String expectedInvalidMessage = "Invalid code ..!";
		String actualInvalidMessage = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		Assert.assertEquals(actualInvalidMessage, expectedInvalidMessage);
		getScreenShot();

		driver.findElement(By.xpath("//input[@class='promoCode']")).clear();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		// explicitly wait
//		webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='promoInfo']"), "Code applied ..!"));
		// fluent wait
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
		WebElement webElement = fluentWait.until(d -> {
			if (!d.findElement(By.xpath("//span[@class='promoInfo']")).getText().equals("Invalid code ..!")) {
				return d.findElement(By.xpath("//span[@class='promoInfo']"));
			} else {
				return null;
			}
		});
		String actualRightMessageFluentWait = webElement.getText();

		String expectedRightdMessage = "Code applied ..!";
//		String actualRightMessageWebDriverWait = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		Assert.assertEquals(actualRightMessageFluentWait, expectedRightdMessage);
		getScreenShot();

		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		getScreenShot();

		driver.quit();
	}

	private void createOrCleanScreenShotDirectory() throws IOException {
		String className = AddingMultipleItemsInTheCartImplicitlyAndExplicitlyWait.class.getName();
		directory = "src/resources/testscreenshots" + "/"
				+ className.substring(className.indexOf('.') + 1).toLowerCase();
		File file = Path.of(directory).toFile();
		if (file.exists()) {
			FileUtils.cleanDirectory(new File(directory));
		} else {
			file.mkdir();
		}
	}

	private void getScreenShot() throws IOException {
		byte[] screenSchot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(
				directory + "/" + LocalTime.now().format(DateTimeFormatter.ofPattern("hh_mm_ss")) + ".png")))) {
			bos.write(screenSchot);
		}
	}

}
