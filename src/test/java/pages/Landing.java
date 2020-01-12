package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Landing extends Page {

    @FindBy(xpath = "//*[@href='https:/login']")
    private WebElement signinLink;

    @FindBy(xpath="//*[@href='https:/business/try']")
    private WebElement tryForFreeBtn;

    @FindBy(xpath="//*[contains(@href, 'plans-comparison')]")
    private WebElement comparePlansLink;

    @FindBy(xpath="//*[@id='component7883548396406774178']//nav")
    private WebElement stickyHeader;

    @FindBy(xpath="//*[@href='/business']/..")
    private WebElement logo;

    @FindBy(xpath = "//*[@aria-label='Show links']")
    private WebElement burgerMenu;

    public Login signIn() {
        try {
            click(signinLink);
        } catch (TimeoutException e) {
            click(burgerMenu);
            click(signinLink);
        }
        return new Login();
    }

    public void clickOnElement(String element) {
        switch(element.toLowerCase()) {
            case("sign in"):
                signIn();
                break;
            default:
                System.out.println("Error: this scenario is undefined");
        }
    }
}
