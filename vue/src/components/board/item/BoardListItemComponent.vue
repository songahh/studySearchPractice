<script setup>
import BoardTagItemComponent from '@/components/board/item/BoardTagItemComponent.vue'

import { ref } from 'vue'
const props = defineProps({ item: Object })
const openOrClosed = ref('모집중')
if (!props.item.open) openOrClosed.value = '모집완료'

function dateConverter() {
  // 1시간 이내 -> *분 전
  // 24시간 이내 ->  *시간 전
  // 1주일 이내 -> *일 전
  //
}
</script>

<template>
  <tr>
    <td class="border-y border-collapse board-blue-gray-50">
      <div class="py-2">
        <span class="text-sm"
          ><img
            class="relative inline-block h-8 w-8 rounded-full object-cover object-center"
            alt="프로필 이미지"
            :src="item.userImg"
          />
          {{ item.nickname }} ・ {{ item.createdTime }}</span
        >
      </div>
      <div class="flex flex-col">
        <div class="flex">
          <div
            class="text-sm center relative inline-block select-none whitespace-nowrap rounded-lg bg-blue-500 py-2 px-3.5 align-baseline font-sans font-bold uppercase leading-none text-white"
            v-if="openOrClosed == '모집중'"
          >
            {{ openOrClosed }}
          </div>
          <div
            class="text-sm center relative inline-block select-none whitespace-nowrap rounded-lg bg-gray-400 py-2 px-3.5 align-baseline font-sans font-bold uppercase leading-none text-white"
            v-else
          >
            {{ openOrClosed }}
          </div>
          <h4 class="px-2 text-xl font-bold" id="subject">{{ item.subject }}</h4>
        </div>
        <p id="content" class="text-ellipsis overflow-hidden my-2" style="height: 40px">
          {{ item.content }}
        </p>
        <div id="tag" class="my-1">
          <BoardTagItemComponent v-for="tag in item.tag" :key="tag" :tag="tag" />
        </div>
      </div>
      <div class="flex items-center justify-end py-1 px-4">
        <span>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-star"
            viewBox="0 0 16 16"
          >
            <path
              d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"
            />
          </svg>
        </span>
        <span>&nbsp;{{ item.likes }}</span>
        <span>&nbsp;&nbsp;</span>
        <span
          ><svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-eye"
            viewBox="0 0 16 16"
          >
            <path
              d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"
            />
            <path
              d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0"
            />
          </svg>
        </span>
        <span>&nbsp;{{ item.eyes }}</span>
      </div>
    </td>
  </tr>
</template>

<style scoped></style>
