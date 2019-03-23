package com.leyou.scm.pojo;

import lombok.Data;

import java.util.List;

@Data
public class QueryTeamVO {
    String teamName;
    String captainId;
    String captainName;
    List<QueryTeammateVO>teamMates;
}
