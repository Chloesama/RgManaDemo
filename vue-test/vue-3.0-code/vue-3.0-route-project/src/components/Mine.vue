<template>
  <div id="mine">
    <h2>我的</h2>
    <div class="content">
      <div class="content-nav">
        <router-link to="/mine/order">我的订单</router-link><br>
        <router-link to="/mine/msg">我的消息</router-link>
      </div>
      <router-view class="content-list" />
    </div>
  </div>
</template>

<script>
export default {
  name: "Mine"
}
</script>

<style scoped>
#mine{
  width: 400px;
  height: 500px;
  background-color: green;
}
.content{
  display: flex;
}
.content-nav{
  width: 80px;
  background-color: gold;
}
.content-list{
  flex: 1;
}
</style>