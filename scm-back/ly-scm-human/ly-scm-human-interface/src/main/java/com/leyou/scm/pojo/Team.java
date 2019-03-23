package com.leyou.scm.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="team")
public class Team {


    private String teamName;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long teamId;

}
