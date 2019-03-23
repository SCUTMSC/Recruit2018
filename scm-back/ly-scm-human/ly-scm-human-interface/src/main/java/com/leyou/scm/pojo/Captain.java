package com.leyou.scm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Captain {
    private String name;
    private String captainId;
    private int teamId;
    private String wechat;
    private String phone;
    private boolean isCaptain;
}
