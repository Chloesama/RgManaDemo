<template>
  <div>
    <Header/>
    <List/>
    <Footer/>
  </div>
</template>

<script>
import Header from "./components/Header.vue";
import List from "./components/List.vue";
import Footer from "./components/Footer.vue";

import {reactive, provide} from 'vue';

export default {
  setup() {
    let todos = reactive([
      {
        title: '打一场羽毛球',
        finished: false,
      },
      {
        title: '打一场兵乓球',
        finished: false,
      },
      {
        title: '打一场篮球',
        finished: false,
      },
    ]);

    const delTodoWithIndex = (index) => {
      todos.splice(index, 1);
    };
    const addItem = (todo) => {
      todos.unshift(todo);
    };
    const selectedAllTodo = (isCheck) => {
      todos.forEach(todo => {
        todo.finished = isCheck;
      })
    };
    const delFinishedTodos = () => {
      for (let i = todos.length - 1; i >= 0; i--) {
        if (todos[i].finished) {
          todos.splice(i, 1);
        }
      }
    }

    provide('todos', todos);
    provide('delTodo', delTodoWithIndex);
    provide('addItem', addItem);
    provide('selectedAllTodo', selectedAllTodo);
    provide('delFinishedTodos', delFinishedTodos);
  },
  components: {
    Header,
    List,
    Footer,
  }
}
</script>

<style>
</style>
