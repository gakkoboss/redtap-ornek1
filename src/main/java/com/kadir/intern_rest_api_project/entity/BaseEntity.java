package com.kadir.intern_rest_api_project.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data

public class BaseEntity implements Serializable {
    private Date createdDate;
    private String createdBy;
    private Date updatedAt;
    private String updateBy;    }
