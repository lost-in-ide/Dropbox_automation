package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;

import static support.TestContext.*;

public class Page {

    protected String url;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    public void click(WebElement element) {
        getWait(3).until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (WebDriverException e) {
            getExecutor().executeScript("arguments[0].click;", element);
        }
    }

    public boolean isClickable(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
        } catch (StaleElementReferenceException e) {
            getWait(3).until(ExpectedConditions.elementToBeClickable(element));
        }
       return isDisplayed(element);
    }

    public boolean isPageLoaded(WebDriver driver) {
        return (getExecutor().executeScript("return document.readyState").equals("complete"));
    }

    public void waitForPageToLoad() {
        if (! isPageLoaded(getDriver())) {
            getWait(60);
        }
    }

    //hadling popup window below:
    public void switchToNewWindow() {
        Iterator<String> iterator = getDriver().getWindowHandles().iterator();
        String newWindow = iterator.next();
        while(iterator.hasNext()) {
            newWindow = iterator.next();
        }
        getDriver().switchTo().window(newWindow);
    }

    public void fillTheField(WebElement field, String data) {
        field.sendKeys(data);
    }



}
