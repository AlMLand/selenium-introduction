package main.section13;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		
		// more from documentation: https://chromedriver.chromium.org/capabilities
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setCapability("proxy", new Proxy().setHttpProxy("ipaddress:7777"));
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());

	}

}
