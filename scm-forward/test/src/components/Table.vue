<template>
  <div>
    
          <v-data-table
            :headers="headers"
            :items="items"
            class="elevation-1"
            select-all
            :search="this.$root.search"
            no-results-text="未查询到数据,请尝试点击{查询}"
          >
            <template v-slot:items="props">
              <td>
                <v-checkbox primary hide-details></v-checkbox>
              </td>
              <td>{{ props.item.name }}</td>
              <td class="text-xs-left">{{ props.item.a }}</td>
              <td class="text-xs-left">{{ props.item.b }}</td>
              <td class="text-xs-left">{{ props.item.c }}</td>
              <td class="text-xs-left">{{ props.item.d }}</td>
              <td class="text-xs-left">{{ props.item.e }}</td>
              <td>
                <v-btn icon>
                  <v-icon left>edit</v-icon>
                </v-btn>
              </td>
              <td>
                <v-btn icon>
                  <v-icon left>delete</v-icon>
                </v-btn>
              </td>
            </template>
          </v-data-table>
          <br>
          <br>
          <v-flex xs2 right>
            <v-btn color="red">删除所选项</v-btn>
          </v-flex>

  </div>
</template>
<script>
export default {
  data() {
    return {
      headers: [
        {
          text: "社团名称",
          align: "left",
          value: "name"
        },
        { text: "报名人数", value: "a" },
        { text: "活动个数", value: "b" },
        { text: "社团人数", value: "c" },
        { text: "社长", value: "d" },
        { text: "电话", value: "e" },
        { text: "修改", value: "f" },
        { text: "删除", value: "g" }
      ],
      items: [
        {
          name: "aaaaaa",
          a: 159,
          b: 10,
          c: 200,
          d: "xxx",
          e: 456
        },
        {
          name: "bb",
          a: 123,
          b: 10,
          c: 332,
          d: "xxx",
          e: 123136
        },
        {
          name: "bb",
          a: 123,
          b: 10,
          c: 332,
          d: "xxx",
          e: 123136
        },
        {
          name: "bb",
          a: 123,
          b: 10,
          c: 332,
          d: "xxx",
          e: 123136
        },
        {
          name: "bb",
          a: 123,
          b: 10,
          c: 332,
          d: "xxx",
          e: 123136
        },
        {
          name: "bb",
          a: 123,
          b: 10,
          c: 332,
          d: "xxx",
          e: 123136
        }
      ]
    };
  }
};
</script>