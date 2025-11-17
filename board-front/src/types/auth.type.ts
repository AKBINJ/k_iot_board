// auth.type.ts
export interface LoginRequest {
  username: string;
  pasword: string;
}

export interface LoginResponse {
  accessToken: string;
  expireTime: number; // 초 단위
}