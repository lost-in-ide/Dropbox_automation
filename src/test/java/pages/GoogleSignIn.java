package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;
import static support.TestContext.getData;

public class GoogleSignIn extends Page {

    @FindBy(xpath="//input[@id='identifierId']")
    private WebElement emailField;

    @FindBy(xpath="//*[@id='identifierNext']")
    private WebElement emailNextBtn;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath="//*[@id='passwordNext']")
    private WebElement passwordNextBtn;

    @FindBy(xpath = "//*[@id='headingText']")
    private WebElement accessMessage;

    @FindBy(xpath = "//*[@class='auth-google button-primary']")
    private WebElement googleSignInBtn;

    @FindBy(xpath = "//*[@id='submit_approve_access']")
    private WebElement allowAccessBtn;

    @FindBy(xpath = "//*[@id='submit_deny_access']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[@id='profileIdentifier']")
    private WebElement account;

    @FindBy(xpath = "//*[@id='regular-login-forms']")
    private WebElement loginForm;

    @FindBy(xpath = "//*[contains(@class, 'signin-button')]")
    private WebElement signInBtn;


    public Login googleSignIn() {
        fillTheField(emailField, getData("login").get("email"));
        click(emailNextBtn);
        fillTheField(passwordField, getData("login").get("googlePassword"));
        click(passwordNextBtn);
        try {
            assertTrue(account.getAttribute("data-email").contains(getData("login").get("email")));
            click(account);
        } catch (Exception e) {
            switchToNewWindow();
        }
        switchToDefaultWindow();
        return new Login();

    }
}
