package main.section11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calender {

	public static void main(String[] args) {

		List<Long> list = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			long startTime = System.currentTimeMillis();
			testCurrentDateOfTravel();
			testIncreasedOn2DateOfTravel();
			long endTime = System.currentTimeMillis();
			list.add(endTime - startTime);
		}
		list.forEach(x -> System.out.print(x + ", "));
		
	}

	private static void testCurrentDateOfTravel() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless", "--disable-extensions", "--disable-gpu");
//		WebDriver driver = new ChromeDriver(options);
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
		// actual date, month, year
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		String availableMonthAndYear = driver
				.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText();
		Assert.assertEquals(getActualMonthAndYear(), availableMonthAndYear);
		List<WebElement> availableDays = driver
				.findElements(By.xpath("//td[starts-with(@class,'day') or starts-with(@class,'active')]"));
		String actualDay = getActualDayAsString();
		availableDays.stream().filter(calenderDay -> calenderDay.getText().equals(actualDay)).findFirst().get().click();

		driver.close();
	}

	private static void testIncreasedOn2DateOfTravel() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless", "--disable-extensions", "--disable-gpu");
//		WebDriver driver = new ChromeDriver(options);
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
		// date, month increase on 2, year on 1
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).click();
		driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='next']")).click();
		List<WebElement> availableMonths = driver.findElements(By.xpath("//span[@class='month']"));
		availableMonths.stream().filter(month -> month.getText().equals(getActualMonthIncreasedOnTwo())).findFirst()
				.get().click();
		List<WebElement> availableDays = driver
				.findElements(By.xpath("//td[starts-with(@class,'day') or starts-with(@class,'active')]"));
		availableDays.stream().filter(calenderDay -> calenderDay.getText().equals(getActualDayDateIncreasedOnTwo()))
				.findFirst().get().click();

		driver.close();
	}

	private static String getActualDayDateIncreasedOnTwo() {
		String day = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd"));
		if (day.startsWith("0")) {
			day = day.substring(1);
		}
		return day;
	}

	private static String getActualMonthIncreasedOnTwo() {
		return LocalDate.now().plusMonths(2).format(DateTimeFormatter.ofPattern("MMM", Locale.US));
	}

	private static String getActualMonthAndYear() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM yyyy", Locale.US));
	}

	private static String getActualDayAsString() {
		String actualDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));
		if (actualDay.startsWith("0")) {
			actualDay = actualDay.substring(1);
		}
		return actualDay;
	}

}
