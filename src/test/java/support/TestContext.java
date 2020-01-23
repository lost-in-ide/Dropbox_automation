package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;


//all test-related helpers: driver getter, wait getter, browser initialization and teardown, etc


public class TestContext {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) driver;   //casting, specifying the type
    }

    public static WebDriverWait getWait(int timeout) {
        return new WebDriverWait(driver, timeout);
    }

    //TODO: set up pageLoadWait

    public static void initialize(String browser, boolean isHeadless) {
        switch (browser) {
            case "chrome":
                String path = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
                System.setProperty("webdriver.chrome.driver", path);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");

                if (isHeadless) {
                    chromeOptions.setHeadless(true);
                    chromeOptions.addArguments("--window-size=1920,1080");
                    chromeOptions.addArguments("--disable-gpu");
                }

                driver = new ChromeDriver(chromeOptions);
                break;

            default:
                throw new RuntimeException("Driver is not implemented for: " + browser);
        }
    }

    public static File getFile(String fileName, String extension) {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + "." + extension;
        return new File(path);
    }

    public static Map<String, String> getData(String fileName) {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(getFile(fileName, "yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Yaml().load(stream);
    }

    public static void teardown() {
        driver.quit();
    }



}
