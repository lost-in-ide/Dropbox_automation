import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class FirstFrameworkTest {

    private WebDriver driver;

    @Before
    public void setup() {
        String path = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
    }

    @Test
    public void openPage() {

        driver.get("https://www.dropbox.com/");
        String title = driver.getTitle();
        assertTrue(title.equalsIgnoreCase("dropbox business"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
