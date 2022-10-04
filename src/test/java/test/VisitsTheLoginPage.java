package test;
/*•	Verifikovati da se u url-u stranice javlja ruta /login*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginUrlPage;

//https://vue-demo.daniel-avellaneda.com/login
public class VisitsTheLoginPage extends BaseTest {



        @Test
        public void loginPageUrl()
        {
                String expectedResult="https://vue-demo.daniel-avellaneda.com/login";
                loginUrlPage.loginClick();
                String actualResult= getDriver().getCurrentUrl();
                Assert.assertEquals(actualResult,expectedResult);
        }

}
