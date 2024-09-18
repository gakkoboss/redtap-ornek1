package com.kadir.intern_rest_api_project.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "KULLANİCİLAR")
@Data

public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name="user_seq_gen",sequenceName="user_gen",initialValue= 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @Column(name= "ID")
    private Long id;
    @Column(name = "İSİM", length = 100)
    private String first_name;
    @Column(name= "SOYİSİM",length = 100)
    private String last_name;
}
