//1.引入
import {createRouter, createWebHashHistory} from 'vue-router';

import Home from '../components/Home.vue';
import Mine from '../components/Mine.vue';
import News from "../components/News.vue";

import MineMsg from "../components/MineMsg.vue";
import MineOrder from "../components/MineOrder.vue";
import Circle from "../components/Circle.vue";

//理由懒加载
// const Home = () => import('../components/Home.vue');
// const Mine = () => import('../components/Mine.vue');
// const News = () => import('../components/News.vue');

//2.创建路由对象
const routes = [
    {path: '/', redirect: '/home'},
    {path: '/home', component: Home, meta: {title: '首页'}},
    {
        path: '/mine',
        component: Mine,
        meta: {title: '我的'},
        children: [
            {path: '/mine', redirect: "/mine/order"},
            {path: 'msg', component: MineMsg, meta: {title: '我的消息'}},
            {path: 'order', component: MineOrder, meta: {title: '我的订单'}},
        ],
    },
    {path: '/news/:id', component: News, meta: {title: '新闻'}},
    {path: '/circle', component: Circle, meta: {title: '圈子'}},
];

// const routes = [
//     {path: '/', redirect: '/home'},
//     {path: '/home', component: () => import('../components/Home.vue')},
//     {path: '/mine', component: () => import('../components/Mine.vue')},
//     {path: '/news/:id', component: () => import('../components/News.vue')},
// ];

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
});

//全局路由的前置守卫
router.beforeEach((to, from, next) => {
    // console.log("从哪里来", from);
    // console.log("到哪里去", to);
    // document.title = to.meta.title;
    next();
})

router.afterEach((to, from) => {
    document.title = to.meta.title;
})

//3.导出路由对象
export default router;