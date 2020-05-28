package org.kamriel.Pages;
import org.kamriel.Driver.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import org.kamriel.Pages.HomePage;


public class Arrivals {
    List<String> nameBook = new ArrayList<>();

    @FindBy (xpath = "//*[@class='single_add_to_cart_button button alt']")
    WebElement addToBasket;

    @FindBy(xpath = "//*[@href = 'http://practice.automationtesting.in']")
    WebElement home;

    @FindBy(xpath = "//*[@class = 'product_title entry-title']")
    WebElement name;

    @FindBy(id = "tab-description")
    WebElement description;

    @FindBy(xpath = "//*[@href = '#tab-reviews']")
    WebElement reviews;

    @FindBy(xpath = "//*[@class = 'comment-reply-title']")
    WebElement reviewsBook;

    public HomePage goToHome(){
        home.click();
        return new HomePage();
    }

    public void nameOfBook(){
        for(String s: name.getText().split(" ")){
            nameBook.add(s);
        }
    }

    public boolean descriptionInclude(){
        for (int i = 0; i < nameBook.size(); i++){
            if (description.getText().toLowerCase().contains(nameBook.get(i).toLowerCase())){
                return true;
            }
        }
        return  false;
    }

    public Arrivals goToReviews(){
        reviews.click();
        return new Arrivals();
    }

    public  boolean reviewsInclude(){
        return reviewsBook.getText().toLowerCase().contains(name.getText().toLowerCase());
    }

    public boolean addToBasketDisplay(){
        return addToBasket.isDisplayed();
    }


    public Arrivals(){
        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }
}
