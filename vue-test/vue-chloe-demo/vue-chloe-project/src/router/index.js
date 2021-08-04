import {createRouter, createWebHashHistory} from "vue-router";
import store from "../store";
import Cookies from "js-cookie";

const routes = [
    {path: '/', redirect: 'login'},
    {path: '/login', name: 'login', component: () => import('@/login/Login.vue')},
    {path: '/home', name: 'home', component: () => import('@/home/Home.vue')},
];

const router = createRouter({
    history: createWebHashHistory(),
    routes
});

router.beforeEach((to, from, next) => {
    let token = Cookies.get('token');
    if (token && to.name === 'login') {
        store.commit("setToken",token);
        console.log('Chloe2',store.state.user.token)
        next({
            name: 'home',
        })
    } else {
        next();
    }
})
export default router;