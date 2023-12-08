<script setup>
import BoardListItemComponent from '@/components/board/item/BoardListItemComponent.vue'
import { ref } from 'vue'
import { listBoard } from '@/api/studyBoard.js'
import PaginationComponent from '@/components/board/item/PaginationComponent.vue'

/**************************** tab 정보 *****************************/
const tabsContainer = ref(null)
const tabContent = ref(null)

const otab = ref(null)
const ctab = ref(null)
const openTabInfo = [true, false]
const openTabList = [otab, ctab]

const cdtab = ref(null)
const lctab = ref(null)
const vctab = ref(null)
const sortTabInfo = ['createdDate', 'viewCnt', 'likeCnt']
const sortTabList = [cdtab, vctab, lctab]

const openNo = ref(0)
const sortingNo = ref(0)

const searchedList = ref([])

const pageInfo = ref({
  currPage: 0,
  totalPage: 0
})

const searchInput = ref('')
const wordstr = ref('')
const tagstr = ref('')

const params = ref({
  page: 0,
  word: null,
  tags: [],
  orderby: 'createdDate', //likeCnt, viewCnt
  open: true
})

function init() {
  searchInput.value = ''
  wordstr.value = ''
  tagstr.value = ''
  sortingNo.value = 0
  pageInfo.value.currPage = 0
  pageInfo.value.totalPage = 0
}

function clickOpenTab(open) {
  // console.log(`openTabList, open, ........`, openTabList, open)
  openTabList.forEach((tab) =>
    tab.value.classList.remove(
      'border-blue-400',
      'border-b-4',
      '-mb-px',
      'opacity-100',
      'opacity-50'
    )
  )

  openNo.value = open
  openTabList[open].value.classList.add('border-blue-400', 'border-b-4', '-mb-px', 'opacity-100')
  openTabList[open ^ 1].value.classList.add('opacity-50')
  init()
  load()
}

function clickSortingTab(sort) {
  pageInfo.value.currPage = 0
  pageInfo.value.totalPage = 0
  sortTabList.forEach((tab) => tab.value.classList.remove('bg-gray-200', 'text-gray-700'))

  sortingNo.value = sort
  sortTabList[sort].value.classList.add('bg-gray-200', 'text-gray-700')
  if (sort != 0) {
    sortTabList[0].value.classList.add('text-gray-500')
  }
  load()
}
/******************************************************************/

/****************************  search  *****************************/
function onPressEnter() {
  console.log(`searchInput............`, searchInput.value)
  // word, tag split
  wordstr.value = ''
  tagstr.value = ''
  pageInfo.value.currPage = 0
  pageInfo.value.totalPage = 0
  const words = searchInput.value.split(' ')
  words.forEach((word) => {
    if (word[0] == '#') {
      tagstr.value = tagstr.value.concat(word)
    } else {
      wordstr.value = wordstr.value.concat(word, ' ')
    }
  })
  wordstr.value = wordstr.value.substring(0, wordstr.value.length - 1)

  console.log(`wordstr..................`, wordstr.value)
  console.log(`tagstr...................`, tagstr.value)

  // axios 요청
  load()
}
/****************************  list  *****************************/
function onMovePage(currPage) {
  pageInfo.value.currPage = currPage.value
  load()
}

function load() {
  params.value.word = wordstr.value
  params.value.tags = tagstr.value
  params.value.page = pageInfo.value.currPage
  params.value.orderby = sortTabInfo[sortingNo.value]
  params.value.open = openTabInfo[openNo.value]
  console.log(params.value)
  listBoard(
    params.value,
    ({ data }) => {
      //console.log(data.totalPages)
      searchedList.value = data.content
      pageInfo.value.currPage = data.pageable.pageNumber
      pageInfo.value.totalPage = data.totalPages
    },
    (error) => {
      console.log(error.response.data)
    }
  )
}
load()
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
          class="px-4 py-2 -mb-px font-semibold text-gray-800 border-b-4 border-blue-400 rounded-t opacity-100"
          ref="otab"
        >
          <button @click="clickOpenTab(0)">모집중</button>
        </li>
        <li class="px-4 py-2 font-semibold text-gray-800 rounded-t opacity-50" ref="ctab">
          <button @click="clickOpenTab(1)">모집완료</button>
        </li>
      </ul>

      <!-- tab Content-->
      <div id="tab-contents" class="p-4">
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
            <li
              class="flex-0.2 flex items-center justify-center gap-2 rounded-lg px-3 py-2 bg-gray-200 text-gray-700 active:bg-gray-50 active:text-gray-700"
              ref="cdtab"
            >
              <button @click="clickSortingTab(0)">최신순</button>
            </li>
            <li
              class="flex-0.2 flex items-center justify-center gap-2 rounded-lg px-3 py-2 text-gray-500 active:bg-gray-50 active:text-gray-700"
              ref="vctab"
            >
              <button @click="clickSortingTab(1)">조회순</button>
            </li>
            <li
              class="flex-0.2 flex items-center justify-center gap-2 rounded-lg px-3 py-2 text-gray-500 active:bg-gray-50 active:text-gray-700"
              ref="lctab"
            >
              <button @click="clickSortingTab(2)">즐겨찾기순</button>
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
        <div ref="tabContent">
          <div class="flex w-full items-start justify-center bg-white">
            <div
              class="p-6 w-full min-h-screen overflow-y-scroll overflow-x-hidden px-0"
              v-if="searchedList.length > 0"
            >
              <table class="border-collapse border-y w-full table-auto text-left">
                <tbody>
                  <BoardListItemComponent
                    v-for="item in searchedList"
                    :key="item.id"
                    :item="item"
                  />
                </tbody>
              </table>
              <PaginationComponent :pageInfo="pageInfo" @currPage="onMovePage" />
            </div>
            <div
              class="p-6 w-full border my-4 flex justify-center items-center"
              style="height: 60vh"
              v-else
            >
              <h2 class="text-2xl font-bold">등록된 게시글이 없습니다.</h2>
              <img
                src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Smilies/Dashing%20Away.png"
                alt="Dashing Away"
                width="60"
                height="60"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
