package com.example.demo.steps;

import com.example.demo.page.components.NavigationComponents;
import com.example.demo.page.contact.ContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

@SpringBootTest
public class ContactSteps {

    @Autowired
    private NavigationComponents navigationComponents;

    @Autowired
    private ContactPage contactPage;

    private static final SoftAssert softAssert = new SoftAssert();
    private static final String expectedErrorMessage = "Lūdzu, aizpildiet lauku";

    @Given("I navigate to contacts page")
    public void iAmOnContactsPage() {
        navigationComponents.navigateToContactPage();
    }

    @When("I open contact form")
    public void iOpenContactForm() {
        contactPage.getContactsComponent().openContactForm();
        contactPage.getFormComponent().isAt();
    }

    @Then("I click on submit button")
    public void iClickOnSubmitButton() {
        contactPage.getFormComponent().submitBtn.click();
    }

    @Then("mandatory non populated fields show error message")
    public void mandatoryNonPopulatedFieldsShowErrorMessage() {
        softAssert.assertEquals(expectedErrorMessage, contactPage.getFormComponent().getErrorMessageForElement(contactPage.getFormComponent().nameSurnameField), "Name surname error message does not match!");
        softAssert.assertEquals(expectedErrorMessage, contactPage.getFormComponent().getErrorMessageForElement(contactPage.getFormComponent().personalCodeField), "Personal code error message does not match!");
        softAssert.assertEquals(expectedErrorMessage, contactPage.getFormComponent().getErrorMessageForElement(contactPage.getFormComponent().emailAddressField), "Email address error message does not match!");
        softAssert.assertEquals(expectedErrorMessage, contactPage.getFormComponent().getErrorMessageForElement(contactPage.getFormComponent().contactAddressField), "Contact address error message does not match!");
        softAssert.assertEquals(expectedErrorMessage, contactPage.getFormComponent().getErrorMessageForElement(contactPage.getFormComponent().commentSectionField), "Comment section error message does not match!");
        softAssert.assertEquals(expectedErrorMessage, contactPage.getFormComponent().getErrorMessageForElement(contactPage.getFormComponent().contactNumberField), "Contact number error message does not match!");
        softAssert.assertEquals(expectedErrorMessage, contactPage.getFormComponent().getErrorMessageForElement(contactPage.getFormComponent().communicationsDropDown), "Communications error message does not match!");
        softAssert.assertAll();
    }

    @And("populating fields removes error message")
    public void populatingFieldRemovesErrorMessage() {
        populateFieldsInForm();

        softAssert.assertFalse(contactPage.getFormComponent().errorMessageIsHidden(contactPage.getFormComponent().nameSurnameField), "Name surname error message still visible!");
        softAssert.assertFalse(contactPage.getFormComponent().errorMessageIsHidden(contactPage.getFormComponent().personalCodeField), "Personal code error message still visible!");
        softAssert.assertFalse(contactPage.getFormComponent().errorMessageIsHidden(contactPage.getFormComponent().emailAddressField), "Email address error message still visible!");
        softAssert.assertFalse(contactPage.getFormComponent().errorMessageIsHidden(contactPage.getFormComponent().contactAddressField), "Contact address error message still visible!");
        softAssert.assertFalse(contactPage.getFormComponent().errorMessageIsHidden(contactPage.getFormComponent().commentSectionField), "Comment section error message still visible!");
        softAssert.assertFalse(contactPage.getFormComponent().errorMessageIsHidden(contactPage.getFormComponent().contactNumberField), "Contact number error message still visible!");
        softAssert.assertFalse(contactPage.getFormComponent().errorMessageIsHidden(contactPage.getFormComponent().communicationsDropDown), "Communications error message still visible!");
        softAssert.assertAll();
    }

    @And("I fill form with incorrect pattern email")
    public void iFillFormWithIncorrectPatternEmail() {
        populateFieldsInForm();
        contactPage.getFormComponent().clearFieldFromText(contactPage.getFormComponent().emailAddressField);
        contactPage.getFormComponent().populateField(contactPage.getFormComponent().emailAddressField, "12345");
    }

    public void populateFieldsInForm() {
        contactPage.getFormComponent().populateField(contactPage.getFormComponent().nameSurnameField, "Arturs");
        contactPage.getFormComponent().populateField(contactPage.getFormComponent().personalCodeField, "111111-11111");
        contactPage.getFormComponent().populateField(contactPage.getFormComponent().contactNumberField, "22222222");
        contactPage.getFormComponent().populateField(contactPage.getFormComponent().emailAddressField, "test@intrum.lv");
        contactPage.getFormComponent().populateField(contactPage.getFormComponent().contactAddressField, "Gustava Zemgala gatve 74a");
        contactPage.getFormComponent().populateCommentSection(contactPage.getFormComponent().commentSectionField, "There are issues with credit!");
        contactPage.getFormComponent().selectFromDropdown(contactPage.getFormComponent().communicationsDropDown, "Pasts");
    }

    @Then("{string} field has error message")
    public void emailFieldHasErrorMessage(String field) {
        assertEquals(expectedErrorMessage, contactPage.getFormComponent().getErrorMessageForElement(contactPage.getFormComponent().getFormElementByName(field)));
    }
}
