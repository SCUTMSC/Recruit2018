package com.leyou.scm.mapper;

import com.leyou.scm.pojo.TeamMate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TeamMateMapper extends Mapper<TeamMate> {

    @Insert("INSERT INTO teammate (name,student_id,team_id,is_captain,phone,wechat) VALUES(#{name},#{studentId},#{teamId},#{isCaptain},#{phone},#{wechat}) ")
    int insertTeamMates(@Param("name") String name,@Param("studentId") String studentId,@Param("teamId") String teamId,@Param("isCaptain") int isCaptain,@Param("phone") String phone,@Param("wechcat")String wechat);

}
