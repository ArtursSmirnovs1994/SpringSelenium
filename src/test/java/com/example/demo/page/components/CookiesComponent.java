package com.example.demo.page.components;

import com.example.demo.annotations.Page;
import com.example.demo.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class CookiesComponent extends Base {

    @FindBy(css = ".banner-actions-container #onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesBtn;

    @FindBy(id = "onetrust-pc-btn-handler")
    private WebElement cookieSettingsBtn;

    @FindBy(css = ".otFloatingRoundedCorner.ot-bottom-left")
    private WebElement cookiePopUp;

    public void acceptCookies() {
        this.isAt();
        this.acceptAllCookiesBtn.click();
    }

    public boolean isAt() {
        return this.wait.until(d -> this.cookiePopUp.getAttribute("style").contains("bottom: 1rem"));
    }
}
