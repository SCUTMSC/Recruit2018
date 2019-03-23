package com.leyou.scm.service;

import com.leyou.scm.common.enums.ExceptionEnum;
import com.leyou.scm.common.exception.ScmException;
import com.leyou.scm.mapper.TeamMapper;
import com.leyou.scm.mapper.TeamMateMapper;
import com.leyou.scm.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class TeamService {
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private TeamMateService teamMateService;
    @Autowired
    private TeamMateMapper teamMateMapper;

    //返回TeamVo的视图，用于给后台显示数据
    public List<TeamVo> findAllTeams(){
        List<TeamVo> teamVoList = new ArrayList<TeamVo>();
        List<Team> teams = teamMapper.selectAll();
        List<TeamMate> teamMates = null;
        for(Team team:teams){

            Long teamId = team.getTeamId();
            TeamVo teamVo = new TeamVo();
            teamVo.setTeamId(teamId);
            teamVo.setTeamName(team.getTeamName());
            teamMates = teamMateService.findTeamMateByTeamId(teamId);
            teamVo.setTeamMate(teamMates);
            teamVoList.add(teamVo);
        }
        return teamVoList;
    }

    //仅用于查询team这张表，用于service内部查重
    public List<Team> findAllTeamForm(){
        return teamMapper.selectAll();
    }

    @Transactional
    public void addSingleTeam(TeamVo teamVo){
        List<Team> allTeamForm = findAllTeamForm();
        Team team = new Team();
        team.setTeamName(teamVo.getTeamName());
        int flag = 0;



        team.setTeamId(null);
        for(Team ateam:allTeamForm){
            if( ateam.getTeamName().equals(team.getTeamName()) ){
                flag = 1;
            }
        }
        if(flag == 1){
            throw new ScmException(ExceptionEnum.TEAM_NAME_CONFLICT);
        }
        else{
            int count = teamMapper.insert(team);
            if(count != 1)throw new ScmException(ExceptionEnum.TEAM_INSERT_ERROR);
        }

        List<TeamMate> teamMates = teamVo.getTeamMate();
        for(TeamMate teamMate:teamMates){
            teamMate.setTeamId((team.getTeamId()));
            teamMateService.addSingleTeamMate(teamMate);
        }

    }

    public List<String>findAllTeamsName(){
        List<Team>teams = findAllTeamForm();
        List<String> teamNames = new ArrayList<String>();
        for(Team team:teams){
            teamNames.add(team.getTeamName());
        }
        return teamNames;
    }


    public QueryTeamVO querySingleTeam(QueryTeamDTO queryTeamDTO){
        QueryTeamVO queryTeamVO = new QueryTeamVO();
        Team team = new Team();
        String captainId = queryTeamDTO.getCaptainId();
        team.setTeamName(queryTeamDTO.getTeamName());
        List<Team> teams = teamMapper.select(team);
        if(teams.isEmpty()) {
            throw new ScmException(ExceptionEnum.TEAM_NOT_FOUND);
        }
        Long teamId = teams.get(0).getTeamId();

        List<TeamMate> teamMates = null;
        teamMates = teamMateService.findTeamMateByTeamId(teamId);

        for(TeamMate teamMate:teamMates){
            if(teamMate.getIsCaptain() == 1){
                if(!teamMate.getStudentId().equals(captainId)){
                    throw new ScmException(ExceptionEnum.TEAM_NOT_MATCH);
                }
                else{
                    queryTeamVO.setCaptainId(teamMate.getStudentId());
                    queryTeamVO.setCaptainName(teamMate.getName());
                }
            }
            else{
                QueryTeammateVO queryTeammateVO = new QueryTeammateVO();
                queryTeammateVO.setName(teamMate.getName());
                queryTeammateVO.setStudentId(teamMate.getStudentId());
                if(queryTeamVO.getTeamMates()==null)queryTeamVO.setTeamMates(new ArrayList<QueryTeammateVO>());
                queryTeamVO.getTeamMates().add(queryTeammateVO);

            }
        }

        queryTeamVO.setTeamName(queryTeamDTO.getTeamName());
        return queryTeamVO;
    }


}
