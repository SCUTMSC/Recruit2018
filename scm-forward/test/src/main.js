import Vue from 'vue'
import './plugins/axios'
import './plugins/vuetify'
import App from './App.vue'
import store from './store'
import router from './router'


Vue.config.productionTip = false
router.beforeEach((to, from, next) => {//beforeEach是router的钩子函数，在进入路由前执行
  if (to.meta.title) {//判断是否有标题
    document.title = to.meta.title
  }
  next()//执行进入路由，如果不写就不会进入目标页
})
new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')

//定义全局过滤器 开始
import Moment from 'moment'



