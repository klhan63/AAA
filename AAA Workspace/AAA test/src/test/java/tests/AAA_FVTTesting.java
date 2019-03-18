package tests;

import static org.junit.Assert.assertTrue;

import org.apache.poi.ss.usermodel.Row;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageobjects.basePage;
import pageobjects.TermLifeInsuranceQuoteInputPage;
import pageobjects.QuoteResultsPage;
import tests.Base;
//import utilities.ReadExcelFile;

public class AAA_FVTTesting extends Base {
	TermLifeInsuranceQuoteInputPage tliqi;
	QuoteResultsPage QuoteResultsPage;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"//Vendor//chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
        co.addArguments("--start-maximized"); //used for maximizing screen
        driver=new ChromeDriver(co);
        
        basePage bp = new basePage(driver);
        bp.visit(baseURL);
        tliqi = new TermLifeInsuranceQuoteInputPage(driver);
	}
	
	@Test
	public void FVT_Testing() throws Exception {
		Row r1;
		// read in test case scenarios
		for (int x=1; x <= 5; x++) {
			r1 = getCredentials(Integer.toString(x));
			QuoteResultsPage = tliqi.enterScenario(r1);
			assertTrue("Quote was not created successfully",QuoteResultsPage.validateQRPageLoad());
			QuoteResultsPage.clickClose();
			// Can add any additional validations here for the test case scenario
			// for instance to compare values on the screen to a datasource's expected values.
			QuoteResultsPage.clickBack();
		}
	}
	
	@After
	public void tearDown() throws Exception {
		closeExcel();
		driver.quit();
	}
}


