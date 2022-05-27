package main.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameOne {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");

		// switch to another frame first variant
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		// switch to another frame second variant (index -> 0)
//		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='draggable']//p")).click();

		Actions actions = new Actions(driver);
		actions.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")),
				driver.findElement(By.xpath("//div[@id='droppable']"))).build().perform();

		// switch back to the main frame
		driver.switchTo().defaultContent().findElement(By.xpath("//a[contains(text(),'Resizable')]")).click();

		driver.quit();

	}

}
