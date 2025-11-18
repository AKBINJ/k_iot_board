import type { ApiResponse } from "@/types/common/ApiResponse";
import { privateApi } from "../common/axiosInstance";
import type { UserDetailResponse, UserListItemResponse } from "@/types/user/user.dto";
import { USRE_PATH } from "./user.path";

export const userApi = {
  getUser: async (userId: number): Promise<UserDetailResponse> => {
    const res = await privateApi.get<ApiResponse<UserDetailResponse>>(
      USRE_PATH.BY_ID(userId)
    );
    return res.data.data;
  },

  getUserList: async (): Promise<UserListItemResponse> => {
    const res = await privateApi.get<ApiResponse<UserListItemResponse>>(
      USRE_PATH.LIST
    );
    return res.data.data;
  },
};
