package main.section13;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		SoftAssert softAssert = new SoftAssert();
		for (WebElement we : links) {
			HttpURLConnection connection = (HttpURLConnection) new URL(we.getAttribute("href")).openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int httpStatus = connection.getResponseCode();
			softAssert.assertTrue(httpStatus < 399,
					"The link with text \'" + we.getText() + "\' is broken. Response status=" + httpStatus);
			connection.disconnect();
		}
		softAssert.assertAll();

		driver.close();
	}

}
