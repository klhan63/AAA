package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static tests.Base.pFlag;

public class QuoteResultsPage extends basePage {

	// VARIABLES
	By btnCloseLocator = By.id("closeButton");
	By btnBackLocator = By.xpath("/html/body/div[6]/div[1]/div/div[2]/div/div[1]/div[1]/a");
	
	// CONSTRUCTORS
	public QuoteResultsPage(WebDriver driver) {
		super(driver);
		assertTrue("Could not load Quote Result Page successfully",validateQRPageLoad());
	}
	
	
	// FIELD METHODS
	public void clickClose() {
		try {
			By frameLocator = By.id("IPerceptionsEmbed");
			
			if (isVisible(frameLocator,5)) {
				WebElement popFrame = find(frameLocator);
				driver.switchTo().frame(popFrame);
				if (isClickable(btnCloseLocator, 10)) {
				    click(btnCloseLocator);
				    if (pFlag) System.out.println("Close button clicked");
				}
			}
		} catch (Exception e) {
			if (pFlag) System.out.println("**ERROR** - Close button was NOT clicked");
	    }
	}
	
	public void clickBack() {
		try {
			if (isClickable(btnBackLocator, 10)) {
			    click(btnBackLocator);
			    if (pFlag) System.out.println("Back button clicked");
			}
		} catch (Exception e) {
			if (pFlag) System.out.println("**ERROR** - Back button was NOT clicked");
	    }
	}
	
	// VALIDATION METHODS
	public Boolean validateQRPageLoad() {
		Boolean flag = false;
		if (getTitle("Life Insurance Quote - See Your Results | AAA Life Insurance Company")) {
        	if (pFlag) System.out.println("Life Insurance Quote - See Your Results | AAA Life Insurance Company page is present");
        	flag = true;
        } else {
        	if (pFlag) System.out.println("**ERROR** - Life Insurance Quote - See Your Results | AAA Life Insurance Company page is NOT present");
        }
		
		return flag;
	}
	
}
