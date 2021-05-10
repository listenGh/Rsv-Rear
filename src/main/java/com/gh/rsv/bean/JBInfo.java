package com.gh.rsv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 举报信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class JBInfo {
    private String jBusername;//举报者用户名
    private String bJBusername;//被举报者用户名
    private String content;//违章内容
}
