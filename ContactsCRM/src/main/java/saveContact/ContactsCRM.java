package saveContact;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ContactsCRM {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/");
		driver.findElement(By.name("username")).sendKeys("kvs0594");
		driver.findElement(By.name("password")).sendKeys("Incorrect003@");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Contacts']"))).build().perform();
		driver.findElement(By.xpath("//a[@title='New Contact']")).click();
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText("Mr.");
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("First Name");
		driver.findElement(By.xpath("//input[@id='middle_initial']")).sendKeys("Middle name");
		driver.findElement(By.xpath("//input[@id='surname']")).sendKeys("Last Name");
		driver.findElement(By.xpath(
				"//input[@value='Save and Create Another (same company)']//preceding-sibling::input[@value='Save']"))
				.click();
	}
}
