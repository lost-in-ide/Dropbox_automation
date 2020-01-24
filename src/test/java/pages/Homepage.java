package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getWait;


public class Homepage extends Page {

    @FindBy(xpath = "//*[contains(@class, 'account-menu')]")
    private WebElement accountMenu;

    @FindBy(xpath="//*[contains(@class, 'nav__contents')]")
    private WebElement leftPanel;


    public boolean isLoggedIn() {
        getWait(3).until(ExpectedConditions.stalenessOf(accountMenu));
        return accountMenu.isDisplayed();
}



}
