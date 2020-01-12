package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSignIn extends Page {

    @FindBy(xpath="//input[@id='identifierId']")
    private WebElement emailField;

    @FindBy(xpath="//input[@id='identifierNext']")
    private WebElement emailNextBtn;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath="//input[@id='passwordNext']")
    private WebElement passwordNextBtn;






}
