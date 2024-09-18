package com.kadir.intern_rest_api_project.repository;

import com.kadir.intern_rest_api_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long> {
}
