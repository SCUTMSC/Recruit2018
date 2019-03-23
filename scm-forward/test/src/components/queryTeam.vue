<template>
  <div>
    <v-container fluid fill-height>
      <v-layout column>
        <v-text-field name="teamName" label="队伍名字" v-model="queryTeamInfo.teamName" solo></v-text-field>
        <v-text-field name="captainId" label="队长学号" v-model="queryTeamInfo.captainId" solo></v-text-field>
      </v-layout>
      <v-btn color="red" @click="submit()">查询</v-btn>
    </v-container>
    <!-- <div v-show="isShow"> -->
    <!-- <div v-show="isShow" class="teamList">
      <div align-center>
        <h3 class="headline mb-0">所查询的队伍信息</h3>
        <div>队长学号</div>
        <div v-text="teamReturn.captainId"></div>
        <div>队长姓名</div>
        <div v-text="teamReturn.captainName"></div>
        <div v-for="(teamMate,index) in teamReturn.teamMates" :key="index">
          <div>队员学号</div>
          <div v-text="teamMate.studentId"></div>
          <div>队员姓名</div>
          <div v-text="teamMate.name"></div>
        </div>
      </div>
    </div>-->
    <br>
    <br>
    <v-layout justify-center v-show="isShow">
      <table border="1" style="text-align: center; background-image: url('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553315180560&di=f94ab21ffaae4f5bc9a88044611cb168&imgtype=0&src=http%3A%2F%2Fbpic.ooopic.com%2F16%2F69%2F45%2F16694596-b5d9e462a1d2bd7b9dc445b2650e5a88-0.jpg')" >
        <tr>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
          <td><h1>姓名</h1></td>
          <td><h1>学号</h1></td>
        </tr>
        <tr>
          <td><h1>队长</h1></td>
          <td><h2>{{teamReturn.captainName}}</h2></td>
          <td><h2>{{teamReturn.captainId}}</h2></td>
        </tr>
        <tr v-for="(teamMate,index) in teamReturn.teamMates" :key="index">
          <td><h1>队员{{index+1}}</h1></td>
          <td><h2>{{teamMate.name}}</h2></td>
          <td><h2>{{teamMate.studentId}}</h2></td>
        </tr>
      </table>
    </v-layout>

    <!-- <v-layout justify-center>
      <v-flex md8>
        <v-card v-show="isShow">

          <div class="text-md-center">
              <hr>
            <h1>所查询的队伍信息</h1>
            <div>队长姓名</div>
            <div v-html="teamReturn.captainName"></div>
            <div>队长学号</div>
            <div v-html="teamReturn.captainId"></div>
            <div v-for="(teamMate,index) in teamReturn.teamMates" :key="index">
              <div>队员姓名</div>
              <div v-html="teamMate.name"></div>
              <div>队员学号</div>
              <div v-html="teamMate.studentId"></div>
            </div>
          </div>
        </v-card>
      </v-flex>
    </v-layout>-->
  </div>
</template>

<style>
tr {
    height: 100px;
}
td {
  width: 200px;
}
</style>




<script>
export default {
  data() {
    return {
      msg: null,
      dialog: true,
      teamName: "",
      captainId: "",
      isShow: false,
      queryTeamInfo: {
        teamName: "",
        captainId: ""
      },
      teamReturn: {
        teamName: "",
        captainId: "",
        captainName: "",
        teamMates: [
          {
            name: "",
            studentId: ""
          },
          {
            name: "",
            teamId: ""
          },
          {
            name: "",
            teamId: ""
          },
          {
            name: "",
            teamId: ""
          }
        ]
      }
    };
  },
  methods: {
    submit() {
      console.log(this.queryTeamInfo);
      this.axios
        .post(this.$store.state.url.queryTeamUrl, this.queryTeamInfo)
        .then(res => {

          this.msg = res.data.msg;
          if (this.msg == null) {

            this.isShow = true;

            this.teamReturn.teamName = res.data.teamName;
            this.teamReturn.captainId = res.data.captainId;
            this.teamReturn.captainName = res.data.captainName;
            this.teamReturn.teamMates = res.data.teamMates;
          } else {
            this.isShow = false;
            alert(this.msg);
          }
        });
    }
  },

  computed: {
    TeamReturn() {
      return this.TeamReturn;
    }
  }
};
</script>
