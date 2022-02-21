package com.example.demo.page.components;

import com.example.demo.annotations.Page;
import com.example.demo.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class NavigationComponents extends Base {

    @FindBy(css = ".menu-items a[href='/saistibu-parvaldisana/sazinieties-ar-mums/']")
    private WebElement contactUsBtn;

    @FindBy(css = "#mobile-menu a[href='/saistibu-parvaldisana/sazinieties-ar-mums/']")
    private WebElement mobileContactUsBtn;

    @FindBy(className = "logo")
    private WebElement logo;

    @FindBy(className = "mobile-menu-button")
    private WebElement mobileMenuBtn;


    public void navigateToContactPage() {
        if (this.mobileMenuBtn.isDisplayed()) {
            this.mobileMenuBtn.click();
            this.mobileContactUsBtn.click();
        } else {
            this.contactUsBtn.click();
        }

    }

    public boolean isAt() {
        return this.wait.until((d) -> this.logo.isDisplayed());
    }
}
