package test;
/*•	Verifikovati da se u url-u stranice javlja ruta /login*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

//https://vue-demo.daniel-avellaneda.com/login
public class LoginTests extends BaseTest {


    @Test(priority = 1)
    public void loginPageUrl() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.loginClick();
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 2)
    public void checksType() throws InterruptedException {

        String expectedResult = "email";
        loginPage.loginClick();
        Thread.sleep(3000);
        String actualResult = loginPage.getEmail().getAttribute("type");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assert.assertEquals(actualResult, expectedResult);
        String expectedResult2 = "password";
        Thread.sleep(3000);
        String actualResult2 = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualResult2, expectedResult2);

    }

    @Test(priority = 3)
    public void errorMessage() {
        String expectedResult = "User does not exists";
        ////*[@id="app"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li
        loginPage.loginClick();
        loginPage.invalidInput();
        WebElement result = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        String actualResult = result.getText();
        Assert.assertEquals(actualResult, expectedResult);
        //proveara login rute
        String expectedResult2="https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2=loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult2,expectedResult2);
    }

}
