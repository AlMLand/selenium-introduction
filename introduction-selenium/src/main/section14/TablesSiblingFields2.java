package main.section14;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesSiblingFields2 {

	public static void main(String[] args) {

		String expextedFruit = "Rice";

		// target: get the price of the rice
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		Optional<String> searchedPrice = driver.findElements(By.xpath("//tr//td[1]")).stream()
				.filter(we -> we.getText().equals(expextedFruit))
				.map(we -> we.findElement(By.xpath("following-sibling::td[1]")).getText()).findFirst();
		searchedPrice.ifPresent(System.out::print);
		
		driver.close();

	}

}
