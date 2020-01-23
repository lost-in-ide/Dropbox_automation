package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getWait;


public class Homepage extends Page {

    @FindBy(xpath = "//*[contains(@class, 'account-menu')]")
    private WebElement accountMenu;

    @FindBy(xpath="//*[contains(@class, 'nav__contents')]")
    private WebElement leftPanel;


    //I don't like this workaround!
    public boolean isLoggedIn() {
        try {
            getWait(5);
            accountMenu.isDisplayed();
        } catch (StaleElementReferenceException e) {
            accountMenu.isDisplayed();
        }
        return accountMenu.isDisplayed();
}



}
