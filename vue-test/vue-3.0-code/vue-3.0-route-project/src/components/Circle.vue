<template>
  <div id="circle">
    <p>圈子</p>
    <p>{{$route.query}}</p>
    <p>{{$route.query.name}}</p>
    <p>{{$route.query.site}}</p>
  </div>
</template>

<script>
import {useRoute} from 'vue-router';
export default {
  name: "Circle",
  setup(){
    const route = useRoute();
    console.log(route.query);
    console.log(route.query.name);
    console.log(route.query.site);
  }
}
</script>

<style scoped>
#circle{
  width: 400px;
  height: 600px;
  background-color: cadetblue;
}
</style>