import {createRouter, createWebHashHistory} from 'vue-router';

const Home = () => import("../pages/home/Home.vue");
const Course = () => import("../pages/course/Course.vue");
const Friends = () => import("../pages/friends/Friends.vue");
const Study = () => import("../pages/study/Study.vue");
const Mine = () => import("../pages/mine/Mine.vue");

const routes = [
    {path: '/', redirect: '/home'},
    {path:'/home',component:Home},
    {path:'/course',component:Course},
    {path:'/friends',component:Friends},
    {path:'/study',component:Study},
    {path:'/mine',component:Mine},
];
const router = createRouter({
    history: createWebHashHistory(),
    routes:routes
});

export default router;