package main.section2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// eclipse variable: -Dwebdriver.chrome.driver=C:\Users\morla\Desktop\java\browser_webdriver\chromedriver.exe
public class SeleniumIntroChrome {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\morla\\Desktop\\java\\browser_webdriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.oracletutorial.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();

	}

}
