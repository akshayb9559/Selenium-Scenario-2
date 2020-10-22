package selenium_dropdown;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown_And_ImplicitWait {

	WebDriver wd;
	String url = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Certification Data\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get(url);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		wd.findElement(By.className("multiselect-selected-text")).click();

		// Select jQuery value from Dropdown
		wd.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul/li[2]/a/label")).click();

		// Select Java value from Dropdown
		wd.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul/li[8]/a/label")).click();

		// Select MySql value from Dropdown
		wd.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul/li[12]/a/label")).click();

		// Select Oracle value from Dropdown
		wd.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul/li[13]/a/label")).click();

		// Click on Blank Space
		wd.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]")).click();
	}

	@After
	public void tearDown() throws Exception {
		wd.quit();
	}
}
