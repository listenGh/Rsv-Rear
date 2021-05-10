package com.gh.rsv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class positionInfo {
    private int id;
    private int num;
    private int state;
    private String startTime;
    private String endTime;
    private String mid;

}
