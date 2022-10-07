package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

@AfterMethod
public void newLogout()
{
    loginPage.logout();
}
    @Test(priority = 1)
    public void citiesPage() throws InterruptedException {
        homePage.clickLogin();
        Thread.sleep(1000);
        loginPage.login();
        Thread.sleep(1000);
        adminCitiesPage.clickAdmin();
        Thread.sleep(1000);
        adminCitiesPage.clickCities();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin/cities"));
        String expectedResult="LOGOUT";
        WebElement result= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        String actualResult=result.getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
    /*Test #2: Create new city
Podaci: random grad korisćenjem faker library-ja
assert:
•	Verifikovati da poruka sadrzi tekst Saved successfully
*/
    @Test(priority = 2)
    public void createCity() throws InterruptedException {
        //vrati na home

        homePage.clickLogin();
        loginPage.login();
        adminCitiesPage.clickAdmin();
        adminCitiesPage.clickCities();
        adminCitiesPage.addCity();
        Thread.sleep(3000);
        //String expectedResult="Saved successfully";
        WebElement result=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        String actualResult=result.getText();
        Assert.assertTrue(actualResult.contains("Saved successfully"));
    }
    /*Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited (primer: Beograd – Beograd edited)
    assert:
•	Verifikovati da poruka sadrzi tekst Saved successfully
*/
    @Test(dependsOnMethods = {"createCity"})
    public void editCity() throws InterruptedException {
        homePage.clickLogin();
        loginPage.login();
        adminCitiesPage.clickAdmin();
        adminCitiesPage.clickCities();

        WebElement resultEdit= driver.findElement(By.xpath("//*[@id=\"edit\"]/span/i"));
        resultEdit.click();
        Thread.sleep(1000);
        adminCitiesPage.editCity();

    }
    /*Podaci: editovani grad iz testa #3
        assert:
•	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

*/
    @Test(dependsOnMethods = {"createCity","editCity"})
    public void verifyName() throws InterruptedException {
        homePage.clickLogin();
        loginPage.login();
        adminCitiesPage.clickAdmin();
        Thread.sleep(2000);
        adminCitiesPage.clickCities();
        adminCitiesPage.checkCity();
        Thread.sleep(3000);
       WebElement firstName=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
      String actualResult= firstName.getText();
       Assert.assertTrue(actualResult.contains(adminCitiesPage.getCity()));

    }
    /*Podaci: editovani grad iz testa #3
assert:
•	U polje za pretragu uneti staro ime grada
•	Sacekati da broj redova u tabeli bude 1

•	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

•	Kliknuti na dugme Delete iz prvog reda
•	Sacekati da se dijalog za brisanje pojavi
•	Kliknuti na dugme Delete iz dijaloga
•	Sacekati da popu za prikaz poruke bude vidljiv
•	Verifikovati da poruka sadrzi tekst Deleted successfully
*/

    @Test(dependsOnMethods={"createCity","editCity"})
    public void deleteCity() throws InterruptedException {
        homePage.clickLogin();
        loginPage.login();
        adminCitiesPage.clickAdmin();
        adminCitiesPage.clickCities();
        Thread.sleep(1000);
        WebElement serachField=getDriver().findElement(By.xpath("//*[@id=\"search\"]"));
        serachField.click();
        serachField.sendKeys(adminCitiesPage.getCity());
        WebElement nameField=getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        nameField.getText().contains(adminCitiesPage.getCity());
        Thread.sleep(1000);
        WebElement deleteField=getDriver().findElement(By.xpath("//*[@id=\"delete\"]/span/i"));
        deleteField.click();
        WebElement confirmeField=getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]/span"));
        confirmeField.click();
        Thread.sleep(3000);
        String expectedResult="Deleted successfully\nCLOSE";
        WebElement message=getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        String actualResult= message.getText();
        Thread.sleep(1000);
        Assert.assertEquals(actualResult,expectedResult);


    }
}
