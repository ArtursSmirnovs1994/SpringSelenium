package com.example.demo.page.contact;

import com.example.demo.annotations.Page;
import com.example.demo.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class ContactsComponent extends Base {

    @FindBy(className = "slide_open")
    private WebElement formBtn;

    public void openContactForm() {
        this.formBtn.click();
    }


    public boolean isAt() {
        return this.wait.until(d -> formBtn.isDisplayed());
    }
}
