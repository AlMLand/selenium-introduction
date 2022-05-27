package main.section12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentSeven {

	public static void main(String[] args) {

		// number of rows(incl. header), columns and content of second row
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		long countRows = driver.findElements(By.xpath("//table[@name='courses']//tr")).stream().count();
		long countColumns = driver.findElements(By.xpath("//table[@name='courses']//th")).stream().count();
		String secondRowContent = driver.findElements(By.xpath("//table[@name='courses']//tr[3]//td")).stream()
				.map(webElement -> webElement.getText()).reduce("", (content1, content2) -> content1 + " " + content2);

		System.out.println(
				"countRows=" + countRows + ", countColumns=" + countColumns + ", secondRowContent=" + secondRowContent);
		
		driver.close();

	}

}
