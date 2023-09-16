package com.example.dev_140_2_authentication;

import java.util.Objects;

public class PersonDto {
    private int id;
    private String jobtitle;
    private String firstnamelastname;
    private String phone;
    private String email;
    private int count;

    public PersonDto(int id, String jobtitle, String firstnamelastname, String phone, String email, int count) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.firstnamelastname = firstnamelastname;
        this.phone = phone;
        this.email = email;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return id == personDto.id && Objects.equals(jobtitle, personDto.jobtitle) && Objects.equals(firstnamelastname, personDto.firstnamelastname)
                && Objects.equals(phone, personDto.phone) && Objects.equals(email, personDto.email) && Objects.equals(count, personDto.count);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, jobtitle, firstnamelastname, phone, email, count);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", jobtitle=" + jobtitle +
                ", firstnamelastname='" + firstnamelastname +
                ", phone=" + phone +
                ", email='" + email +
                ", count='" + count +
                '}';
    }
}
