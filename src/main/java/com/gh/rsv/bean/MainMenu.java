package com.gh.rsv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MainMenu {
    private int id;
    private String title;
    private String path;
    private List<SubMenu> subMenuList;
}
