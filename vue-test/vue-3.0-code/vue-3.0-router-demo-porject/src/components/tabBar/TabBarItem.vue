<template>
  <div class="tab-bar-item" @click="itemClick">
<!--    <div :class="{selected:isSelected}">-->
<!--      <slot name="item-title"></slot>-->
<!--    </div>-->
    <div :style="selectStyle">
      <slot name="item-title"></slot>
    </div>
  </div>
</template>

<script>
import {useRouter, useRoute} from 'vue-router';
import {computed} from 'vue';

export default {
  name: "TabBarItem",
  props: {
    path: String,
    selectColor: {
      type: String,
      default: 'red',
    }
  },
  setup(props) {
    const router = useRouter();

    const itemClick = () => {
      router.push(props.path);
    }

    const route = useRoute();

    const isSelected = computed(() => {
      return route.path.includes(props.path);
    })

    const selectStyle = computed(() => {
      return isSelected.value ? {color: props.selectColor} : {}
    });

    return {
      itemClick,
      isSelected,
      selectStyle,
    }
  }
}
</script>

<style scoped>
.tab-bar-item {
  flex: 1;
  height: 49px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.selected {
  color: red;
}
</style>