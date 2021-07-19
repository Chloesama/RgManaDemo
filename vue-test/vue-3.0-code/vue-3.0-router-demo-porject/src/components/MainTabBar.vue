<template>
  <div>
    <TabBar>
      <TabBarItem path="/home" selectColor="pink">
        <template v-slot:item-title>
          <div>首页</div>
        </template>
      </TabBarItem>
      <TabBarItem path="/course" selectColor="pink">
        <template v-slot:item-title>
          <div>课程</div>
        </template>
      </TabBarItem>
      <TabBarItem path="/friends" selectColor="pink">
        <template v-slot:item-title>
          <div>朋友圈</div>
        </template>
      </TabBarItem>
      <TabBarItem path="/study" selectColor="pink">
        <template v-slot:item-title>
          <div>学习</div>
        </template>
      </TabBarItem>
      <TabBarItem path="/mine" selectColor="pink">
        <template v-slot:item-title>
          <div>我的</div>
        </template>
      </TabBarItem>
    </TabBar>
  </div>
</template>

<script>
import TabBarItem from "./tabBar/TabBarItem.vue";
import TabBar from "./tabBar/TabBar.vue";

export default {
  name: "MainTabBar",
  components: {
    TabBarItem,
    TabBar,
  }
}
</script>

<style scoped>

</style>