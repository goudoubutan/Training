import Vue from 'vue'
import Router from 'vue-router'
import BackList from "../components/BackList.vue";
import FoodList from "../components/FoodList.vue";

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   name: 'BackList',
    //   component: BackList
    // },
    {
      path: '/',
      name: 'FoodList',
      component: FoodList
    }
  ]
})
