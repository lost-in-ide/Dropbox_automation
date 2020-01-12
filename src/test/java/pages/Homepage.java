package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends Page {

    @FindBy(xpath = "//*[contains(@class, 'account-menu')]")
    private WebElement accountMenu;

    @FindBy(xpath="//*[contains(@class, 'nav__contents')]")
    private WebElement leftPanel;


    //I don't like this workaround!
    public boolean isLoggedIn() {
        try {
            accountMenu.isDisplayed();
        } catch (StaleElementReferenceException e) {
            accountMenu.isDisplayed();
        }
        return accountMenu.isDisplayed();
}



}
