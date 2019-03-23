package com.leyou.scm.mapper;

import com.leyou.scm.pojo.Team;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TeamMapper extends Mapper<Team> {
    @Insert("INSERT INTO team (team_name,team_id,) VALUES(#{teamId},#{teamName})")
    int insertSingleTeam(@Param("teamId")Long teamId,@Param("teamName") String teamName);
}
