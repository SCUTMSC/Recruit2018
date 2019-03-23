package com.leyou.scm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamVo {
    private Long teamId;
    private String teamName;
    private List<TeamMate> teamMate;

}
