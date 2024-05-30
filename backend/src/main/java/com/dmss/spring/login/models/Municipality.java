package com.dmss.spring.login.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_municipality")
public class Municipality {

    @Id
    @Column(name = "MunicipalityID")
    private Integer id;

    @Column(name = "namelang1")
    private String name;

    public Municipality() {
    }

    public Municipality(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
