import Vue from 'vue'
import Router from 'vue-router'
import BackList from "../components/BackList.vue";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'BackList',
      component: BackList
    }
  ]
})
