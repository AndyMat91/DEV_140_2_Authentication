package com.example.dev_140_2_authentication;

import java.util.Objects;

public class Person {
    private int id;
    private String jobtitle;
    private String firstnamelastname;
    private String phone;
    private String email;

    public Person(int id, String jobtitle, String firstnamelastname, String phone, String email) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.firstnamelastname = firstnamelastname;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getFirstnamelastname() {
        return firstnamelastname;
    }

    public void setFirstnamelastname(String firstnamelastname) {
        this.firstnamelastname = firstnamelastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(jobtitle, person.jobtitle) && Objects.equals(firstnamelastname, person.firstnamelastname)
                && Objects.equals(phone, person.phone)&& Objects.equals(email, person.email);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, jobtitle, firstnamelastname, phone, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", jobtitle=" + jobtitle +
                ", firstnamelastname='" + firstnamelastname +
                ", phone=" + phone +
                ", email='" + email +
                '}';
    }
}
