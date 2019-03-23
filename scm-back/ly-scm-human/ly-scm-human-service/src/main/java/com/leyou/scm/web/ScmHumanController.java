package com.leyou.scm.web;

import com.leyou.scm.pojo.Team;
import com.leyou.scm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("human")
@CrossOrigin(origins="*",allowCredentials="true",maxAge=3600)
public class ScmHumanController {
        @Autowired
        private TeamService teamService;

        @RequestMapping
        public ResponseEntity<Team> saveTeam(Team team){
            return null;
        }



}
