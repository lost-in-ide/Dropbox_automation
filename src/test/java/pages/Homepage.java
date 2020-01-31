package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getWait;


public class Homepage extends Page {

    @FindBy(xpath = "//*[contains(@class, 'account-menu')]")
    private WebElement accountMenu;

    @FindBy(xpath="//*[contains(@class, 'nav__contents')]")
    private WebElement leftPanel;

    @FindBy(xpath="//*[@id='files']")
    private WebElement filesLink;

    @FindBy(xpath="//*[@id='paper']")
    private WebElement paperLink;

    @FindBy(xpath="//*[@id='home']")
    private WebElement homeLink;

    @FindBy(xpath="//*[@id='hellosign']")
    private WebElement helloSignLink;

    @FindBy(xpath="//*[@id='file_transfers']")
    private WebElement transfersLink;

    @FindBy(xpath="//*[@id='professional_collections']")
    private WebElement showcaseLink;

    @FindBy(xpath="//*[contains(@class, 'action-create-file')]")
    private WebElement createFileBtn;

    @FindBy(xpath="//*[contains(@class, 'text-upload-file')]")
    private WebElement uploadFileBtn;

    @FindBy(xpath="//button[contains(@class, 'upload-folder')]")
    private WebElement uploadFolderBtn;

    @FindBy(xpath="//button[contains(@class, 'new-shared-folder')]")
    private WebElement newsharedFolderBtn;

    @FindBy(xpath="//*[@class='newfile-popover']")
    private WebElement newFilePopoverMenu;

    @FindBy(xpath = "//*[@aria-label='Upload to…']")
    private WebElement uploadToPopup;

    @FindBy(xpath = "//*[@aria-label='Upload to…']//*[contains(@class, 'primary')]")
    private WebElement uploadBtn;

    @FindBy(xpath = "//*[@aria-label='Upload to…']//*[contains(@class, 'secondary')]")
    private WebElement cancelUploadBtn;

    @FindBy(xpath = "//*[contains(@class, 'snackbar-container--snackbar-icon')]")
    private WebElement statusBar;

    @FindBy(xpath = "//*[contains(@class, 'snackbar-title') and contains(text(), 'Uploaded')]")
    private WebElement uploadedConfirmation;


    public boolean isLoggedIn() {
        try {
            getWait(2).until(ExpectedConditions.stalenessOf(accountMenu));
        } catch (TimeoutException e) {
            getWait(2).until(ExpectedConditions.elementToBeClickable(accountMenu));
        }
        return accountMenu.isDisplayed();
}

    public Homepage attachFile(String filename) {
        String attachment = System.getProperty("user.dir") + "/src/test/resources/data/" + filename;

        //upload File button is coded into <div> tag. Figuring out if there is a way to deal with it with WebDriver

//        click(uploadFileBtn);
//        uploadFileBtn.sendKeys(attachment);
//        getWait(2).until(ExpectedConditions.visibilityOf(uploadToPopup));
//        click(uploadBtn);
        return new Homepage();
    }

//    public Homepage verifyThatUploaded(String name) {
//
//        return new Homepage();
//    }




}
