package day02;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_UpdateNameTest extends DriverClass {

    @Test
    void editNameTest(){
        editName("Jackie");
        editName("Jack");
    }

    public void editName(String name){
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
//
//        WebElement email = driver.findElement(By.id("input-email"));
//        email.sendKeys("jb1234@gmail.com");
//
//        WebElement password = driver.findElement(By.id("input-password"));
//        password.sendKeys("billililil");
//
//        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
//        loginButton.click();

        WebElement editAccount = driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]"));
        editAccount.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys(name);

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]"));
        Assert.assertEquals(successMessage.getText(),"Success: Your account has been successfully updated.","Test is not successful");
    }

}
