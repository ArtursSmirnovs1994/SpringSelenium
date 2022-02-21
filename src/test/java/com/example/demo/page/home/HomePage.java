package com.example.demo.page.home;

import com.example.demo.annotations.Page;
import com.example.demo.page.Base;
import com.example.demo.page.components.CookiesComponent;
import com.example.demo.page.components.NavigationComponents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class HomePage extends Base {

    @Value("${application.url}")
    private String url;

    @Autowired
    private NavigationComponents navigationComponents;

    @Autowired
    private CookiesComponent cookiesComponent;

    public void goTo() {
        this.driver.get(url);
        this.isAt();
        cookiesComponent.acceptCookies();
    }

    public boolean isAt() {
        return this.navigationComponents.isAt();
    }

}
