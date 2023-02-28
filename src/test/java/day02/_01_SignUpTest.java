package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_SignUpTest {
    /** Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Click on My Accout
     * Click on Register
     * Fill int he form with valid informations
     * Accept the agreement
     * Click on Continue button
     * Verify that you are signed up
     */
    @Test
    void signUp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement myAccount = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccount.click();

        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Jack");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Bill");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("jb1234@gmail.com");

        WebElement phone = driver.findElement(By.id("input-telephone"));
        phone.sendKeys("2019876543");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("billililil");

        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("billililil");

        WebElement checkbox = driver.findElement(By.name("agree"));
        checkbox.click();

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@id='content']//p"));

        Assert.assertEquals(successMessage.getText(),"Congratulations! Your new account has been successfully created!", "Test is not successful");

        Thread.sleep(3000);
        driver.quit();
    }
}
