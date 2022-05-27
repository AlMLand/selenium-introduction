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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentExplicitlyWait {
	
	private WebDriver driver;
	private static String directory;

	public static void main(String[] args) throws IOException {
		
		new AssignmentExplicitlyWait().testMethod();

	}

	private void testMethod() throws IOException {
		createOrCleanScreenShotDirectory();
		driver = new ChromeDriver();
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
		
		driver.findElement(By.xpath("//span[text()=' User']/parent::label//span[@class='checkmark']")).click();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		
		WebElement webElementSelect = driver.findElement(By.xpath("//select"));
		Select select = new Select(webElementSelect);
		select.selectByValue("consult");
		
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		getScreenShot();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		driverWait.until(ExpectedConditions.urlMatches("https://rahulshettyacademy.com/angularpractice/shop"));
		
		List<WebElement> webElementsToAdd = driver.findElements(By.xpath("//div[@class='card-footer']//button"));
		webElementsToAdd.forEach(we -> we.click());
		
		driver.findElement(By.xpath("//div[@id='navbarResponsive']//a")).click();
		getScreenShot();
		
		String expectedTotal = "₹. 300000";
		String actualTotal = driver.findElement(By.xpath("//h3//strong")).getText();
		Assert.assertEquals(actualTotal, expectedTotal);
		
		driver.quit();
	}
	
	private void createOrCleanScreenShotDirectory() throws IOException {
		String className = AssignmentExplicitlyWait.class.getName();
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
