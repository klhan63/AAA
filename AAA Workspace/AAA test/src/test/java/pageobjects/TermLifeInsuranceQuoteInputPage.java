package pageobjects;

import static org.junit.Assert.assertTrue;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static tests.Base.pFlag;

public class TermLifeInsuranceQuoteInputPage extends basePage {

	// VARIABLES
	
	By txtZipCodeLocator = By.id("zip");
	By ddGenderLocator = By.id("gender");
	By ddDOBMonthLocator = By.id("month");
	By ddDOBDayLocator = By.id("day");
	By ddDOBYearLocator = By.id("year");
	By rbMemberYLocator = By.id("isMemberYes");
	By rbMemberNLocator = By.id("isMemberNo");
	By txtEmailLocator = By.id("contact_email");
	By ddHeightFtLocator = By.id("feet");
	By ddHeightInLocator = By.id("inches");
	By txtWeightLocator = By.id("weight");
	By rbNicotineYLocator = By.id("nicotineUseYes");
	By rbNicotineNLocator = By.id("nicotineUseNo");
	By ddHealthRateLocator = By.id("rateYourHealth");
	By ddCoverageAmtLocator = By.id("coverageAmount");
//	By ddCoverageAmtLocator = By.xpath("//*[@id=\"coverageAmount\"]");
	By ddTermLocator = By.id("termLength");
	By btnSeeYourQuoteLocator = By.id("seeQuote");
	By lnkEditLocator = By.xpath("/html/body/div[7]/div[1]/div/div[2]/div/div[1]/div[1]/a");
	

	// CONSTRUCTORS
	public TermLifeInsuranceQuoteInputPage(WebDriver driver) {
		super(driver);
		assertTrue("Term Life Insurance Quote Input did not load successfully", validateAAAPageLoad());
	}
	
	// FIELD METHODS
	public void typeZipCode(String zip) throws Exception {
		try {
            if (isClickable(txtZipCodeLocator, 10)) {
                clearField(txtZipCodeLocator);
                type(zip, txtZipCodeLocator);
                if (pFlag) System.out.println("Entered Zip Code");
            }
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Cannot enter Zip Code");
        }
	}
	
	public void selectGender(String gender) throws Exception {
        try {
            if (isClickable(ddGenderLocator, 10)) {
                selectByVisibleText("gender",gender);
                if (pFlag) System.out.println("Selected gender " + gender);
            }
        } catch (Exception e) {
        	if (pFlag) System.out.println("**ERROR** - Did not select gender " + gender);
        }
    }
	 
	public void selectDOBMonth(String month) throws Exception {
    	try {
            if (isClickable(ddDOBMonthLocator, 10)) {
            	selectByVisibleText("month", month);
                if (pFlag) System.out.println("Selected month " + month);
            }
        } catch (Exception e) {
        	if (pFlag) System.out.println("**ERROR** - Did not select month " + month);
        }
    }
	 
	public void selectDOBDay(String day) throws Exception {
    	try {
            if (isClickable(ddDOBDayLocator, 10)) {
            	selectByVisibleText("day", day);
                if (pFlag) System.out.println("Selected day " + day);
            }
        } catch (Exception e) {
        	if (pFlag) System.out.println("**ERROR** - Did not select day " + day);
        }
    }
	 
	public void selectDOBYear(String year) throws Exception{
		try {
            if (isClickable(ddDOBYearLocator, 10)) {
            	selectByVisibleText("year", year);
                if (pFlag) System.out.println("Selected year " + year);
            }
        } catch (Exception e) {
        	if (pFlag) System.out.println("**ERROR** - Did not select year " + year);
        }
    }

	public void chooseMemberY(Boolean member) throws Exception {
		try {
			if (member) {
            	check(rbMemberYLocator);
				if (pFlag) System.out.println("Selected Member Yes");
            } else {
            	check(rbMemberNLocator);
            	if (pFlag) System.out.println("Selected Member No");
            }
        } catch (Exception e) {
        	if (pFlag) System.out.println("**ERROR** - Did not select Member Yes or No");
        }
	}
	
	public void typeEmail(String email) throws Exception{
	 try {
            if (isClickable(txtEmailLocator, 10)) {
                clearField(txtEmailLocator);
            	type(email, txtEmailLocator);
                if (pFlag) System.out.println("Typed email " + email);
            }
        } catch (Exception e) {
        	if (pFlag) System.out.println("**ERROR** - Did not type " + email);
        }
    }
	 
	public void selectHeightFt(String feet) throws Exception {
	    	try {
	            if (isClickable(ddHeightFtLocator, 10)) {
	                selectWithValue("feet",feet);
	                if (pFlag) System.out.println("Selected height feet " + feet);
	            }
	        } catch (Exception e) {
	        	if (pFlag) System.out.println("**ERROR** - Did not select height feet " + feet);
	        }
	    }
	 
	public void selectHeightIn(String inches) throws Exception {
	    	try {
	            if (isClickable(ddHeightInLocator, 10)) {
	            	selectWithValue("inches",inches);
	                if (pFlag) System.out.println("Selected height inches " + inches);
	            }
	        } catch (Exception e) {
	        	if (pFlag) System.out.println("**ERROR** - Did not select height inches " + inches);
	        }
	    }
	 
	public void typeWeight(String weight) throws Exception {
		try {
			if (isClickable(txtWeightLocator, 10)) {
				clearField(txtWeightLocator);
			    type(weight, txtWeightLocator);
			    if (pFlag) System.out.println("Typed weight " + weight);
			}
		} catch (Exception e) {
			if (pFlag) System.out.println("**ERROR** - Did not type weight " + weight);
	    }
	}

	public void chooseNicotine(Boolean nicotine) throws Exception {
		try {
			if (nicotine) {
            	check(rbNicotineYLocator);
				if (pFlag) System.out.println("Selected Nicotine Yes");
            } else {
            	check(rbNicotineNLocator);
            	if (pFlag) System.out.println("Selected Nicotine No");
            }
        } catch (Exception e) {
        	if (pFlag) System.out.println("**ERROR** - Did not select Nicotine Yes or No");
        }	
	}
	
	public void selectHealthRate(String rate) throws Exception {
		try {
			if (isClickable(ddHealthRateLocator, 10)) {
				selectByVisibleText("rateYourHealth",rate);
			    if (pFlag) System.out.println("Selected health rate " + rate);
			}
		} catch (Exception e) {
			if (pFlag) System.out.println("**ERROR** - Did not select health rate " + rate);
	    }
	}
	
	public void selectCoverage(String coverage) throws Exception {
		try {
			if (isClickable(ddCoverageAmtLocator, 10)) {
				selectWithValue("coverageAmount",coverage);
			    if (pFlag) System.out.println("Selected coverage amount " + coverage);
			}
		} catch (Exception e) {
			if (pFlag) System.out.println("**ERROR** - Did not select coverage amount " + coverage);
	    }
	}
	
	public void selectTerm(String term) throws Exception {
		try {
			if (isClickable(ddTermLocator, 10)) {
			    selectWithValue("termLength", term);
			    if (pFlag) System.out.println("Selected Term Length " + term);
			}
		} catch (Exception e) {
			if (pFlag) System.out.println("**ERROR** - Did not select Term Length " + term);
	    }
	}

	public void clickSeeYourQuote() throws Exception {
		try {
			if (isClickable(btnSeeYourQuoteLocator, 10)) {
			    click(btnSeeYourQuoteLocator);
			    if (pFlag) System.out.println("See Your Quote Locator button was clicked");
			}
		} catch (Exception e) {
			if (pFlag) System.out.println("**ERROR** - See Your Quote Locator button was NOT clicked");
	    }
	}
	
	public void clickEditLink() throws Exception {
		try {
			if (isClickable(lnkEditLocator, 10)) {
			    click(lnkEditLocator);
			    if (pFlag) System.out.println("Edit link was clicked");
			}
		} catch (Exception e) {
			if (pFlag) System.out.println("**ERROR** - Edit link was NOT clicked");
	    }
	}
	
	
	// GENERAL METHODS TO PERFORM SPECIFIC ACTIONS

	public void getCurrentIframeFocus() {
        goToLastWindowOrTab();
        driver.switchTo().frame(0);
    }
	
	public QuoteResultsPage enterScenario(Row TC) throws Exception {
		Boolean MFlag = false;
		Boolean NFlag = false;
		
		typeZipCode(TC.getCell(1).toString());
		selectGender(TC.getCell(2).toString());
		selectDOBMonth(TC.getCell(3).toString());
		selectDOBDay(TC.getCell(4).toString());
		selectDOBYear(TC.getCell(5).toString());
		
		if (TC.getCell(6).toString().equals("True")) MFlag = true;
		chooseMemberY(MFlag);
		typeEmail(TC.getCell(7).toString());
		selectHeightFt(TC.getCell(8).toString());
		selectHeightIn(TC.getCell(9).toString());
		typeWeight(TC.getCell(10).toString());
		
		if (TC.getCell(11).toString().equals("True")) NFlag = true;
		chooseNicotine(NFlag);
		if (isVisible(ddHealthRateLocator,5)) {
			selectHealthRate(TC.getCell(14).toString());
		}
		
		selectCoverage(TC.getCell(12).toString());
		selectTerm(TC.getCell(13).toString());
		
		clickSeeYourQuote();
		return new QuoteResultsPage(driver);
	}
	
	// VALIDATION METHODS
	 public Boolean validateAAAPageLoad()  {
        if (getTitle("Term Life Insurance Quote Input")) {
        	if (pFlag) System.out.println("Term Life Insurance Quote Input page is present");
            return true;
        }
        if (pFlag) System.out.println("**ERROR** - Term Life Insurance Quote Input page is NOT present");
        return false;
	 }
	 
	 public Boolean validateZip(String zip) {
		 Boolean flag = true;
		 if (zip.length()>10  || zip.length()<5) flag = false;
		 return flag;
	 }
}
