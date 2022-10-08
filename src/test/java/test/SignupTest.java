package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;

import java.time.Duration;

public class SignupTest extends BaseTest {

    @Test(priority = 1)
    public void url() throws InterruptedException {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";
        signupPage.clickButton();
        String actualResult = signupPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 2)
    public void checkType()
    {
        signupPage.clickButton();

        String expectedResult="text";
        String actualResult=signupPage.getName().getAttribute("type");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assert.assertEquals(actualResult,expectedResult);

        String expectedResult2="email";
        String actualResult2=signupPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualResult2,expectedResult2);

        String expectedResult3="password";
        String actualResult3=signupPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualResult3,expectedResult3);

        String expectedResult4="password";
        String actualResult4=signupPage.getConfirmPassword().getAttribute("type");
        Assert.assertEquals(actualResult4,expectedResult4);
    }
        @Test(priority = 3)

    public void errorMessage() throws InterruptedException {
            signupPage.clickButton();
            signupPage.errorMessage();
            String expectedResult="E-mail already exists";
            WebElement result= getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));
            String actualResult=result.getText();
            Assert.assertEquals(actualResult,expectedResult);

        }
        @Test(priority = 4)
    public void signup() throws InterruptedException {
            signupPage.clickButton();
            signupPage.signup();
            signupPage.clickSignUp();
            Thread.sleep(1000);
            String expectedResult="IMPORTANT: Verify your account";
            WebElement actualResult=driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"));
            Assert.assertEquals(actualResult.getText(),expectedResult);

        }
}
