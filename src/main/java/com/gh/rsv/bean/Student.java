package com.gh.rsv.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Student {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String classes;
    private String email;
    private String role;
    private int credit;
}
