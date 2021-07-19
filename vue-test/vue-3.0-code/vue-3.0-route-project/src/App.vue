<template>
  <div>
    <div id="nav">
      <!--      <router-link to="/home">首页</router-link>-->
      <!--      <router-link to="/mine">我的</router-link>-->
      <!--      <button @click="home">首页</button>-->
      <!--      <button @click="mine">我的</button>-->

      <router-link to="/home">首页</router-link>
      <router-link to="/mine">我的</router-link>
      <!--      <router-link :to="'/news/' + newsId">新闻</router-link>-->
      <!--      <router-link :to="{path: '/circle',query: {name:'Chloe',site:'Chloe.com'}}">圈子</router-link>-->

      <button @click="news">新闻</button>
      <button @click="circle">圈子</button>

      <!--      <router-view/>-->
      <router-view v-slot="{Component}">
        <keep-alive>
          <component :is="Component"/>
        </keep-alive>
      </router-view>
    </div>
  </div>
</template>

<script>
import router from "./router";
import {useRouter} from 'vue-router';
import {ref} from 'vue';

export default {
  setup() {
    const newsId = ref('Chloe001');

    const routers = useRouter();

    const home = () => {
      router.push('/home');
    };

    const mine = () => {
      router.push('/mine');
    };

    const news = () => {
      routers.push('/news/' + newsId.value);
    };

    const circle = () => {
      routers.push({path: '/circle', query: {name: 'Chloe', site: 'Chloe.com'}});
    };


    return {
      home,
      mine,
      news,
      circle,

      newsId,
    }
  }
}
</script>
<style>
.router-link-active {
  font-size: 18px;
  color: greenyellow;
  font-weight: bolder;
}
</style>
