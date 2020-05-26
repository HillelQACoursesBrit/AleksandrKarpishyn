package org.kamriel.Pages;

import org.kamriel.Driver.DriverHolder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(linkText ="Shop")
    WebElement shop;

   // @FindBy(xpath = "//*[@class = 'n2-ss-slide n2-ss-canvas  n2-ss-slide-active n2-ss-slide-36']")
   @FindBy(xpath = "//*[@class = 'row_inner']")
    List<WebElement> slider;

    @FindBy(xpath = "//*[@class = 'row_inner']")
    List<WebElement> arrivals;

public HomePage clickOnShop(){
    shop.click();
    return this;
}

    public int getCountOfSliders()
    {
        return slider.size();
    }
    public int getCountOfArrivals()
    {
        return arrivals.size();
    }

    public HomePage(){

        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }
}
