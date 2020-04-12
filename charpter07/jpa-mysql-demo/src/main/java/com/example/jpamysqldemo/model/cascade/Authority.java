package com.example.jpamysqldemo.model.cascade;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author WU, Homer
 * @version 1.0
 * @description
 */
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;//权限名

    @ManyToMany(mappedBy = "authorityList")
    private List<User> userList;
}
