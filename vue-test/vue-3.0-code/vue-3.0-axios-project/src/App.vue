<template>
  <div>
    <h1>axios的使用</h1>
    <button @click="getGet">发起get请求</button>
    <button @click="getPost">发起post请求</button>
  </div>
</template>

<script setup>
import ajax from './http/index.js';

const getGet = () => {
  ajax('http://localhost:8805/hello').then((res) => {
    console.log(res);
  }).catch((err) => {
    console.log(err);
  })
}

const getPost = () => {
  ajax('http://localhost:8805/PostChloe', {user: 'Chloe_RgMana'}, 'post').then((res) => {
    console.log(res);
  }).catch((err) => {
    console.log(err);
  })
}
</script>

<style>
</style>
