package com.example.demo.steps;

import com.example.demo.annotations.LazyAutowired;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ApplicationContext applicationContext;

    @After
    public void afterScenario() {
        this.applicationContext.getBean(WebDriver.class).quit();
        System.out.println("this is working");
    }
}
