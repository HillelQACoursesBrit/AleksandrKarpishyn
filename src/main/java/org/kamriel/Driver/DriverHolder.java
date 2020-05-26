package org.kamriel.Driver;

import org.openqa.selenium.WebDriver;

public class DriverHolder {
    private WebDriver driver;
    private static DriverHolder INSTANCE = null;

    public static DriverHolder getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DriverHolder();
        }
        return INSTANCE;
    }
    public void initDriver(DriverType driverType){
        driver = WebDriverFactory.initDriver(driverType);
    }
    public WebDriver getDriver(){
        return driver;
    }
    private DriverHolder(){

    }
}
