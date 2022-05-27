package main.section2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

// eclipse variable: 
public class SeleniumIntroEdge {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\morla\\Desktop\\java\\browser_webdriver\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.oracletutorial.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();

	}

}
