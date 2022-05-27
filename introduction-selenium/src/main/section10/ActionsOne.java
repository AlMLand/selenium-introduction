package main.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsOne {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.com/");
		Actions actions = new Actions(driver);

		WebElement helloSignInElement = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		WebElement textBoxSearchElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
		actions.moveToElement(textBoxSearchElement).click().keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT)
				.doubleClick().build().perform();
		
		actions.moveToElement(helloSignInElement).contextClick().build().perform();
		
	}

}
