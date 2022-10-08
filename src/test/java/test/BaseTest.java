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


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected Faker faker;
    protected HomePage homePage;
    protected SignupPage signupPage;
    protected AdminCitiesPage adminCitiesPage;
    protected AuthRoutesPage authRoutesPage;
    protected LocalePage localePage;
    protected ProfilePage profilePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\Bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait,faker);

        homePage = new HomePage(driver, wait,faker);
        signupPage = new SignupPage(driver, wait,faker);
        adminCitiesPage = new AdminCitiesPage(driver, wait,faker);
        authRoutesPage = new AuthRoutesPage(driver, wait,faker);
        localePage = new LocalePage(driver, wait,faker);
        profilePage = new ProfilePage(driver, wait,faker);


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
