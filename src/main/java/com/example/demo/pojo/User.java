package com.example.demo.pojo;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
//    @NotBlank
//    @Length(min = 3, max = 16)
    private String name;
    @Column(name = "password")
//    @Length(min = 3, max = 16)
//    @NotBlank
    private String password;

    public User() {
        super();
    }

//    public User(@NotBlank @Length(min = 3, max = 16) String name, @Length(min = 3, max = 16) @NotBlank String password) {
//        this.name = name;
//        this.password = password;
//    }


    public User(String name, String password) {
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
