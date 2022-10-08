package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {


    @Test
    public void authRoutesTest() throws InterruptedException {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void authRoutesProfile() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void authRoutesCities() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void authRoutesUsers() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
