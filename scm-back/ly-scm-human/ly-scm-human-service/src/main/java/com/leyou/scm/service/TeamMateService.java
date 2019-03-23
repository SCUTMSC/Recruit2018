package com.leyou.scm.service;

import com.leyou.scm.common.enums.ExceptionEnum;
import com.leyou.scm.common.exception.ScmException;
import com.leyou.scm.mapper.TeamMateMapper;
import com.leyou.scm.pojo.TeamMate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamMateService {
    @Autowired
    private TeamMateMapper teamMateMapper;

    public List<TeamMate> findTeamMateByTeamId(Long teamId){

        TeamMate teamMateExample = new TeamMate();
        teamMateExample.setTeamId(teamId);
        //Example example = new Example(teamMateExample.getClass());

        List<TeamMate> result = teamMateMapper.select(teamMateExample);

        return result;
    }

    public List<String> findAllTeamId(){
        List<TeamMate> teamMates= teamMateMapper.selectAll();
        List<String> teamMatesIds = new ArrayList<String>();
        for(TeamMate teamMate:teamMates){
            teamMatesIds.add(teamMate.getStudentId());
        }
        return teamMatesIds;
    }

    @Transactional
    public void addSingleTeamMate(TeamMate teamMate){
        int flag = 0;
        List<String> allTeamId = findAllTeamId();

        if(teamMate.getName() != "" && teamMate.getStudentId() != "") {
            for (String string : allTeamId) {
                if (string.equals(teamMate.getStudentId())) {
                    throw new ScmException(ExceptionEnum.TEAM_MATE_EXISTED);
                }
            }
            if (teamMateMapper.insert(teamMate) != 1) {
                throw new ScmException(ExceptionEnum.TEAM_MATE_INSERT_ERROR);
            }
        }

    }


}
