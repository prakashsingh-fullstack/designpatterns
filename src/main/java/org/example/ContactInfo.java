package org.example;

import org.apache.commons.lang3.Validate;

public class ContactInfo {
    private String contact;
    private boolean email;

    public ContactInfo(String contact, boolean email) {
        Validate.notBlank("Undefined Contact!");
        this.contact = contact;
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "contact='" + contact + '\'' +
                ", email=" + email +
                '}';
    }
}
