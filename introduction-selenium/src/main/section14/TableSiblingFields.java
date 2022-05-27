package main.section14;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableSiblingFields {

	public static void main(String[] args) {

		String expextedFruit = "Rice";

		// target: get the price of the rice
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		List<String> fruitNames = driver.findElements(By.xpath("//tr//td[1]")).stream().map(WebElement::getText)
				.collect(Collectors.toList());
		List<String> prices = driver.findElements(By.xpath("//tr//td[2]")).stream().map(WebElement::getText)
				.collect(Collectors.toList());

		for (int index = 0; index < fruitNames.size() && index < prices.size(); index++) {
			if (fruitNames.get(index).equals(expextedFruit)) {
				System.out.println(prices.get(index));
				break;
			}
		}

		driver.close();

	}

}
