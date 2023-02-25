package day01;

import org.testng.annotations.*;

public class _02_Annotations {
    //@BeforeClass --> This code will be run before the class
        //@BeforeMethod --> This code will be run before all test annotations
            //@Test --> to write our test
            //@Test --> to write our test
        //@AfterMethod --> This code will be run after all test annotations
    //@AfterClass --> This code will be run after the class

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method is working");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method is working");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class is working");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is successful");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 is successful");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class is working");
    }


}
