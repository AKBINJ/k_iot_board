// client.ts

import { QueryClient } from "@tanstack/react-query";


//! react query 전체 공통 설정
// QueryClient를 만들면서, 모든 useQuery의 기본 옵션 설정
export const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      staleTime: 1000 * 30,
      refetchOnWindowFocus: false,
      retry: 1,
    }
  }
})