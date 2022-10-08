package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    //1)Test
    // Ucitati /home stranu kada korisnik nije ulogovan
    //	Verifikovati da se u url-u stranice javlja ruta /login

    @Test
            public void authRoutesTest() throws InterruptedException {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }
    /*Test #2: Forbids visits to profile url if not authenticated
assert:
•	Ucitati /profile stranu
•	Verifikovati da se u url-u stranice javlja ruta /login
*/
    @Test
    public void authRoutesProfile()
    {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult="https://vue-demo.daniel-avellaneda.com/login";
        String actualResult=driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }
    /*Test #3: Forbids visits to admin cities url if not authenticated
assert:
•	Ucitati /admin/cities stranu
•	Verifikovati da se u url-u stranice javlja ruta /login
*/
    @Test
    public void authRoutesCities()
    {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult="https://vue-demo.daniel-avellaneda.com/login";
        String actualResult=driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }
    /*Test #4: Forbids visits to admin users url if not authenticated
assert:
•	Ucitati /admin/users stranu
•	Verifikovati da se u url-u stranice javlja ruta /login
*/
    @Test
    public void authRoutesUsers()
    {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult="https://vue-demo.daniel-avellaneda.com/login";
        String actualResult=driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }
}
