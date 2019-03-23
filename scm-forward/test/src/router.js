import Vue from 'vue'
import Router from 'vue-router'

import Admin from './views/Admin'
import Home from './views/Home'
import queryTeam from './components/queryTeam'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: { 
        title:'报名系统'
       }
    },
    {
      path: '/a',
      name: 'querySingleTeam',
      component: queryTeam,
      meta: {
        title: '查询队伍信息'
      }
    },
    {
      path: '/admin',
      component : Admin,
      meta: { 
        title:'后台管理页面'
       }
    }
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (about.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    // }
  ]
})