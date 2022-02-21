package com.example.demo.page.contact;

import com.example.demo.annotations.Page;
import com.example.demo.page.Base;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class ContactPage extends Base {
    @Autowired
    private ContactsComponent contactsComponent;

    @Autowired
    private FormComponent formComponent;


    public ContactsComponent getContactsComponent() {
        return contactsComponent;
    }

    public FormComponent getFormComponent() {
        return formComponent;
    }
}
