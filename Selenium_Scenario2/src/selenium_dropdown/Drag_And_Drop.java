package selenium_dropdown;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_And_Drop {

	WebDriver wd;
	String url = "https://www.jqueryui.com/droppable";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Certification Data\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get(url);
		wd.manage().window().maximize();
	}

	@Test
	public void test() {

		wd.switchTo().frame(0);
		
		// WebElement on which drag and drop operation needs to be performed
		WebElement fromElement = wd.findElement(By.id("draggable"));

		// WebElement to which the above object is dropped
		WebElement toElement = wd.findElement(By.id("droppable"));

		// Creating object of Actions class to build composite actions
		Actions builder = new Actions(wd);

		builder.dragAndDrop(fromElement, toElement).perform();

		String afterDragging =  wd.findElement(By.id("droppable")).getText();

		if (afterDragging.equals("Dropped!")) {
			System.out.println("PASS: File is dropped to target as expected");
		} else {
			System.out.println("FAIL: File couldn't be dropped to target as expected");
		}
	}

	@After
	public void tearDown() throws Exception {
		wd.quit();
	}
}
