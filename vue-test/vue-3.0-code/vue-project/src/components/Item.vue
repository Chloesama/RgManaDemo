<template>
  <div>
    <li
        @mouseenter="dealShow(true)"
        @mouseleave="dealShow(false)"
        :style="{backgroundColor: bgColor}"
    >
      <label>
        <input type="checkbox" v-model="todo.finished"/>
        <span>{{ todo.title }}</span>
      </label>
      <button v-show="isShowDel" @click="delItem">删除</button>
    </li>
  </div>
</template>

<script>
export default {
  name: "Item",
  props: {
    todo: Object,
    index: Number,
    delTodo: Function,
  },
  data() {
    return {
      isShowDel: false,
      bgColor: '#fff',
    }
  },
  methods: {
    dealShow(isShow) {
      this.isShowDel = isShow;
      this.bgColor = isShow ? '#ddd' : '#fff';
    },
    delItem() {
      if (window.confirm(`您确定删除吗?`)) {
        this.delTodo(this.index);
      }
    },
  }
}
</script>

<style scoped>

</style>