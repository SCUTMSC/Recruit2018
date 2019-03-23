<template>
  <div>
    <v-app>
      <v-navigation-drawer v-model="drawer" clipped fixed app>
        <v-list dense>
          <v-list-tile @click="menuValue(i)" v-for="(item, i) in items1" :key="i">
            <v-list-tile-action>
              <v-icon>{{item.icon}}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>{{item.title}}</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </v-list>
      </v-navigation-drawer>

      <v-toolbar app fixed clipped-left>
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
        <v-flex md5>
          <v-toolbar-title>xx社团后台系统</v-toolbar-title>
        </v-flex>
                <v-flex md5 mr-5>
          <v-text-field
            solo-inverted
            prepend-inner-icon="search"
            label="请输入查询内容"
            color="red"
            :background-color="searchBgc"
            @mouseenter="searchBgc = 'white'"
            @mouseleave="searchBgc='cyan darken-3'"
            v-model="search"
          ></v-text-field>
        </v-flex>
        <v-btn color="red darken-2" @click="searchBgc = 'cyan darken-3'">查询</v-btn>
      </v-toolbar>
<v-content>
      <v-container fluid fill-height>
        <v-layout justify-center align-center>
          <v-flex shrink>
            <v-tooltip >
              <template v-slot:activator="{ on }">
                <Table></Table>
              </template>
            </v-tooltip>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>

    </v-app>
  </div>
</template>
<script>
import Table from "../components/Table";

export default {
  methods: {

  },
  components: {
    Table
  },
  data() {
    return {
      componentId: "",
      drawer: true,
      search: "",
      searchBgc: "cyan darken-3",
      items1: [
        { icon: "dashboard", title: "报名管理" },
        { icon: "dashboard", title: "所有信息" },
        { icon: "account_box", title: "社团信息" },
        { icon: "accessibility", title: "人员信息" },
        { icon: "info", title: "其它信息" }
      ]
    };
  }
};
</script>