<template>
  <div>
    <Header
        :add-item="addItem"
    />
    <List :todos="todos" :del-todo="delTodoWithIndex"/>
    <Footer
        :todos="todos"
        :selected-all-todo="selectedAllTodo"
        :del-finished-todos="delFinishedTodos"
    />
  </div>
</template>

<script>
import Header from "./components/Header.vue";
import List from "./components/List.vue";
import Footer from "./components/Footer.vue";

export default {
  name: 'app',
  data() {
    return {
      todos: [
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
      ]
    }
  },
  methods: {
    delTodoWithIndex(index) {
      this.todos.splice(index, 1);
    },
    addItem(todo) {
      this.todos.unshift(todo);
    },
    selectedAllTodo(isCheck) {
      this.todos.forEach(todo => {
        todo.finished = isCheck;
      })
    },
    delFinishedTodos() {
      this.todos = this.todos.filter(todo => {
        return !todo.finished;
      })
    }
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
