package org.kamriel.Driver;

import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.PageFactory;

public class BaseTestClass {
    public BaseTestClass(){
        PageFactory.initElements(DriverHolder.getInstance().getDriver(), this);
    }

    @BeforeSuite
    public void beforeSuite() throws IOException {
        DriverHolder.getInstance().initDriver(DriverType.CHROME);

    }

    protected void goToUrl(String url) {
        DriverHolder.getInstance().getDriver().get(url);
    }

    @AfterSuite
    public void afterSuite() throws NullPointerException {
        DriverHolder.getInstance().getDriver().quit();
    }
}
