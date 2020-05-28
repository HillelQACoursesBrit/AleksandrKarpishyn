import org.kamriel.Driver.BaseTestClass;
import org.kamriel.Driver.DriverHolder;
import org.kamriel.Pages.Arrivals;
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
    Arrivals arrivals;

    @BeforeTest
    public void beforeTest(){
        WebDriver driver = DriverHolder.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        goToUrl(Url.BASE_URL);
        homePage = new HomePage();
        shopPage = new ShopPage();
        arrivals = new Arrivals();

    }
    @Test (priority = 1)
    public void CheckCountOfSliders () throws InterruptedException {
        homePage.clickOnShop();
        shopPage.clickOnHome();

        Assert.assertEquals(homePage.getCountOfSliders(),3);

    }
    //тест 2
    @Test (priority = 2)
    public void CheckCountOfArrivals () throws InterruptedException {
        homePage.clickOnShop();
        shopPage.clickOnHome();

        Assert.assertEquals(homePage.getCountOfArrivals(),3);

        Thread.sleep(10000);//для отладки
    }


//тест 3
    @Test (priority = 3)
    public void CheckImageInArrivals () throws InterruptedException {
        homePage.clickOnShop();
        shopPage.clickOnHome();

        homePage.goToArrivals(homePage.numberOfArrivals(1));
        Assert.assertTrue(arrivals.addToBasketDisplay());
        arrivals.goToHome();

        homePage.goToArrivals(homePage.numberOfArrivals(2));
        Assert.assertTrue(arrivals.addToBasketDisplay());
        arrivals.goToHome();

        homePage.goToArrivals(homePage.numberOfArrivals(3));
        Assert.assertTrue(arrivals.addToBasketDisplay());
        arrivals.goToHome();
}

//тест 4
    @Test(priority = 4)
    public void arrivalsImagesDescription(){
        homePage.goToArrivals(homePage.numberOfArrivals(1));
        arrivals.nameOfBook();
        Assert.assertTrue(arrivals.descriptionInclude());
        arrivals.goToHome();

        homePage.goToArrivals(homePage.numberOfArrivals(2));
        arrivals.nameOfBook();
        Assert.assertTrue(arrivals.descriptionInclude());
        arrivals.goToHome();

        homePage.goToArrivals(homePage.numberOfArrivals(3));
        arrivals.nameOfBook();
        Assert.assertTrue(arrivals.descriptionInclude());
        arrivals.goToHome();
}

//тест 5
    @Test(priority = 5)
    public void arrivalsImagesReviews(){
        homePage.goToArrivals(homePage.numberOfArrivals(1));
        arrivals.goToReviews();
        Assert.assertTrue(arrivals.reviewsInclude());
        arrivals.goToHome();

        homePage.goToArrivals(homePage.numberOfArrivals(2));
        arrivals.goToReviews();
        Assert.assertTrue(arrivals.reviewsInclude());
        arrivals.goToHome();

        homePage.goToArrivals(homePage.numberOfArrivals(3));
        arrivals.goToReviews();
        Assert.assertTrue(arrivals.reviewsInclude());
        arrivals.goToHome();
}

}
