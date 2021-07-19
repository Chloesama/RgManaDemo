<template>
  <div>
    <Item
        v-for="(todo,index) in todos"
        :key="index"
        :todo="todo"
        :index="index"
        :del-todo="delTodo"
    />
  </div>
</template>

<script>
import Item from "./Item.vue";

export default {
  name: "List",
  props: {
    todos: Array,
    delTodo: Function,
  },
  data() {
    return {}
  },
  components: {
    Item
  }
}
</script>

<style scoped>

</style>