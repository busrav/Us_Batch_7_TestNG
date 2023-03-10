package day01;

import org.testng.annotations.Test;

public class _01_Intro {

//    if you don't give the order(priority), it runs the tests in the alphabetical order
    @Test(priority = 1)   //first test to be run
    public void loginTest(){
        System.out.println("Login test is successful");
    }

    @Test(priority = 2)   //second test to be run
    public void addToCartTest(){
        System.out.println("Add to Cart test is successful");
    }

    @Test(priority = 3)    //third test to be run
    public void checkOutTest(){
        System.out.println("Checkout test is successful");
    }
}
