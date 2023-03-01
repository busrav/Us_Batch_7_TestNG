package day03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    void startCar(){
        System.out.println("Car is started");
//        Assert.fail();
    }
//no effect of priority due to dependencies
    @Test(dependsOnMethods = {"startCar"}, priority = 1) //test depends on the start car test success
    void driveCar(){
        System.out.println("Car is driven");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"},priority = 3)   //this test depends on both
    void parkCar(){
        System.out.println("Car is parked");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar", "parkCar"},priority = 2)  // the order of dependencies may affect
    void stopCar(){
        System.out.println("Car is stopped");
    }
}
