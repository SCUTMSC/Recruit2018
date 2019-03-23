<template>
  <div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  components: {},
  methods: {
    send() {
      this.axios
        .post("https://www.baidu.com/img/baidu_jgylogo3.gif")
        .then(function(response) {
          this.$store.state.response = response;
        })
        .catch(function(error) {
          this.$store.state.error = error;
        });
    }
  }
};
</script>