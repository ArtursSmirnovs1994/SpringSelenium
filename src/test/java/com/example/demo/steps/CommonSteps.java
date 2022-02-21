package com.example.demo.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.testng.Assert.fail;

@SpringBootTest
public class CommonSteps {

    @Autowired
    private ApplicationContext ctx;

    @Given("I am using {string}")
    public void iAmUsingDevice(String device) {

        WebDriver driver = this.ctx.getBean(WebDriver.class);


        switch (device) {
            case "desktop":
                driver.manage().window().setSize(new Dimension(1024, 768));
                break;
            case "tablet":
                driver.manage().window().setSize(new Dimension(820, 1180));
                break;
            case "phone":
                driver.manage().window().setSize(new Dimension(375, 667));
                break;
            default:
                fail("Device type " + device + " is not defined currently.");
        }

    }

}
