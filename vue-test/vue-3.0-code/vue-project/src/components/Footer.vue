<template>
  <div>
    <label>
      <input type="checkbox" v-model="isChecked"/>
    </label>
    <span>
      <span>已完成{{finishedCount}}件</span> / 总计{{ todos.length }}件
    </span>
    <button @click="delFinishedTodos">清除已完成任务</button>
  </div>
</template>

<script>
export default {
  name: "Footer",
  props: {
    todos: Array,
    selectedAllTodo: Function,
    delFinishedTodos: Function,
  },
  computed: {
    finishedCount() {
      return this.todos.reduce((total, todo) => {
        return total + (todo.finished ? 1 : 0)
      },0)
    },
    isChecked:{
      get(){
        return this.finishedCount === this.todos.length && this.todos.length > 0;
      },
      set(value){
        this.selectedAllTodo(value);
      },
    }
  },
  data() {
    return {}
  }
}
</script>

<style scoped>

</style>