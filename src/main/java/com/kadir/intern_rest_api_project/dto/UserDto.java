package com.kadir.intern_rest_api_project.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {

    private String first_name;
    private String last_name;
}
