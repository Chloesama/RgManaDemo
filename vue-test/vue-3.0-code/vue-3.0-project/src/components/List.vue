<template>
  <div>
    <Item
        v-for="(todo,index) in todos"
        :key="index"
        :todo="todo"
        :index="index"
    />
  </div>
</template>

<script>
import Item from "./Item.vue";

import {inject} from 'vue';

export default {
  name: "List",
  setup(){
    const todos = inject('todos');

    return {
      todos,
    }
  },
  components: {
    Item
  }
}
</script>

<style scoped>

</style>