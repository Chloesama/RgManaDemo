<template>
  <div>
    <input
        type="text"
        placeholder="请输入今天的任务清单,按回车确认"
        v-model.trim="title"
        @keyup.enter="addItemClick"
    />
  </div>
</template>

<script setup>
import {ref, inject} from 'vue';

const addItem = inject('addItem');
let title = ref('');

const addItemClick = () => {
  const content = title.value;
  if (content) {
    let todo = {title: content, finished: false};
    addItem(todo);
    title.value = '';
  }
}
</script>

<style scoped>

</style>