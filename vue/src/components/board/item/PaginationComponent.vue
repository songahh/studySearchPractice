<script setup>
import { ref } from 'vue'
const props = defineProps({ pageInfo: Object })
const emits = defineEmits({ currPage: Number })

function onMovePage(offset) {
  const currPage = ref(0)
  currPage.value = props.pageInfo.currPage
  if (offset == -1) {
    // prev
    currPage.value = Math.max(currPage.value - 1, 0)
  } else {
    // next 버튼
    currPage.value = Math.min(currPage.value + 1, props.pageInfo.totalPage - 1)
  }
  emits('currPage', currPage)
}
</script>

<template>
  <div class="flex items-center justify-center my-4">
    <div class="flex justify-center items-center space-x-4">
      <button
        class="border rounded-md bg-gray-100 px-2 py-1 text-2xl leading-6 text-slate-400 transition hover:bg-gray-200 hover:text-slate-500 cursor-pointer shadow-sm"
        @click="onMovePage(-1)"
      >
        &lt;
      </button>
      <div class="text-slate-500">{{ pageInfo.currPage + 1 }} / {{ pageInfo.totalPage }}</div>
      <button
        class="border rounded-md bg-gray-100 px-2 py-1 text-2xl leading-6 text-slate-400 transition hover:bg-gray-200 hover:text-slate-500 cursor-pointer shadow-sm"
        @click="onMovePage(1)"
      >
        &gt;
      </button>
    </div>
  </div>
</template>

<style scoped></style>
