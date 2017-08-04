package com.study.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/4.
 */
@Entity
public class Login {
    @Id
    @GeneratedValue
    private Integer id;
    private String phone;
    private String password;
    private Date crDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }
}
