import Vue from 'vue'
import Router from  'vue-router'
import Login from  './views/login'

Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BABEL_ENV,
    routes: [{
        path: '*',
        redirect: '/login',
    }, {
        path: '/login',
        component: Login
    }]
})
