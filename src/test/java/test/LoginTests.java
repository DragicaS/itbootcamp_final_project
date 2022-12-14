package test;
/*•	Verifikovati da se u url-u stranice javlja ruta /login*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {


    @Test(priority = 1)
    public void loginPageUrl() throws InterruptedException {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        homePage.clickLogin();
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 2)
    public void checksType() throws InterruptedException {

        String expectedResult = "email";
        homePage.clickLogin();
        String actualResult = loginPage.getEmail().getAttribute("type");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assert.assertEquals(actualResult, expectedResult);
        String expectedResult2 = "password";
        String actualResult2 = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualResult2, expectedResult2);

    }

    @Test(priority = 3)
    public void errorMessage() {
        String expectedResult = "User does not exists";

        homePage.clickLogin();
        loginPage.invalidInput();
        WebElement result = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        String actualResult = result.getText();
        Assert.assertEquals(actualResult, expectedResult);
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }

    @Test(priority = 4)
    public void errorPassword() {
        String expectedResult = "Wrong password";
        homePage.clickLogin();
        loginPage.invalidInputWithWrongPassword();
        WebElement result = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        String actualResult = result.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 5)
    public void login() throws InterruptedException {
        homePage.clickLogin();
        Thread.sleep(1000);
        loginPage.login();
        Thread.sleep(1000);
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains("home"));

    }

    @Test(priority = 6)
    public void logout() throws InterruptedException {

        homePage.clickLogin();
        loginPage.login();
        Assert.assertTrue(loginPage.getLogoutButton().isDisplayed());
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.logout();

        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));


    }


}
