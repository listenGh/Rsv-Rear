package com.gh.rsv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Deduction {
    private int id;
    private String jBusername;//举报者用户名
    private String bJBusername;//被举报者用户名
    private String dates;//违章时间
    private String content;//违章内容
    private int kf;//扣分
    private int state;//是否已经审核
}
