package com.gh.rsv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 已经占用的座位信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class hasReserv {
    private int id;
    private String username;
    private String readRoom;
    private int num;
    private String startTime;
    private String endTime;
}
