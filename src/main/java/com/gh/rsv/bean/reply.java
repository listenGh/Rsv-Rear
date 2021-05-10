package com.gh.rsv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class reply {
    private int id;
    private String replyUsername;
    private String dates;
    private String content;
    private int mid;
}
