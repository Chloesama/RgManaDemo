<template>
  <div>
    <router-view></router-view>
    <MainTabBar></MainTabBar>
  </div>
</template>

<script>
import MainTabBar from "./components/MainTabBar.vue";

export default {
  components:{
    MainTabBar,
  }
}
</script>

<style>
@import "assets/css/common.css";
</style>
