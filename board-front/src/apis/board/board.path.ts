// board.path.ts

import { BASE } from "../common/base.path";

const BOARD_PREFIX = `${BASE}/boards`;

export const BOARD_PATH = {
  //? cf) SpringBoot
  //  VS React
  ROOT: BOARD_PREFIX,

  LIST: BOARD_PREFIX,
  CREATE: BOARD_PREFIX,

  BY_ID: (boardId: number) => `${BOARD_PREFIX}/${boardId}`,

  // 카테고리
  CATECORY: (categoryId: number) => `${BOARD_PREFIX}/category/${categoryId}`,
  COUNT_BY_CATEGORY: `${BOARD_PREFIX}/category-count`,

  // 검색
  SEARCH: `${BOARD_PREFIX}/search`,

  PAGE: `${BOARD_PREFIX}/page`,

  MY_BOARDS: `${BOARD_PREFIX}/me`,

  VIEW: (boardId: number) => `${BOARD_PREFIX}/${boardId}/view`,

  LIKE: (boardId: number) => `${BOARD_PREFIX}/${boardId}/like`,
  LIKE_CANCEL: (boardId: number) => `${BOARD_PREFIX}/${boardId}/like/cancel`,
  LIKE_COUNT: (boardId: number) => `${BOARD_PREFIX}/${boardId}/like/count`,

  PIN: (boardId: number) => `${BOARD_PREFIX}/${boardId}/pin`,
  UNPIN: (boardId: number) => `${BOARD_PREFIX}/${boardId}/unpin`,
  PINNED_LIST:  `${BOARD_PREFIX}/pinned`,

  // 신고
  REPOORT: (boardId: number) => `${BOARD_PREFIX}/${boardId}/report`,

  // 임시 저장
  DRAFT: `${BOARD_PREFIX}/draft`,
  DRAFT_BY_ID: (draftId: number) => `${BOARD_PREFIX}/draft/${draftId}`,

  // 통계
  STATS: `${BOARD_PREFIX}/stats`,
  STATS_DAILY: `${BOARD_PREFIX}/stats/daily`,
  STATS_MONTHLY: `${BOARD_PREFIX}/stats/monthly`,
  STATS_GENDER: `${BOARD_PREFIX}/stats/gender`,
}