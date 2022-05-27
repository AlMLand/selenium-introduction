package main.section2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// eclipse variable: -Dwebdriver.gecko.driver=C:\Users\morla\Desktop\java\browser_webdriver\geckodriver.exe
public class SeleniumIntroFirefox {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\morla\\Desktop\\java\\browser_webdriver\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.oracletutorial.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
//		driver.close();
		driver.quit();

	}

}
