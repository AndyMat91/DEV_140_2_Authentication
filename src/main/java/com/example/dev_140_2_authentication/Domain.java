package com.example.dev_140_2_authentication;

import java.util.Date;
import java.util.Objects;

public class Domain {
    private int id;
    private String webname;
    private String domainname;
    private String ip;
    private Date datereg;
    private String countryreg;
    private int personid;

    public Domain(int id, String webname, String domainname, String ip, Date datereg, String countryreg, int personid) {
        this.id = id;
        this.webname = webname;
        this.domainname = domainname;
        this.ip = ip;
        this.datereg = datereg;
        this.countryreg = countryreg;
        this.personid = personid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDatereg() {
        return datereg;
    }

    public void setDatereg(Date datereg) {
        this.datereg = datereg;
    }

    public String getCountryreg() {
        return countryreg;
    }

    public void setCountryreg(String countryreg) {
        this.countryreg = countryreg;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain domain = (Domain) o;
        return id == domain.id && Objects.equals(webname, domain.webname) && Objects.equals(domainname, domain.domainname)
                && Objects.equals(ip, domain.ip) && Objects.equals(datereg, domain.datereg) && Objects.equals(countryreg, domain.countryreg)
                && Objects.equals(personid, domain.personid);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, webname, domainname, ip, datereg, countryreg, personid);
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id=" + id +
                ", webname=" + webname +
                ", domainname='" + domainname +
                ", ip=" + ip +
                ", datereg='" + datereg +
                ", countryreg=" + countryreg +
                ", personid='" + personid +
                '}';
    }
}
