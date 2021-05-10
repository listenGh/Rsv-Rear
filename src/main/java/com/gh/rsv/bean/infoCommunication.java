package com.gh.rsv.bean;

//信息交流表

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class infoCommunication {
    private int id;
    private String sendUsername;
    private String dates;
    private String title;
}
