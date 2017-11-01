package com.study.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by roy on 2017/8/16.
 */
@Entity
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String createdBy;
    private String updatedBy;
    private Date crDate;
    private Date upDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }
}
