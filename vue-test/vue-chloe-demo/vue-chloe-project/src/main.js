import {createApp} from 'vue';
import App from './App.vue';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css'
import router from "./router";
import store from "./store";


const app = createApp(App);
app.use(Antd);
app.use(router);
app.use(store);

app.directive('icon-input-focus', {
    mounted(el, num) {
        // 聚焦元素
        el.childNodes.forEach(node => {
            if((node.nodeName).toUpperCase() === 'INPUT'){
                node.focus();
                return ;
            }
        })

    }
});

app.directive('focus', {
    mounted(el, num) {
        el.focus();
    }
})

app.mount('#app')
