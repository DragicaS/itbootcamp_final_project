package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

/*•	baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
•	beforeClass - gde se podesava drajver sa implicitnim cekanjem i cekanjem za ucitavanje stranice i kreiraju svi pagevi potrebni za testiranje
•	aftterClass - gde se gasi stranica
•	beforeMethod - gde se pre svakog testa ucitava baseUrl stranica
*/
public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    protected LoginPage loginPage;
    protected Faker faker;
    protected HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\Bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage = new LoginPage(driver, wait);
        faker = new Faker();
        homePage=new HomePage(driver,wait);


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
