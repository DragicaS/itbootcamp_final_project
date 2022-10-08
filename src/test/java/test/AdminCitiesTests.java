package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    @AfterMethod
    public void newLogout() {
        loginPage.logout();
    }

    @Test(priority = 1)
    public void citiesPage() throws InterruptedException {
        homePage.clickLogin();
        loginPage.login();
        adminCitiesPage.clickAdmin();
        adminCitiesPage.clickCities();
        Assert.assertTrue(driver.getCurrentUrl().contains("admin/cities"));
        String expectedResult = "LOGOUT";
        WebElement result = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        String actualResult = result.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test(priority = 2)
    public void createCity() throws InterruptedException {

        homePage.clickLogin();
        loginPage.login();
        adminCitiesPage.clickAdmin();
        adminCitiesPage.clickCities();
        adminCitiesPage.addCity();
        WebElement result = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        String actualResult = result.getText();
        Assert.assertTrue(actualResult.contains("Saved successfully"));
    }


    @Test(dependsOnMethods = {"createCity"})
    public void editCity() throws InterruptedException {
        homePage.clickLogin();
        loginPage.login();
        adminCitiesPage.clickAdmin();
        adminCitiesPage.clickCities();

        WebElement resultEdit = driver.findElement(By.xpath("//*[@id=\"edit\"]/span/i"));
        resultEdit.click();
        adminCitiesPage.editCity();

    }


    @Test(dependsOnMethods = {"createCity", "editCity"})
    public void verifyName() throws InterruptedException {
        homePage.clickLogin();
        loginPage.login();
        adminCitiesPage.clickAdmin();
        adminCitiesPage.clickCities();
        adminCitiesPage.checkCity();
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
        String actualResult = firstName.getText();
        Assert.assertTrue(actualResult.contains(adminCitiesPage.getCity()));

    }


    @Test(dependsOnMethods = {"createCity", "editCity"})
    public void deleteCity() throws InterruptedException {
        homePage.clickLogin();
        loginPage.login();
        adminCitiesPage.clickAdmin();
        adminCitiesPage.clickCities();
        WebElement serachField = getDriver().findElement(By.xpath("//*[@id=\"search\"]"));
        serachField.click();
        serachField.sendKeys(adminCitiesPage.getCity());
        WebElement nameField = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        nameField.getText().contains(adminCitiesPage.getCity());
        WebElement deleteField = getDriver().findElement(By.xpath("//*[@id=\"delete\"]/span/i"));
        deleteField.click();
        WebElement confirmeField = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]/span"));
        confirmeField.click();
        String expectedResult = "Deleted successfully\nCLOSE";
        WebElement message = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        String actualResult = message.getText();
        Assert.assertEquals(actualResult, expectedResult);


    }
}
