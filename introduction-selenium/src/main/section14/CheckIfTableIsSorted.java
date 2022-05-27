package main.section14;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckIfTableIsSorted {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		Select select = new Select(driver.findElement(By.xpath("//select[@id='page-menu']")));
		List<WebElement> selectVariables = select.getAllSelectedOptions();
		selectVariables.get(selectVariables.size() - 1).click();
		
		List<String> columnContentBefore = driver.findElements(By.xpath("//tbody//tr//td[1]")).stream()
				.map(webElement -> webElement.getText()).collect(Collectors.toList());
		List<String> sortedColumnContextBefore = columnContentBefore.stream().sorted().collect(Collectors.toList());
		Assert.assertFalse(columnContentBefore.equals(sortedColumnContextBefore));
		
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.xpath("//th[@aria-sort='descending']"))).build().perform();
		List<String> columnContentAfter = driver.findElements(By.xpath("//tbody//tr//td[1]")).stream()
				.map(webElement -> webElement.getText()).collect(Collectors.toList());
		List<String> sortedColumnContextAfter = columnContentAfter.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(columnContentAfter.equals(sortedColumnContextAfter));
		
		driver.close();

	}

}
