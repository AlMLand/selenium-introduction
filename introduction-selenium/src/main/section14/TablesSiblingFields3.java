package main.section14;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TablesSiblingFields3 {

	public static void main(String[] args) {

		String expextedFruit = "Rice";

		// target: get the price of the rice
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.xpath("//th[@aria-sort='descending']"))).build().perform();
		WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next']"));

		Optional<String> searchedValue = Optional.empty();
		while (searchedValue.isEmpty()) {
			searchedValue = driver.findElements(By.xpath("//td[1]")).stream()
					.filter(webElement -> webElement.getText().equals(expextedFruit))
					.map(webElement -> webElement.findElement(By.xpath("following-sibling::td[1]")).getText())
					.findAny();
			if (searchedValue.isEmpty()) {
				try {
					nextButton.click();
					// when the button 'Next' is not more active
				} catch (ElementClickInterceptedException e) {
					System.out.println("\'" + expextedFruit + "\' is not present.");
					break;
				}
			}
		}

		if (searchedValue.isPresent()) {
			System.out.println("The price from \'" + expextedFruit + "\' is " + searchedValue.get() + " €");
		}

		driver.close();

	}

}
