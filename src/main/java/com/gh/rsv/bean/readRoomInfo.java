package com.gh.rsv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class readRoomInfo {
    private int id;
    private String name;
    private String type;
    private int row;
    private int col;
    private int sum;
}
