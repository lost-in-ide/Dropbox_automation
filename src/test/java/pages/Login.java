package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static support.TestContext.getData;

public class Login extends Page {

    @FindBy(xpath = "//*[contains(@href, '/downloading')]")
    private WebElement downloadAppLink;

    @FindBy(xpath = "//*[@href='/business']/..")
    private WebElement createAccountLink;

    @FindBy(xpath = "//*[@class='auth-google button-primary']")
    private WebElement googleSignInBtn;

    @FindBy(xpath = "//*[@class='auth-apple button-primary']")
    private WebElement appleSignInBtn;

    @FindBy(xpath = "//*[contains(@id, 'login_email')]")
    private WebElement emailTextField;

    @FindBy(xpath = "//*[contains(@id, 'login_password')]")
    private WebElement passwordTextField;

    @FindBy(xpath = "//*[contains(@id, 'remember_me')]")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//*[contains(@class, 'signin-button')]")
    private WebElement signInBtn;

    @FindBy(xpath = "//*[@class='forgot-password-link']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//header[@class='mast-head']")
    private WebElement stickyHeader;

    @FindBy(xpath = "//*[contains(@class, 'error')]")
    private WebElement forgotPasswordErrorMsg;

    @FindBy(xpath = "//*[@class='error-message']")
    private WebElement invalidLoginErrorMsg;

    @FindBy(xpath = "//*[contains(@class, 'resend-two-factor-code')]")
    private WebElement resendCodeLink;


    public Login fillSignInForm(String path) {
        switch(path.toLowerCase()) {
            case "existing":
                fillTheField(emailTextField, getData("login").get("email"));
                fillTheField(passwordTextField, getData("login").get("password"));
                click(signInBtn);
                break;
            //the following happens only when tested manually:
            case "non-existing":
                fillTheField(emailTextField, getData("login").get("nonexistingemail"));
                fillTheField(passwordTextField, getData("login").get("nonexistingpassword"));
                click(signInBtn);
                break;
            case "google":
                new GoogleSignIn().googleSignIn();
                break;
            default:
                System.out.println("Error: This scenario is not defined");
        }
        return this;
    }


    public Login fillWrongPassword() {
        fillTheField(emailTextField, getData("login").get("email"));
        fillTheField(passwordTextField, getData("login").get("wrongPassword"));
        click(signInBtn);
        return this;
    }

    public boolean isErrorDisplayed(String element) {
        switch(element.toLowerCase()) {
            case "invalid password":
            case "blanc":
                return invalidLoginErrorMsg.isDisplayed();
            case "create":
                return resendCodeLink.isDisplayed();
            default:
                System.out.println("Verification error: this scenario has not been defined");
        }
        return false;
    }

    public Login fieldLeftBlanc(String field) {
        switch(field.toLowerCase()) {
            case("email"):
                fillTheField(passwordTextField, getData("login").get("password"));
                click(signInBtn);
                break;
            case("password"):
                fillTheField(emailTextField, getData("login").get("email"));
                click(signInBtn);
                break;
            default:
                System.out.println("Error: This scenario is not defined");
        }
        return this;
    }


    public Homepage googleSignIn() {
        click(googleSignInBtn);
        switchToNewWindow();
        new GoogleSignIn().googleSignIn();
        return new Homepage();
    }






}
