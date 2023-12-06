<script setup>
import { RouterView } from 'vue-router'
</script>

<template>
  <header>
    <h1 style="color: white">헤더헤ㅓ데허데헤더헤더헤더ㅔ더헤더</h1>
  </header>
  <main style="width: 100%; padding: 30px 0px; display: flex; flex: 1; justify-content: center">
    <RouterView />
  </main>
  <footer>
    <h1 style="color: white">푸터푸터푸터푸터터터터ㅜ퍼터</h1>
  </footer>
</template>

<style scoped>
header {
  background-color: turquoise;
  margin: 0px;
  width: 100%;
  height: 80px;
}

footer {
  background-color: turquoise;
  margin-top: auto;
  width: 100%;
  height: 100px;
}
</style>
