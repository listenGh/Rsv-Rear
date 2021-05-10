package com.gh.rsv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SubMenu {
    private int id;
    private String title;
    private String path;

    public SubMenu(String title, String path) {
        this.title = title;
        this.path = path;
    }
}

