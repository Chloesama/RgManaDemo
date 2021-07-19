<template>
  <div>
    <input
        type="text"
        placeholder="请输入今天的任务清单,按回车确认"
        v-model="title"
        @keyup.enter="addItem"
    />
  </div>
</template>

<script>
export default {
  name: "Header.vue",
  props: {
    addItem: Function,
  },
  data() {
    return {
      title: '',
    }
  },
  methods: {
    addItem() {
      const title = this.title.trim();
      if (title) {
        let todo = {title: title, finished: false};
        this.addItem(todo);
        this.title = "";
      }
    },
  }
}
</script>

<style scoped>

</style>