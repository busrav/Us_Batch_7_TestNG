package day03;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _02_AddressFunctionality extends DriverClass {

    @Test
    void addNewAddress() {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAddress = driver.findElement(By.linkText("New Address"));
        newAddress.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Jack");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Bill");

        WebElement address = driver.findElement(By.id("input-address-1"));
        address.sendKeys("57 Main Ave");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("New Jersey");

        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("12345");

        WebElement selectCountry = driver.findElement(By.id("input-country"));

        Select countrySelect = new Select(selectCountry);
        int randomCountryIndex = (int) (Math.random()*253)+1;

        countrySelect.selectByIndex(randomCountryIndex);

        WebElement selectRegion = driver.findElement(By.id("input-zone"));

        Select regionSelect = new Select(selectRegion);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.not(ExpectedConditions.numberOfElementsToBe(By.xpath("//select[@id='input-zone']//option"), driver.findElements(By.xpath("//select[@id='input-zone']//option")).size())));

        List<WebElement> listOfRegions = driver.findElements(By.xpath("//select[@id='input-zone']//option"));
        int randomRegionIndex = ((int) (Math.random()*listOfRegions.size()-1))+1;

        regionSelect.selectByIndex(randomRegionIndex);

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"))));
        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(successMessage.getText().contains("successfully"));
    }

    @Test(dependsOnMethods = "addNewAddress")
    void editAddress(){
        WebElement editButton = driver.findElement(By.xpath("(//a[text()='Edit'])[2]"));
        editButton.click();

        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.clear();
        address1.sendKeys("5884 Snow St.");

        WebElement city = driver.findElement(By.id("input-city"));
        city.clear();
        city.sendKeys("New York");

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"))));
        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(successMessage.getText().contains("successfully"));
    }

    @Test(dependsOnMethods = "addNewAddress")
    void deleteAddress(){
        WebElement deleteButton = driver.findElement(By.xpath("(//a[text()='Delete'])[2]"));
        deleteButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"))));
        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(successMessage.getText().contains("successfully"));
    }
}
