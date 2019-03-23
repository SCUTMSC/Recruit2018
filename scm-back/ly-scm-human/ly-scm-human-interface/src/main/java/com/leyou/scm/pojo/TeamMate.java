package com.leyou.scm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="teammate")
public class TeamMate {

    private String name;

    private Long teamId;

    private String studentId;

    @Column(name="is_captain")
    private Long isCaptain;

    private String phone;

    private String wechat;
}
