<script setup>
defineProps({ tag: String })
</script>

<template>
  <div
    class="center relative inline-block select-none whitespace-nowrap rounded-lg bg-gray-200 mx-0.5 py-2 px-3.5 align-baseline font-sans text-sm font-bold uppercase leading-none text-black"
  >
    {{ tag }}
  </div>
</template>

<style scoped></style>
