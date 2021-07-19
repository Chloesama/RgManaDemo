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
import {inject, ref} from 'vue';

export default {
  name: "Item",
  props: {
    todo: Object,
  },
  setup(props, context) {
    const delTodo = inject('delTodo');

    let isShowDel = ref(false);
    let bgColor = ref('#fff');

    const dealShow = (isShow) => {
      isShowDel.value = isShow;
      bgColor.value = isShow ? '#ddd' : '#fff';
    };
    const delItem = () => {
      if (window.confirm(`您确定删除吗?`)) {
        delTodo(props.index);
      }
    };

    return {
      isShowDel,
      bgColor,
      
      dealShow,
      delItem,
    }
  }
}
</script>

<style scoped>

</style>