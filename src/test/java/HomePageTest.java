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

public class HomePageTest extends BaseTestClass {
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
    @Test (priority = 1)
    public void CheckCountOfSliders () throws InterruptedException {
        homePage.clickOnShop();
        shopPage.clickOnHome();


        Assert.assertEquals(homePage.getCountOfSliders(),3);


    }
    @Test (priority = 2)
    public void CheckCountOfArrivals () throws InterruptedException {
        homePage.clickOnShop();
        shopPage.clickOnHome();


        Assert.assertEquals(homePage.getCountOfArrivals(),3);

        Thread.sleep(10000);//для отладки
    }


}
