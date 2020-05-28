import org.kamriel.Driver.BaseTestClass;
import org.kamriel.Driver.DriverHolder;
import org.kamriel.Pages.HomePage;
import org.kamriel.Pages.ShopPage;
import org.kamriel.Pages.Url;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShopPageTest extends BaseTestClass {
    WebDriver driver;
    HomePage homePage;
    ShopPage shopPage;

    @BeforeTest
    public void beforeTest(){
        WebDriver driver = DriverHolder.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        goToUrl(Url.BASE_URL);
        homePage = new HomePage();
        shopPage = new ShopPage();

    }

    //цена от 150 до 450
    @Test(priority = 1)
    public void CheckCountOfSliders () throws InterruptedException {
        homePage.clickOnShop();
        int max = 50;
        int minprice = 150;
        int maxprice = 450;
        shopPage.setMaxFilter(max);
        shopPage.clickOnFilterButton();

        //добавить проверку

//        shopPage.checkPrice();
//        Thread.sleep(10000);//для отладки
//        goToUrl(Url.BASE_URL);

    }
    //открыть категорию, проверить однотипность.
    @Test(priority = 2)
    public void checkProduectCategory () throws InterruptedException {
        homePage.clickOnShop();
        shopPage.clickOnRandomItems();

        Thread.sleep(10000);//для отладки
        goToUrl(Url.BASE_URL);
    }
    //только популярные
    @Test(priority = 3)
    public void checkPopularity () throws InterruptedException {
        homePage.clickOnShop();
        shopPage.clickOnDropdownFilter();
        shopPage.setPopularityOptions();

        Thread.sleep(10000);//для отладки
        goToUrl(Url.BASE_URL);
    }
    //только Average
    @Test(priority = 4)
    public void checkAverage () throws InterruptedException {
        homePage.clickOnShop();
        shopPage.clickOnDropdownFilter();
        shopPage.setAverageOptions();

        Thread.sleep(10000);//для отладки
        goToUrl(Url.BASE_URL);
    }

    //только Nenewss
    @Test(priority = 4)
    public void checkNenewss () throws InterruptedException {
        homePage.clickOnShop();
        shopPage.clickOnDropdownFilter();
        shopPage.setnewnessOptions();

        Thread.sleep(10000);//для отладки
        goToUrl(Url.BASE_URL);
    }

}
