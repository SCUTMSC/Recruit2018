package com.leyou.scm.web;

import com.leyou.scm.pojo.*;
import com.leyou.scm.service.TeamMateService;
import com.leyou.scm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {

    @Autowired
    private TeamMateService teamMateService;

    @Autowired
    private TeamService teamService;

    @RequestMapping("all")
    public ResponseEntity<List<TeamVo>> queryAllTeams(){
        return ResponseEntity.ok(teamService.findAllTeams());
    }

    @PostMapping("addsingle")
    public ResponseEntity<Void> addSingleTeam(@RequestBody TeamVo teamVo){

        //把队伍加入数据库
        Team team = new Team();
        team.setTeamId(teamVo.getTeamId());
        team.setTeamName(teamVo.getTeamName());
        teamService.addSingleTeam(teamVo);



        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin(origins="http://localhost",allowCredentials = "false")
    @PostMapping("querySingleTeam")
    public ResponseEntity<QueryTeamVO> querySingleTeam(@RequestBody QueryTeamDTO queryTeamDTO){
        System.out.println(111);
        QueryTeamVO queryTeamVO = teamService.querySingleTeam(queryTeamDTO);

        return ResponseEntity.status(HttpStatus.OK).body(queryTeamVO);
    }


    @PostMapping("pojotest")
    public ResponseEntity<String> pojoTest(PojoTest pojoTest){
        String a = pojoTest.getId();
        String b = pojoTest.getName();
        System.out.println(pojoTest);
        return ResponseEntity.ok("test");

    }


}
