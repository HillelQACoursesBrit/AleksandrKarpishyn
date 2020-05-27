import org.kamriel.Driver.BaseTestClass;
import org.kamriel.Driver.BaseTestClass;
import org.kamriel.Driver.DriverHolder;
import org.kamriel.Pages.HomePage;
import org.kamriel.Pages.LoginPage;
import org.kamriel.Pages.ShopPage;
import org.kamriel.Pages.Url;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginPageTest extends BaseTestClass {
    WebDriver driver;
    HomePage homePage;
    ShopPage shopPage;
    LoginPage loginPage;

    String inccorrectLogin = "zydddq159%%$3";
    String correctLogin = "kamrielkarpyshyn@gmail.com";
    String inccorrectPassword = "zydddq159%%$3";
    String correctPassword = "Фдуч1992пщ";

    String erroreLogin = ": Invalid username. ";
    String errorePassword = ": Invalid password. ";

    String emptyUser = "Username is required"; // для теста 3,4
    String emptyPassword = "Password is required"; //для теста 2

    @BeforeTest
    public void beforeTest(){
        WebDriver driver = DriverHolder.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        goToUrl(Url.BASE_URL);
        homePage = new HomePage();
        shopPage = new ShopPage();
        loginPage = new LoginPage();

    }

    //неверное имя и пароль
    @Test (priority = 1)
    public void CheckLoginWithWrongUserAndPasswrod () throws InterruptedException {
        homePage.clickOnMyAccount();
        loginPage.WriteLoggin(inccorrectLogin);
        loginPage.WritePassword(inccorrectPassword);
        loginPage.ClickOnLogginButton();
        loginPage.CheckErroreMessageDisplayed();

        Assert.assertTrue(loginPage.CheckErroreMessageText().contains(erroreLogin));


    }
    //правильный логин и пустой пароль
    @Test (priority = 2)
    public void CheckLoginWithWrongPasswrod () throws InterruptedException {
        homePage.clickOnMyAccount();
        loginPage.WriteLoggin(correctLogin);
        loginPage.ClickOnLogginButton();
        loginPage.CheckErroreMessageDisplayed();

        Assert.assertTrue(loginPage.CheckErroreMessageText().contains(errorePassword));
        // Assert.assertTrue(loginPage.CheckErroreMessageText().contains(emptyPassword));



    }
    //пустой логин и правильный пароль
    @Test (priority = 3)
    public void CheckLoginWithEmptyUser () throws InterruptedException {
        homePage.clickOnMyAccount();

        loginPage.WritePassword(correctPassword);
        loginPage.ClickOnLogginButton();
        loginPage.CheckErroreMessageDisplayed();

       // Assert.assertTrue(loginPage.CheckErroreMessageText().contains(erroreLogin));
        Assert.assertTrue(loginPage.CheckErroreMessageText().contains(emptyUser));


    }

    //пустые поля
    @Test (priority = 4)
    public void CheckLoginWithEmptyUserAndEmptyPassword () throws InterruptedException {
        homePage.clickOnMyAccount();


        loginPage.ClickOnLogginButton();
        loginPage.CheckErroreMessageDisplayed();

        Assert.assertTrue(loginPage.CheckErroreMessageText().contains(erroreLogin));
        // Assert.assertTrue(loginPage.CheckErroreMessageText().contains(emptyUser));

    }

    //корректный вход
    @Test (priority = 5)
    public void CheckLogin () throws InterruptedException {
        homePage.clickOnMyAccount();
        loginPage.WriteLoggin(correctLogin);
        loginPage.WritePassword(correctPassword);
        loginPage.ClickOnLogginButton();
        Assert.assertTrue(loginPage.CheckEnableLogoutButton());


    }

}
