package selenium_dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		wd.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@Test
	public void test() {
		wd.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();

		List<WebElement> WE = wd.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));

		for (int i = 0; i < WE.size(); i++) {
			String val = WE.get(i).getText();
			if (val.contentEquals("Java") || val.contentEquals("Python")) {
				WE.get(i).click();
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		wd.quit();
	}
}
