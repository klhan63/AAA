package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",  
				System.getProperty("user.dir")+"//Vendor//chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void test() {
		driver.get("https://www.aaalife.com/term-life-insurance-quote-input");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
