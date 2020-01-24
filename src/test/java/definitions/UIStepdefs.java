package definitions;

import cucumber.api.java.en.*;
import pages.Homepage;
import pages.Landing;
import pages.Login;

import static org.testng.Assert.assertTrue;
import static support.TestContext.getDriver;

public class UIStepdefs {

    @Given("I open {string} website")
    public void iOpenWebsite(String link) {
        switch (link.toLowerCase()) {
            case ("dropbox"):
                getDriver().get("https://dropbox.com");
                break;
            default:
                System.out.println("Requested website could not be open: " + link);
        }
    }
    
    @And("I login to {string} account")
    public void iLoginToAccount(String path) {
        new Login().fillSignInForm(path);
    }

    @Then("I verify login successful")
    public void iVerifyLoginSuccessful() {
        assertTrue(new Homepage().isLoggedIn());
    }

    @And("I click on {string} link")
    public void iClickOnLink(String element) {
        switch(element.toLowerCase()) {
            case "sign in":
                new Landing().signIn();
                break;
            case "sign in with google":
                new Login().googleSignIn();
                break;
        }
    }

    @And("I Login with invalid password")
    public void iLoginWithInvalidPassword() {
        new Login().fillWrongPassword();
    }

    @And("I login with {string} left blanc")
    public void iLoginWithLeftBlanc(String webElement) {
        new Login().fieldLeftBlanc(webElement);
    }

    @Then("I verify {string} error message is displayed")
    public void iVerifyErrorMessageIsDisplayed(String type) {
        assertTrue(new Login().isErrorDisplayed(type));
    }


}

