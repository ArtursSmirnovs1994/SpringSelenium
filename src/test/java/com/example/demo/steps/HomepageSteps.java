package com.example.demo.steps;

import com.example.demo.annotations.LazyAutowired;
import com.example.demo.page.home.HomePage;
import io.cucumber.java.en.Given;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HomepageSteps {

    @LazyAutowired
    private HomePage homePage;

    @Given("I am on home page")
    public void iAmOnHomePage() {
        this.homePage.goTo();
    }
}
