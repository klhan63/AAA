package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static tests.Base.pFlag;

public class basePage {

    protected WebDriver driver;
 
    public basePage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void visit(String url) {
        try {
            driver.get(url);
            if (pFlag) System.out.println("Successful URL connection!");
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with visit: " + url + "\nReceived general exception: \n***" + e.getLocalizedMessage()+"\n***\n");
        }
    }
 
    public WebElement find(By locator) throws Exception {
        try {
            if (isPresent(locator,10)) { //(isElementPresent(locator)) {
                if (pFlag) System.out.println("Found locator: " + locator.toString());
                return driver.findElement(locator);
            } else {
                if (pFlag) System.out.println("**ERROR** - Could not find locator: " + locator.toString());
                return null;                
            }
        } catch (WebDriverException e1){
            if (pFlag) System.out.println("**ERROR** - WebDriverException with find: " + locator.toString() + "\nReceived exception: \n***"
                    + e1.getLocalizedMessage() + "\n***\n");
            return null;
//      } catch (StaleElementReferenceException  e2) {
//          if (pFlag) System.out.println("**ERROR** - StaleElementReferenceException with find: " + locator.toString() + "\nReceived general exception: \n***"
//                  + e2.getLocalizedMessage() + "\n***\n");
//          return null;
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with find: " + locator.toString() + "\nReceived general exception: \n***"
                    + e.getLocalizedMessage() + "\n***\n");
            return null;
        }
    }
 
    public List<WebElement> findList(By locator) {
        try {
            if (isPresent(locator,10)) {
                if (pFlag) System.out.println("Found locator: " + locator.toString());
                return driver.findElements(locator);
            } else {
                if (pFlag) System.out.println("**ERROR** - Could not find locator: " + locator.toString());
                return null;                
            }
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with find: " + locator.toString() + "\nReceived general exception: \n***"
                    + e.getLocalizedMessage() + "\n***\n");
            return null;
        }
    }
     
    public Boolean getTitle(String name) {
        try {
            //if (pFlag) System.out.println(driver.getTitle());
            if (driver.getTitle().trim().contains(name.trim())) {
                if (pFlag) System.out.println("Successful retrieval of title " + name);
                return true;
            } else {
                if (pFlag) System.out.println("**ERROR** - Unsuccessful retrieval of title " + name);
                return false;       
            }
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with getTitle: " + name + "\nReceived general exception: \n***" + e.getLocalizedMessage() + "\n***\n");
            return false;
        }
    }
 
    public String getStringValue(By locator) throws Exception {
        try {
            if (isElementPresent(locator)) {
                if (pFlag) System.out.println("Retrieved string value " + find(locator).getText().trim());
                return find(locator).getText().trim();
            } else {
                if (pFlag) System.out.println("**ERROR** - Could not retrieve string value for locator " + locator.toString());
                return "";      
            }
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with getStringValue: " + locator.toString() + "\nReceived general exception: \n***"
                    + e.getLocalizedMessage() + "\n***\n");
            return "";
        }
    }
 
    public int getIntegerValue(By locator) throws Exception {
        try {
            if (isElementPresent(locator)) {
                if (pFlag) System.out.println("Retrieved integer value " + Integer.parseInt(getStringValue(locator)));
                return Integer.parseInt(getStringValue(locator));
            } else {
                if (pFlag) System.out.println("Could not retrieve integer value for locator: " + locator.toString());
                return -1;      
            }
        }catch (NumberFormatException e) {
            if (pFlag) System.out.println("**ERROR** - Number Format Exception error with locator " + locator.toString());
            return -1;
        } catch (Exception e1) {
            if (pFlag) System.out.println("**ERROR** - Exception with getIntegerValue: " + locator.toString() + "\nReceived general exception: \n***"
                    + e1.getLocalizedMessage() + "\n***\n");
            return -1;
        }
    }
 
    public void click(By locator) {
        try {
            if (isElementPresent(locator)) {
                find(locator).click();
                if (pFlag) System.out.println("Clicked locator: " + locator.toString());
            } else {
                if (pFlag) System.out.println("Could not click locator: " + locator.toString());
            }
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with click: " + locator.toString() + "\nReceived general exception: \n***"
                    + e.getLocalizedMessage() + "\n***\n");
        }
    }
 
    public void check(By locator) {
        try {
            //if ((isElementPresent(locator)) && (find(locator).isSelected())) {
            if (!find(locator).isSelected()) {
                click(locator);
                if (pFlag) System.out.println("Checked locator: " + locator.toString());
            } else {
                if (pFlag) System.out.println("Locator already checked: " + locator.toString());
            }
        } catch (ElementNotSelectableException e) {
            if (pFlag) System.out.println("**ERROR** - Element Not Selectable Exception - for locator: " + locator.toString());
        } catch (Exception e1) {
            if (pFlag) System.out.println("**ERROR** - Exception with check: " + locator.toString() + "\nReceived general exception: \n***"
                    + e1.getLocalizedMessage() + "\n***\n");
        }
    }
 
    public void uncheck(By locator) {
        try {
            if (find(locator).isSelected()) {
                click(locator);
                if (pFlag) System.out.println("Unchecked locator: " + locator.toString());
            } else {
                if (pFlag) System.out.println("Locator already unchecked: " + locator.toString());
            }
        } catch (ElementNotSelectableException e) {
            if (pFlag) System.out.println("**ERROR** - Element Not Selectable Exception - for locator: " + locator.toString());
        } catch (Exception e1) {
            if (pFlag) System.out.println("**ERROR** - Exception with uncheck: " + locator.toString() + "\nReceived general exception: \n***"
                    + e1.getLocalizedMessage() + "\n***\n");
        }
    }
 
    public void clearField(By locator) {
        try {
            if (isElementPresent(locator)) {
                find(locator).clear();
                if (pFlag) System.out.println("Cleared field locator: " + locator.toString());
            }
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with clearField: " + locator.toString() + "\nReceived general exception: \n*** "
                    + e.getLocalizedMessage() + "\n***\n");
        }
    }
 
    public void type(String value, By locator) {
        try {
            if (isElementPresent(locator)) {
                find(locator).sendKeys(value);
                if (pFlag) System.out.println("Typed value " + value + " into field locator: " + locator.toString());
            } else {
                if (pFlag) System.out.println("Could not type value " + value + " into field locator: " + locator.toString());
            }
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with locator: " + locator.toString() + "\nReceived general exception: \n***"
                    + e.getLocalizedMessage() + "\n***\n");
        }
    }
     
    public void selectWithValue(String name, String option) {
    	WebElement element = driver.findElement(By.id(name));
    	Select oSelect = new Select(element);
    	oSelect.selectByValue(option);
    }
    
    public void selectByVisibleText(String name, String option) {
    	WebElement element = driver.findElement(By.id(name));
    	Select oSelect = new Select(element);
    	oSelect.selectByVisibleText(option);
    }
     
    public void selectNoId(By locator, String option) {
        WebElement dropdownList = driver.findElement(locator);
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            String xx = options.get(i).getText();
            if (xx.equals(option)) {
                options.get(i).click();
                break;
            }
        }
 
    }
 
    public void pressEnter(By locator) {
        try {
            if (isElementPresent(locator)) {
                find(locator).sendKeys("\n");
                if (pFlag) System.out.println("Hit enter on locator " + locator.toString());
            } else {
                if (pFlag) System.out.println("Could not hit enter on locator " + locator.toString());
            }
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with locator: " + locator.toString() + "\nReceived general exception: \n***"
                    + e.getLocalizedMessage() + "\n***\n");
        }
    }
    public Boolean isChecked(By locator) throws Exception {
        if (isVisible(locator,5)){
            WebElement checked = find(locator); 
            return Boolean.valueOf(checked.getAttribute("checked"));
        }
        return false;
    }
     
    public Boolean isVisible(By locator, Integer timeout) throws Exception {
        try {
                WebDriverWait wait = new WebDriverWait(driver, timeout);
                wait.ignoring(StaleElementReferenceException.class);
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
                return true;    
        } catch (TimeoutException e) {
            if (pFlag) System.out.println("**ERROR** - Timeout Exception with locator: " + locator.toString());
            return false;
        } catch (Exception e1) {
            if (pFlag) System.out.println("**ERROR** - Exception with locator: " + locator.toString() + "\nReceived general exception: \n***"
                    + e1.getLocalizedMessage() + "\n***\n");
            return false;
        }
    }
 
    public Boolean isClickable(By locator, Integer timeout) throws Exception {
        try {
                WebDriverWait wait = new WebDriverWait(driver, timeout);
                wait.ignoring(StaleElementReferenceException.class);
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
                return true;
        } catch (TimeoutException e) {
            if (pFlag) System.out.println("**ERROR** - Timeout Exception with locator: " + locator.toString());
            return false;
        } catch (Exception e1) {
            if (pFlag) System.out.println("**ERROR** - Exception with locator: " + locator.toString() + "\nReceived general exception: \n***"
                    + e1.getLocalizedMessage() + "\n***\n");
            return false;
        }
    }
 
    public Boolean isPresent(By locator, Integer timeout) {
        try {
                WebDriverWait wait = new WebDriverWait(driver, timeout);
                wait.ignoring(StaleElementReferenceException.class);
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(locator)));
                if (pFlag) System.out.println("Locator: " + locator.toString() + " is present.");
                return true;    
        } catch (TimeoutException e) {
            if (pFlag) System.out.println("**ERROR** - Timeout Exception with locator: " + locator.toString());
            return false;
        } catch (NoSuchElementException e1) {
            if (pFlag) System.out.println("**ERROR** - No Such Element Excepton with Locator: " + locator);
            return false;
        } catch (Exception e2) {
            if (pFlag) System.out.println("**ERROR** - Exception with locator: " + locator.toString() + "\nReceived general exception: \n***"
                    + e2.getLocalizedMessage() + "\n***\n");
            return false;
        }
    }
 
    public Boolean isElementPresent(By locator) {
        try {
            if (driver.findElements(locator).size() != 0) {
                if (pFlag) System.out.println("Locator: " + locator + " is present");
                return true;
            } else {
                if (pFlag) System.out.println("**ERROR** - Locator: " + locator + " was not present");
                return false;
            }
        } catch (NoSuchElementException e) {
            if (pFlag) System.out.println("**ERROR** - No Such Element Excepton with Locator: " + locator);
            return false;
        } catch (StaleElementReferenceException  e2) {
            if (pFlag) System.out.println("**ERROR** - StaleElementReferenceException with find: " + locator.toString() + "\nReceived exception: \n***"
                    + e2.getLocalizedMessage() + "\n***\n");
            return null;
        } catch (Exception e1) {
            if (pFlag) System.out.println("**ERROR** - Exception with locator: " + locator.toString() + "\nReceived general exception: \n***"
                    + e1.getLocalizedMessage() + "\n***\n");
            return false;
        }
    }
     
    public Boolean isElementSelected(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeSelected(locator)));
            if (pFlag) System.out.println("Locator: " + locator.toString() + " is selected.");
            return true;    
        } catch (NoSuchElementException e) {
            if (pFlag) System.out.println("**ERROR** - No Such Element Excepton with Locator: " + locator);
        } catch (Exception e1) {
            if (pFlag) System.out.println("**ERROR** - Exception with locator: " + locator.toString() + "\nReceived general exception: \n***"
                    + e1.getLocalizedMessage() + "\n***\n");
        }
        return false;
    }
 
    public Boolean isAlertPresent() {
        //if alert is present it will close it out and return true otherwise it returns false.
        try {
            driver.switchTo().alert().accept();
            if (pFlag) System.out.println("Alert is present");
            return true;
        } catch (NoAlertPresentException e) {
            if (pFlag) System.out.println("No alert present");
            return false;
        } catch (Exception e1) {
            if (pFlag) System.out.println("**ERROR** - Exception with alert check.\nReceived general exception: \n***" + e1.getLocalizedMessage() + "\n***\n");
            return false;
        }
    }
     
     
// Misc public functions for POM's
    public String padOnRight(String value, int length) {
        String spaces = "";
        for (int i=0; i<length+1; i++) {
            spaces = spaces + " ";
        }
        value = value + spaces;
        value = value.substring(0, length);
        return value;
    }
     
    public void scrollPage(By locator){
        try {
            WebElement element = find(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            if (pFlag) System.out.println("Alert is present");
        } catch (Exception e) {
            if (pFlag) System.out.println("**ERROR** - Exception with scrolling.\nReceived general exception: \n***" + e.getLocalizedMessage() + "\n***\n");
        }
    }
     
    public int getWindowsCount() {
        int count;
        Object[] allWindows = driver.getWindowHandles().toArray();
        count = allWindows.length;
        return count;
    }
     
    public void goToLastWindowOrTab() {
        ArrayList<String> tabWindow = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabWindow.get(tabWindow.size()-1));
        
    }
}