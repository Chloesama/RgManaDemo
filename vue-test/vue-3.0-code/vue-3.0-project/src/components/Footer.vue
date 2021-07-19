<template>
  <div>
    <label>
      <input type="checkbox" v-model="isChecked"/>
    </label>
    <span>
      <span>已完成{{ finishedCount }}件</span> / 总计{{ todos.length }}件
    </span>
    <button @click="delFinishedTodos">清除已完成任务</button>
  </div>
</template>

<script setup>
import {inject, computed,unref} from 'vue';

const todos = inject('todos');
const selectedAllTodo = inject('selectedAllTodo');
const delFinishedTodos = inject('delFinishedTodos');

let finishedCount = computed(() => {
  return todos.reduce((total, todo) => {
    return total + (todo.finished ? 1 : 0)
  }, 0);
});

let isChecked = computed({
  get() {
    // return finishedCount.value === todos.length && todos.length > 0;
    return unref(finishedCount) === todos.length && todos.length > 0;
  },
  set(value) {
    selectedAllTodo(value);
  },
});

</script>

<style scoped>

</style>