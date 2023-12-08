<script setup>
defineProps({ pageInfo: Object })
</script>

<template>
  <div class="flex items-center justify-center my-4">
    <div class="flex justify-center items-center space-x-4">
      <div
        class="border rounded-md bg-gray-100 px-2 py-1 text-2xl leading-6 text-slate-400 transition hover:bg-gray-200 hover:text-slate-500 cursor-pointer shadow-sm"
      >
        &lt;
      </div>
      <div class="text-slate-500">{{ pageInfo.currPage + 1 }} / {{ pageInfo.totalPage }}</div>
      <div
        class="border rounded-md bg-gray-100 px-2 py-1 text-2xl leading-6 text-slate-400 transition hover:bg-gray-200 hover:text-slate-500 cursor-pointer shadow-sm"
      >
        &gt;
      </div>
    </div>
  </div>
</template>

<style scoped></style>
