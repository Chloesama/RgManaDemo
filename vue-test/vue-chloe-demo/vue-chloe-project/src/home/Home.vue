<template>
  <div>
    这是是首页!!!
  </div>
</template>

<script>
import ajaxUtil from "@/util/AjaxUtil.js";
import {useStore} from 'vuex';
export default {
  name: "Home",
  setup(){
    const store = useStore();
  }
}
</script>

<style scoped>

</style>