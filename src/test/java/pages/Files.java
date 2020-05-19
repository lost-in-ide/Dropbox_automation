package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;


public class Files extends Page{

    @FindBys(@FindBy(xpath = "//*[@data-filename]"))
    private static List <WebElement> uploadedFilesList;

    public static List <WebElement> getElements() {
        return uploadedFilesList;
    }


    public static boolean isMatchFound(String expected) {
        List <WebElement> fileNames = getElements();

        for (WebElement element : fileNames) {
            if (element.getAttribute("data-filename").equals(expected)) {
                return true;
            }
        }
        return false;
        }

}
