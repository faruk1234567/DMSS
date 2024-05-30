package com.dmss.spring.login.models.htx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_board_ct1035")
public class t_board_ct1035 {
    @Id
    private Long OID;

    private String userType;

    public t_board_ct1035() {
    }

    public t_board_ct1035(Long OID, String userType) {
        this.OID = OID;
        this.userType = userType;
    }

    public Long getOID() {
        return OID;
    }

    public void setOID(Long OID) {
        this.OID = OID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
