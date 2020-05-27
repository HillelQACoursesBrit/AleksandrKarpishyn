package org.kamriel.Pages;


import org.kamriel.Driver.DriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

   @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement passwordarea;

    @FindBy(xpath = "//input[@name='login']")
    WebElement loginButton;

    @FindBy(className = "woocommerce-error")
    WebElement errorMessage;

    @FindBy(xpath = "//ul[contains(@class,'woocommerce-error')]")
    WebElement errorMessageText;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutButton;

    public boolean CheckEnableLogoutButton( ){


        return logoutButton.isDisplayed();
    }

    public LoginPage CheckErroreMessageDisplayed( ){

        errorMessage.isDisplayed();
        return this;
    }

    public String CheckErroreMessageText( ){
        return errorMessageText.getText();
    }


    public LoginPage ClickOnLogginButton( ){

        loginButton.click();
        return this;
    }

    public LoginPage WriteLoggin(String login){
        username.clear();
        username.sendKeys(login);
        return this;
    }

    public LoginPage WritePassword(String password){
        passwordarea.clear();
        passwordarea.sendKeys(password);
        return this;
    }
    public LoginPage(){

        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }
}
