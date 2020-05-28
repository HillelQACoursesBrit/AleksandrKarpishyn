package org.kamriel.Pages;

import org.jsoup.Jsoup;
import org.kamriel.Driver.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.swing.text.Document;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;


public class ShopPage {
    Actions move = new Actions(DriverHolder.getInstance().getDriver());

    @FindBy(linkText ="Automation Practice Site")
    WebElement home;

    @FindBy(xpath = "//div[contains(@class,'price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all')]//span[2]")
    WebElement filterMax;

    @FindBy(xpath = "//button[contains(@class,'button')]")
    WebElement filterButton;

    @FindBy(className = "//ul[contains(@class,'products masonry-done')]")
    WebElement items;

    @FindBy(xpath = "//a[contains(text(),'HTML')]")
    WebElement randomItems;

    @FindBy(xpath = "//select[@name='orderby']")
    WebElement dropdownFilter;

    @FindBy(xpath = "//option[contains(text(),'Sort by popularity')]")
    WebElement popularityOptions;

    @FindBy(xpath = "//option[contains(text(),'Sort by average rating')]")
    WebElement averageOptions;

    @FindBy(xpath = "//option[contains(text(),'Sort by newness')]")
    WebElement newnessOptions;

    public ShopPage setnewnessOptions(){
        newnessOptions.click();
        return this;
    }

    public ShopPage setAverageOptions(){
        averageOptions.click();
        return this;
    }

    public ShopPage setPopularityOptions(){
        popularityOptions.click();
        return this;
    }
    public ShopPage clickOnDropdownFilter(){
        dropdownFilter.click();
        return this;
    }
    public ShopPage clickOnRandomItems(){
        randomItems.click();
        return this;
    }

    public ShopPage clickOnFilterButton(){
        filterButton.click();
        return this;
    }


    public void checkPrice() {

       //добавить проверку

    }


    public ShopPage setMaxFilter(int max){


        Actions move = new Actions(DriverHolder.getInstance().getDriver());
                for (int i =0; i<max;i++)
                {
                    move.sendKeys(filterMax, Keys.ARROW_DOWN)
                   .click()
                .build()
                .perform();
                }

        return this;
    }

    public ShopPage clickOnHome(){
        home.click();
        return this;
    }


    public ShopPage(){

        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }
}
