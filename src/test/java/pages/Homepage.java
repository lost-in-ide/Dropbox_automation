package pages;

import cucumber.api.java8.Th;
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

    @FindBy(xpath = "//*[contains(@class, 'file-uploader')]/../input[@type='file']")
    private WebElement hiddenUploadFolder;

    @FindBy(xpath = "//input[@type='file'][contains(@id, 'html')]")
            //(xpath = "//*[contains(@id, 'html')]/input[@type='file']")
    private WebElement hiddenUploadFile;

    @FindBy(xpath = "//*[contains(@class, 'buttons')]//span[contains(text(), 'Upload')]/..")
            //(xpath = "//span[contains(text(), 'Upload')]/..")
    private WebElement uploadFolder;

    @FindBy(xpath="//div[@aria-label='Upload to…']")
    private WebElement uploadModal;

    @FindBy(xpath = "//*[@id='flash-upload-container']")
    private WebElement fileUploadContainer;

    @FindBy(xpath = "//*[contains(@id, 'container') and contains(@id, 'html5')]")
    private WebElement uploadFileParent;




    public boolean isLoggedIn() {
        try {
            getWait(5).until(ExpectedConditions.stalenessOf(accountMenu));
        } catch (Exception e) {
            getWait(2).until(ExpectedConditions.elementToBeClickable(accountMenu));
        }
        return accountMenu.isDisplayed();
}

//trying to make it visible to see the behavior
    public Homepage attachFile(String filename) throws InterruptedException {
        String attachment = System.getProperty("user.dir") + "/src/test/resources/uploads/" + filename;
        /* make visible first:
        1. remove display:none from the grandparent
        2. remove overflow:hidden and z-index:0 from the parent
        3. remove opacity:0, font-size:999px, width:100% and height:100% from the element itself
        4. add background:red and z-index:100 to the element
        */

        makeElementVisible("file", hiddenUploadFile);
        makeElementVisible("parent", uploadFileParent);
        makeElementVisible("grandparent", fileUploadContainer);
        hiddenUploadFile.sendKeys(attachment);
        click(uploadFolder);
        getWait(10).until(ExpectedConditions.visibilityOf(uploadedConfirmation));
        return new Homepage();
    }

    //works fine
    public Homepage attachFolder() {
        String attachment = System.getProperty("user.dir") + "/src/test/resources/uploads/";
        //make visible first
        makeElementVisible("folder", hiddenUploadFolder);
        hiddenUploadFolder.sendKeys(attachment);
        getWait(2000).until(ExpectedConditions.visibilityOf(uploadModal));
        getWait(2000).until(ExpectedConditions.elementToBeClickable(uploadFolder));
        click(uploadFolder);
        getWait(5000).until(ExpectedConditions.visibilityOf(uploadedConfirmation));
        return new Homepage();
    }


    public boolean isUploaded(String filename) {
        click(filesLink);
        return new Files().isMatchFound(filename);
    }


}
