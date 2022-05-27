package main.section14;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TableSearchInputValidation {

	public static void main(String[] args) {

		int expectedTableRows = 1;
		String expectedFruit = "Rice";
		String expectedPrice = "37";
		String expectedDiscountPrice = "46";

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		Actions actions = new Actions(driver);
		actions.sendKeys(driver.findElement(By.xpath("//input[@id='search-field']")), expectedFruit).build().perform();

		List<WebElement> firstTableColumn = driver.findElements(By.xpath("//tr//td[1]"));
		
		assertEquals(firstTableColumn.size(), expectedTableRows);
		assertEquals(firstTableColumn.get(0).getText(), expectedFruit);
		assertEquals(firstTableColumn.get(0).findElement(By.xpath("following-sibling::td[1]")).getText(), expectedPrice);
		assertEquals(firstTableColumn.get(0).findElement(By.xpath("following-sibling::td[2]")).getText(), expectedDiscountPrice);

		driver.close();

	}

}
