package vn_phuocloc.phuocloc_sample_code.service;

import java.util.List;

import vn_phuocloc.phuocloc_sample_code.DTO.UserRequestDTO;
import vn_phuocloc.phuocloc_sample_code.DTO.response.UserDetailResponse;
import vn_phuocloc.phuocloc_sample_code.util.UserStatus;

public interface UserService {
    
    int addUser(UserRequestDTO requestDTO);

    long saveUser(UserRequestDTO request);
    void updateUser(Long userId, UserRequestDTO request);
    void changeStatus(Long userId, UserStatus status);
    void deleteUser(Long userId);
    UserDetailResponse getUser(long userId);
    List<UserDetailResponse> getAllUsers(int pageNo, int pageSize);

}
