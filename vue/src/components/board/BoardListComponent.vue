<script setup>
import BoardListItemComponent from '@/components/board/item/BoardListItemComponent.vue'
import { ref } from 'vue'
import PaginationComponent from '@/components/board/item/PaginationComponent.vue'

/**************************** tab 정보 *****************************/
const tabsContainer = ref(null)
const openTabContent = ref(null)
const closedTabContent = ref(null)
const openTab = ref(null)
const closedTab = ref(null)
const isOpen = ref(true)

function clickTab(open) {
  openTab.value.classList.remove(
    'border-blue-400',
    'border-b-4',
    '-mb-px',
    'opacity-100',
    'opacity-50'
  )
  openTabContent.value.classList.remove('hidden')

  closedTab.value.classList.remove(
    'border-blue-400',
    'border-b-4',
    '-mb-px',
    'opacity-100',
    'opacity-50'
  )
  closedTabContent.value.classList.remove('hidden')

  let clicked = openTab.value
  let unclicked = closedTab.value
  let unclickedContent = closedTabContent.value
  isOpen.value = true
  if (!open) {
    clicked = closedTab.value
    unclicked = openTab.value
    unclickedContent = openTabContent.value
    isOpen.value = false
  }

  clicked.classList.add('border-blue-400', 'border-b-4', '-mb-px', 'opacity-100')
  unclicked.classList.add('opacity-50')
  unclickedContent.classList.add('hidden')
}
/******************************************************************/

/****************************  search  *****************************/
const searchInput = ref('')
const wordstr = ref('')
const tagbox = ref([])

const body = ref({
  word: '',
  tags: [],
  orderby: 'latest',
  open: true
})

function onPressEnter() {
  console.log(`searchInput............`, searchInput.value)
  // word, tag split
  const words = searchInput.value.split(' ')
  words.forEach((word) => {
    if (word[0] == '#') {
      tagbox.value.push(word.substring(1))
    } else {
      wordstr.value = wordstr.value.concat(word, ' ')
    }
  })

  console.log(`wordstr..................`, wordstr.value)
  console.log(`tagbox...................`, tagbox.value)
  // request body 구성
  body.value.word = wordstr.value
  body.value.tags = tagbox.value
  body.value.open = isOpen.value
  //body.value.orderby = latest

  // axios post 요청
}

/******************************************************************/

/****************************  list  *****************************/

const searchedList = ref([
  {
    id: 1,
    nickname: '하나둘셋넷',
    createdTime: '2017.03.02',
    open: true,
    subject: '스터디원 모집합니다.',
    content:
      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam eius suscipit nobis, tempora ut rem est, ducimus aliquid, provident recusandae quo vero sapiente quod quia perspiciatis facilis ea enim mollitia?',
    tag: ['백엔드', '자바', '호잇'],
    user_img:
      'https://mblogthumb-phinf.pstatic.net/MjAyMDExMjRfMTA3/MDAxNjA2MjA1MDM0Nzkx.DrktdswN2SFmJQEaXdbhl4BnmzlN2oEN03hEHq_UUcQg.MIrlXoSMZsH0pRyuI0x3zIggxc3vlRcb53EYugvLqYkg.JPEG.sosohan_n/IMG_5367.JPG?type=w800',
    likes: 12,
    eyes: 4
  },
  {
    id: 2,
    nickname: '하나둘셋넷',
    createdTime: '2017.03.02',
    open: true,
    subject: '스터디원 모집합니다.',
    content:
      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam eius suscipit nobis, tempora ut rem est, ducimus aliquid, provident recusandae quo vero sapiente quod quia perspiciatis facilis ea enim mollitia?',
    tag: ['백엔드', '자바', '호잇'],
    user_img:
      'https://mblogthumb-phinf.pstatic.net/MjAyMDExMjRfMTA3/MDAxNjA2MjA1MDM0Nzkx.DrktdswN2SFmJQEaXdbhl4BnmzlN2oEN03hEHq_UUcQg.MIrlXoSMZsH0pRyuI0x3zIggxc3vlRcb53EYugvLqYkg.JPEG.sosohan_n/IMG_5367.JPG?type=w800',
    likes: 12,
    eyes: 4
  },
  {
    id: 3,
    nickname: '하나둘셋넷',
    createdTime: '2017.03.02',
    open: true,
    subject: '스터디원 모집합니다.',
    content:
      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam eius suscipit nobis, tempora ut rem est, ducimus aliquid, provident recusandae quo vero sapiente quod quia perspiciatis facilis ea enim mollitia?',
    tag: ['백엔드', '자바', '호잇'],
    user_img:
      'https://mblogthumb-phinf.pstatic.net/MjAyMDExMjRfMTA3/MDAxNjA2MjA1MDM0Nzkx.DrktdswN2SFmJQEaXdbhl4BnmzlN2oEN03hEHq_UUcQg.MIrlXoSMZsH0pRyuI0x3zIggxc3vlRcb53EYugvLqYkg.JPEG.sosohan_n/IMG_5367.JPG?type=w800',
    likes: 12,
    eyes: 4
  },
  {
    id: 4,
    nickname: '하나둘셋넷',
    createdTime: '2017.03.02',
    open: true,
    subject: '스터디원 모집합니다.',
    content:
      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam eius suscipit nobis, tempora ut rem est, ducimus aliquid, provident recusandae quo vero sapiente quod quia perspiciatis facilis ea enim mollitia?',
    tag: ['백엔드', '자바', '호잇'],
    user_img:
      'https://mblogthumb-phinf.pstatic.net/MjAyMDExMjRfMTA3/MDAxNjA2MjA1MDM0Nzkx.DrktdswN2SFmJQEaXdbhl4BnmzlN2oEN03hEHq_UUcQg.MIrlXoSMZsH0pRyuI0x3zIggxc3vlRcb53EYugvLqYkg.JPEG.sosohan_n/IMG_5367.JPG?type=w800',
    likes: 12,
    eyes: 4
  },
  {
    id: 5,
    nickname: '하나둘셋넷',
    createdTime: '2017.03.02',
    open: true,
    subject: '스터디원 모집합니다.',
    content:
      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam eius suscipit nobis, tempora ut rem est, ducimus aliquid, provident recusandae quo vero sapiente quod quia perspiciatis facilis ea enim mollitia?',
    tag: ['백엔드', '자바', '호잇'],
    user_img:
      'https://mblogthumb-phinf.pstatic.net/MjAyMDExMjRfMTA3/MDAxNjA2MjA1MDM0Nzkx.DrktdswN2SFmJQEaXdbhl4BnmzlN2oEN03hEHq_UUcQg.MIrlXoSMZsH0pRyuI0x3zIggxc3vlRcb53EYugvLqYkg.JPEG.sosohan_n/IMG_5367.JPG?type=w800',
    likes: 12,
    eyes: 4
  },
  {
    id: 1,
    nickname: '하나둘셋넷',
    createdTime: '2017.03.02',
    open: true,
    subject: '스터디원 모집합니다.',
    content:
      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam eius suscipit nobis, tempora ut rem est, ducimus aliquid, provident recusandae quo vero sapiente quod quia perspiciatis facilis ea enim mollitia?',
    tag: ['백엔드', '자바', '호잇'],
    user_img:
      'https://mblogthumb-phinf.pstatic.net/MjAyMDExMjRfMTA3/MDAxNjA2MjA1MDM0Nzkx.DrktdswN2SFmJQEaXdbhl4BnmzlN2oEN03hEHq_UUcQg.MIrlXoSMZsH0pRyuI0x3zIggxc3vlRcb53EYugvLqYkg.JPEG.sosohan_n/IMG_5367.JPG?type=w800',
    likes: 12,
    eyes: 4
  }
])

const pageInfo = ref({
  currPage: 1,
  totalPage: 5
})
/******************************************************************/
</script>

<template>
  <div style="flex: 0.6; max-width: 100%">
    <div>
      <h1 class="text-3xl font-extrabold">스터디</h1>
    </div>
    <div class="w-full rounded">
      <!-- 모집중 / 모집완료 tab -->
      <ul ref="tabsContainer" class="inline-flex w-full px-1 pt-2">
        <li
          class="px-4 py-2 -mb-px font-semibold text-gray-800 border-b-2 border-blue-400 rounded-t opacity-100"
          ref="openTab"
        >
          <a href="#open" @click="clickTab(true)">모집중</a>
        </li>
        <li class="px-4 py-2 font-semibold text-gray-800 rounded-t opacity-50" ref="closedTab">
          <a href="#closed" @click="clickTab(false)">모집완료</a>
        </li>
      </ul>

      <div id="tab-contents">
        <!-- 모집중 tab -->
        <div ref="openTabContent" class="p-4">
          <!-- 검색 -->
          <div class="w-full flex justify-center p-1 mb-4">
            <div class="relative w-full">
              <input
                type="text"
                class="w-full backdrop-blur-sm bg-white/20 py-2 pl-10 pr-4 rounded-lg focus:outline-none border-2 border-gray-100 focus:border-violet-300 transition-colors duration-300"
                placeholder="검색어를 입력하세요."
                v-model="searchInput"
                @keyup.enter="onPressEnter"
              />
              <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                <svg
                  class="w-4 h-4 text-gray-800 dark:text-white"
                  aria-hidden="true"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 20 20"
                >
                  <path
                    stroke="currentColor"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"
                  />
                </svg>
              </div>
            </div>
          </div>
          <!-- 정렬 tab & 게시글 작성 -->
          <div class="w-full flex justify-between">
            <ul class="flex items-center gap-2 text-sm font-medium">
              <li class="flex-0.2">
                <a
                  href="#"
                  class="relative flex items-center justify-center gap-2 rounded-lg bg-gray-200 px-3 py-2 text-gray-700 hover:text-gray-700"
                >
                  최신순</a
                >
              </li>
              <li class="flex-0.2">
                <a
                  href="#"
                  class="flex items-center justify-center gap-2 rounded-lg px-3 py-2 text-gray-500 hover:bg-gray-50 hover:text-gray-700"
                >
                  조회순</a
                >
              </li>
              <li class="flex-0.2">
                <a
                  href="#"
                  class="flex items-center justify-center gap-2 rounded-lg px-3 py-2 text-gray-500 hover:bg-gray-50 hover:text-gray-700"
                >
                  즐겨찾기순
                </a>
              </li>
            </ul>
            <button
              class="flex items-center text-sm center relative inline-block select-none whitespace-nowrap rounded-lg bg-blue-500 py-2 px-3.5 align-baseline font-sans font-bold uppercase leading-none text-white"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="15"
                height="15"
                fill="currentColor"
                class="bi bi-pencil me-1"
                viewBox="0 0 16 16"
              >
                <path
                  d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"
                />
              </svg>
              모집하기
            </button>
          </div>
          <!-- 게시글 -->
          <div class="flex w-full min-h-screen items-start justify-center bg-white">
            <div class="p-6 w-full overflow-y-scroll overflow-x-hidden px-0">
              <table class="border-collapse border-y w-full table-auto text-left">
                <tbody>
                  <BoardListItemComponent
                    v-for="item in searchedList"
                    :key="item.id"
                    :item="item"
                  />
                </tbody>
              </table>
              <PaginationComponent :pageInfo="pageInfo" />
            </div>
          </div>
        </div>
        <div ref="closedTabContent" class="hidden p-4">모집완료</div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
