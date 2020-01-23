package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getData;
import static support.TestContext.getWait;

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

//    @FindBy(xpath = "//*[@id='submit_approve_access']")
//    private WebElement allowAccessBtn;
//
//    @FindBy(xpath = "//*[@id='submit_deny_access']")
//    private WebElement cancelBtn;


    @FindBy(xpath = "//*[@id='regular-login-forms']")
    private WebElement loginForm;

    @FindBy(xpath = "//*[@name='login_password']")
    private WebElement verifyPassword;

    @FindBy(xpath = "//*[contains(@class, 'signin-button')]")
    private WebElement signInBtn;

    public void googleSignIn() {
        fillTheField(emailField, getData("login").get("email"));
        click(emailNextBtn);
        fillTheField(passwordField, getData("login").get("googlePassword"));
        click(passwordNextBtn);
        switchToDefaultWindow();
        //wait (or page refresh) needed here
        fillTheField(verifyPassword, getData("login").get("password"));
        click(signInBtn);
    }




}
