package com.prakharpatil.studentesd.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Domain")
public class Domain {

    @Id
    private long id;

    private String domain_name;

    private int capacity;

    private String Qualification;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }
}