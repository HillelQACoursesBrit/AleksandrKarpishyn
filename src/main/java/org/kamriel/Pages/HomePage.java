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
    List<WebElement> arrival;


    @FindBy(linkText ="My Account")
    WebElement myAccount;

    //------ попытка через другой xpath
    @FindBy (xpath = "//*[@class='products']")
    List<WebElement> arrivals;
    @FindBy (xpath = "//*[@class = 'attachment-shop_catalog size-shop_catalog wp-post-image']")
    List<WebElement> imageArrivals;

    public int countOfArrivals(){
        return arrivals.size();
    }

    public WebElement numberOfArrivals(int number){
        WebElement numberA = null;
        for ( int i = number - 1; i < imageArrivals.size(); i++){
            numberA = imageArrivals.get(i);
            break;
        }
        return numberA;
    }

    public Arrivals goToArrivals(WebElement webElement){
        webElement.click();
        return new Arrivals();
    }
    //-------коенц попытки



public HomePage clickOnShop(){
    shop.click();
    return this;
}
    public HomePage clickOnMyAccount(){
        myAccount.click();
        return this;
    }


    public int getCountOfSliders()
    {
        return slider.size();
    }
    public int getCountOfArrivals()
    {
        return arrival.size();
    }

    public HomePage(){

        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }
}
