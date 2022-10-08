package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

/*•	baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
•	beforeClass - gde se podesava drajver sa implicitnim cekanjem i cekanjem za ucitavanje stranice i kreiraju svi pagevi potrebni za testiranje
•	aftterClass - gde se gasi stranica
•	beforeMethod - gde se pre svakog testa ucitava baseUrl stranica
*/
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected Faker faker;
    protected HomePage homePage;
    protected SignupPage signupPage;
    protected AdminCitiesPage adminCitiesPage;
    protected AuthRoutesPage authRoutesPage;
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\Bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        faker = new Faker();
        homePage=new HomePage(driver,wait);
        signupPage=new SignupPage(driver,wait);
        adminCitiesPage=new AdminCitiesPage(driver,wait);
        authRoutesPage=new AuthRoutesPage(driver,wait);

    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void baseUrl() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

}
