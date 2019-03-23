<template>
  <div>
    <v-app>
      <v-container grid-list-xs>
        <v-layout>
          <v-img
            src="http://a1.qpic.cn/psb?/V138ROz74eGpB0/A6oKoaNUUyZVo7NObjMB1VQchqlbDBX0J*EgLAvDiYw!/b/dMAAAAAAAAAA&ek=1&kp=1&pt=0&bo=IAPjAAAAAAARF.A!&tl=3&vuin=2640558211&tm=1553306400&sce=60-2-2&rf=viewer_4"
          ></v-img>
        </v-layout>
      </v-container>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex md10>
            <v-tabs color="teal lighten-3" icons-and-text fixed-tabs>
              <v-alert color="yellow" class="black--text" value="true">报名系统</v-alert>

              <v-tab>创建队伍
                <v-icon>group</v-icon>
              </v-tab>
              <v-tab-item>
                <v-text-field label="队伍名称" type="text" v-model="teamName.teamName"></v-text-field>
                <v-text-field label="队长姓名" type="text" v-model="captain.name"></v-text-field>
                <v-text-field label="队长学号" type="text" v-model="captain.studentId"></v-text-field>
                <v-text-field label="电话" type="text" v-model="captain.phone"></v-text-field>
                <v-text-field label="QQ" type="text" v-model="captain.wechat"></v-text-field>
                <v-btn color="red" @click="submitValue">提交</v-btn>
                <v-progress-linear color="red" :indeterminate="indeterminate" v-show="showProgress"></v-progress-linear>
              </v-tab-item>

              <template v-for="(t,i) in memberInfo">
                <v-tab :key="i">
                  队员{{i+1}}
                  <v-icon>person_add</v-icon>
                </v-tab>
                <v-tab-item :key="i">
                  <div>
                    <h2>队员的电话QQ可不填写</h2>
                  </div>
                  <v-text-field label="姓名" type="text" v-model="t.name"></v-text-field>
                  <v-text-field label="学号" type="text" v-model="t.studentId"></v-text-field>
                  <v-text-field label="电话" type="text" v-model="t.phone"></v-text-field>
                  <v-text-field label="QQ" type="text" v-model="t.wechat"></v-text-field>
                </v-tab-item>
              </template>

              <v-tab @click="gotoQuery">查询自己队伍信息
                <v-icon>search</v-icon>
              </v-tab>
            </v-tabs>

            <v-dialog v-model="dialog" max-width="500">
              <v-card>
                <v-card-title class="headline grey lighten-2" primary-title>恭喜</v-card-title>

                <v-card-text>恭喜{{teamName.teamName}}，报名成功！</v-card-text>

                <v-divider></v-divider>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="primary" flat @click="showMessage">我知道了</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
            <v-dialog v-model="dialog1" max-width="500">
              <v-card>
                <v-card-title class="headline grey lighten-2" primary-title>注意:</v-card-title>

                <v-card-text>{{message}}</v-card-text>

                <v-divider></v-divider>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="primary" flat @click="dialog1 = false">我知道了</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
            <v-dialog v-model="dialog2" max-width="500">
              <v-card>
                <v-card-title class="headline grey lighten-2" primary-title>上传文件:
                  <v-btn round dark @click="dialog2 = false">关闭窗口</v-btn>
                </v-card-title>
                <v-card-text>
                  队名:
                  <input style="border:1px solid grey" id="teamName" type="text">
                  <br>
                  <br>
                  <input name="file" type="file" id="upload">
                </v-card-text>

                <v-divider></v-divider>

                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn dark @click="uploadFile" round>开始上传</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-flex>
        </v-layout>
      </v-container>
      <v-layout justify-center mb-5>
        <v-btn style="background-color:	Chartreuse" color="black--text" @click="dialog2 = true">提交作品</v-btn>
      </v-layout>
    </v-app>
  </div>
</template>
<script>
import pic1 from "../assets/pic1.png";

export default {
  mounted() {
    // this.init();
  },
  computed: {
    memberInfo() {
      return [
        this.$store.state.TeamInfo.teamMate[1],
        this.$store.state.TeamInfo.teamMate[2],
        this.$store.state.TeamInfo.teamMate[3]
      ];
    },
    captain() {
      return this.$store.state.TeamInfo.teamMate[0];
    },
    teamName() {
      return this.$store.state.TeamInfo;
    }
  },
  data() {
    return {
      dialog: false,
      dialog1: false,
      dialog2: false,
      indeterminate: false,
      showProgress: false,
      message: "请补全未输入的数据！",
      ifBeigin: true,
      ifEnd: true
    };
  },
  methods: {
    submitValue() {
      this.message = "请补全未输入的数据！";
      if (this.dataComparison() == true) {
        //发送state里面的数据
        // console.log(this.$store.state);
        this.axios
          .post(
            this.$store.state.url.submitValueUrl,
            this.$store.state.TeamInfo
          )
          .then(response => {
            //  console.log(response);//下面修改下获取的数据的变量名
            if (response.data == "") {
              this.dialog = true;
            } else {
              this.$store.state.return.msg = response.data.msg;
              this.message = this.$store.state.return.msg;
              this.dialog1 = true;
            }
          });
      } else {
        // console.log("数据有问题");
        this.dialog1 = true;
      }
    },
    showMessage() {
      this.dialog = false;
      this.dialog1 = false;
      // console.log(this.$store.state.return.msg);
      if (this.$store.state.return.msg == "")
        //下面修改下报名成功跳转的页面
        window.location.href = this.$store.state.url.adminUrl;
    },
    uploadFile() {
      var timeStatus = 0;
      var date = new Date();

      
     

      if(this.$store.state.fileTime.beginTime){
        console.log(111);
        if(date<this.$store.state.fileTime.beginTime){
          console.log(date);
         // console.log(this.$store.state.fileTime.beginTime);
          console.log(11);
          timeStatus = 1;
        }
      }

      if(this.$store.state.fileTime.endTime&&date>this.$store.state.fileTime.endTime){
        console.log(222);
        timeStatus = 2;
      }

      if(timeStatus==2){
        alert("提交时间已经结束");
      }
      else if(timeStatus==1){
        alert("提交时间还未开始");
      }
      else if(timeStatus==0){
        let file = document.getElementById("upload").files[0];
        let teamName = document.getElementById("teamName").value;
        let param = new FormData(); //创建form对象
        param.append("teamName", teamName); //把队伍名也传过去
        param.append("file", file); //通过append向form对象添加数据
        console.log(param.get("teamName")); //FormData私有类对象，访问不到，可以通过get判断值是否传进去
        console.log(param.get("file")); //FormData私有类对象，访问不到，可以通过get判断值是否传进去
        // let config = {
        //   headers: { "Content-Type": "multipart/form-data" }
        // }; //添加请求头
        this.dialog2 = false;
        this.indeterminate = true;
        this.showProgress = true;
        this.axios
          .post(this.$store.state.url.uploadFileUrl, param)
          .then(response => {
            console.log(response);
            this.$store.state.return.msg = response.data;
            console.log(this.$store.state.return.msg);
            if (this.$store.state.return.msg == "文件上传成功") {
              this.message = "文件上传成功";
              this.dialog1 = true;
              this.indeterminate = false;
              this.showProgress = false;
            } else {
              console.log("走else");
              this.message = response.data.msg;
              this.indeterminate = false;
              this.showProgress = false;
              this.dialog1 = true;
            }
        })
        .catch(error => {
          console.log("走err");
          this.message = "上传错误";
          this.indeterminate = false;
          this.showProgress = false;
          this.dialog1 = true;
        });
      }
    },
    dataComparison() {
      let teamName = this.$store.state.TeamInfo.teamName;
      if (teamName != null && teamName != "") {
        for (let i = 0; i < 3; i++) {
          let obj = this.$store.state.TeamInfo.teamMate[i];
          var objArray = Object.keys(obj);
          for (let j = 0; j < objArray.length; j++) {
            // console.log(i + objArray[j] + ":" + obj[objArray[j]]);
            if (obj[objArray[j]] == "") {
              if (
                objArray[j] != "phone" &&
                objArray[j] != "wechat" &&
                objArray[j] != "teamId"
              ) {
                // console.log("有空数据，返回false");
                return false;
              }
            }
          }
        }
        // console.log("数据都不为空，返回true");
        return true;
      } else {
        // console.log("没有队伍名字，返回false");
        return false;
      }
    },
    init() {
      // console.log(this.$store.state.TeamInfo.teamMate);
    },
    gotoQuery() {
      this.$router.push({ name: "querySingleTeam" });
    },
    timeTest(){
      var date1 = new Date(2018,1,15);
      var date2 = new Date(2018,3,2);
      console.log(date1<date2);

    }
  }
};
</script>