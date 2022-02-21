package com.example.demo.page.contact;

import com.example.demo.annotations.Page;
import com.example.demo.page.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

@Page
public class FormComponent extends Base {

    @FindBy(id = "slide_wrapper")
    public WebElement form;

    @FindBy(className = "vārdsuzvārds")
    public WebElement nameSurnameField;

    @FindBy(className = "personaskods")
    public WebElement personalCodeField;

    @FindBy(className = "lietasnumursnavobligāts")
    public WebElement caseNumberField;

    @FindBy(className = "kontakttālrunis")
    public WebElement contactNumberField;

    @FindBy(className = "epastaadrese")
    public WebElement emailAddressField;

    @FindBy(className = "adrese")
    public WebElement contactAddressField;

    @FindBy(className = "komentāraiebildumubūtība")
    public WebElement commentSectionField;

    @FindBy(className = "kāvēlossaņemtatbildi")
    public WebElement communicationsDropDown;

    @FindBy(name = "__next")
    public WebElement submitBtn;

    public WebElement getFormElementByName(String name) {
        var mapper = new HashMap<String, WebElement>();
        mapper.put("nameSurname", nameSurnameField);
        mapper.put("personalCode", personalCodeField);
        mapper.put("caseNumber", caseNumberField);
        mapper.put("contactNumber", contactNumberField);
        mapper.put("emailAddress", emailAddressField);
        mapper.put("contactAddress", contactAddressField);
        mapper.put("commentSection", commentSectionField);
        mapper.put("communications", communicationsDropDown);
        return mapper.get(name);
    }

    public String getErrorMessageForElement(WebElement element) {
        return element.findElement(By.cssSelector(".field-validation-error")).getText();
    }

    public boolean errorMessageIsHidden(WebElement element) {
        return element.findElement(By.cssSelector(".field-validation-valid")).isDisplayed();
    }

    public void populateField(WebElement element, String text) {
        element.findElement(By.className("text")).sendKeys(text);
    }

    public void clearFieldFromText(WebElement element) {
        element.findElement(By.className("text")).clear();
    }

    public void populateCommentSection(WebElement element, String text) {
        element.findElement(By.id("bdd7ddc6-ca27-4f20-9fbe-f0264f3c2f3a")).sendKeys(text);
    }

    public void selectFromDropdown(WebElement element, String option) {
        Select drpCountry = new Select(element.findElement(By.name("e9a9505d-196d-4bac-8d8f-f8a3f406934d")));
        drpCountry.selectByVisibleText(option);
    }

    public boolean isAt() {
        return this.wait.until(d -> submitBtn.isDisplayed());
    }
}
