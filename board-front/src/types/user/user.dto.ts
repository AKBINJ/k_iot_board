//! user.dto.ts

// DTO request 타입: 백엔드로 보내는 Request Dto
export interface UserCreateReqest {

}

// 단일 유저 상세 정보 (GET /user/:userId)
export interface UserDetailResponse {

}

// 리스트 항목
export interface UserListItemResponse {

}

// 리스트 응답 데이터
export type UserListResponse = UserListItemResponse[];
