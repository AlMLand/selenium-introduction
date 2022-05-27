package main.section15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		
		WebElement nameInput = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		                                                         // element kororij ischem //element OT kotorogo ischem
		String message = driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameInput)).getText();
		System.out.println(message);

		
		WebElement birthDateLabel = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		// perwij input tag budet protuschen, tak kak on flex; poetomu buden najden wtoroj input - input button submit
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(birthDateLabel)).click();
		
		
		WebElement checkBoxLabel = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(checkBoxLabel)).click();

		
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		String checkBoxMessage = driver.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(checkBox)).getText();
		System.out.println(checkBoxMessage);
		
		driver.close();

	}

}
