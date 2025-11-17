// 공통 Response 형식
export interface ApiResponse<T> {
  success: number;
  message: string;
  data: T;
}