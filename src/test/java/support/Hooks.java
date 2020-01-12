package support;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.util.concurrent.TimeUnit;
import static support.TestContext.getDriver;

public class Hooks {

    @Before(order=0)
    public void scenarioStart() {
        TestContext.initialize("chrome", false);
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }


    @After(order=0)
    public void scenarioEnd() {
        TestContext.teardown();
    }
}
