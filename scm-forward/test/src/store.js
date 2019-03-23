import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  
  state: {
    queryTeamInfo:
    {
      teamName: '',
      teamId: ''
    }
    ,
    fileTime:{
      beginTime:new Date(2019,2,11),
      endTime:new Date(2019,2,21)
    }
    ,
    TeamInfo:
    {
      teamId: '',
      teamName: '',
      teamMate: [
        {
          name: '',
          teamId: '',
          studentId: '',
          isCaptain: '1',
          phone: '',
          wechat: ''
        },
        {
          name: '',
          teamId: '',
          studentId: '',
          isCaptain: '0',
          phone: '',
          wechat: ''
        },
        {
          name: '',
          teamId: '',
          studentId: '',
          isCaptain: '0',
          phone: '',
          wechat: ''
        },
        {
          name: '',
          teamId: '',
          studentId: '',
          isCaptain: '0',
          phone: '',
          wechat: ''
        }
      ]
    },
    url:{
      adminUrl:'http://localhost:80/admin',
      submitValueUrl:'http://112.74.162.78:10010/scm/api/human/team/addsingle',
      uploadFileUrl:'http://112.74.162.78:10010/scm/api/file/upload/rar',
      queryTeamUrl:'http://localhost:8081/team/querySingleTeam'
    },
    return:{
      msg:''
    }
  },
  getters: {

  },
  mutations: {

  },
  actions: {

  }
})
