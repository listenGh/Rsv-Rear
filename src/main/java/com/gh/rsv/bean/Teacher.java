package com.gh.rsv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Teacher {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String XueYuan;
    private String email;
    private String role;
}
