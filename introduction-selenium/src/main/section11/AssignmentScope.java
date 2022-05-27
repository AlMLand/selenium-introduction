package main.section11;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssignmentScope {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> dropdownElements = driver
				.findElements(By.xpath("//select[@id='dropdown-class-example']//option"));
		for (WebElement webElement : driver.findElements(By.xpath("//div[@id='checkbox-example']//label"))) {
			String checkboxMessage = webElement.getText();
			webElement.click();
			Optional<WebElement> equalsElement = dropdownElements.parallelStream()
					.filter(dr -> dr.getText().equals(checkboxMessage)).findFirst();
			if (equalsElement.isPresent()) {
				String dropdownMessage = equalsElement.get().getText();
				Assert.assertEquals(checkboxMessage, dropdownMessage);
				equalsElement.get().click();
			}
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(checkboxMessage);
			driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

			Alert alert = driver.switchTo().alert();
			Optional<String> alertMessage = List.of(alert.getText().split("\\W|\\s")).parallelStream()
					.filter(word -> word.equals(checkboxMessage)).findFirst();
			Assert.assertEquals(alertMessage.orElseThrow(), checkboxMessage);
			alert.accept();
		}

		driver.close();

	}

}
