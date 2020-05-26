package org.kamriel.Pages;

import org.kamriel.Driver.DriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

    @FindBy(linkText ="Automation Practice Site")
    WebElement home;

    public ShopPage clickOnHome(){
        home.click();
        return this;
    }


    public ShopPage(){

        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }
}
