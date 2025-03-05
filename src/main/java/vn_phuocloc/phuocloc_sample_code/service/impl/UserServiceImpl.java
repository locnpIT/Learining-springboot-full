package vn_phuocloc.phuocloc_sample_code.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import vn_phuocloc.phuocloc_sample_code.DTO.UserRequestDTO;
import vn_phuocloc.phuocloc_sample_code.DTO.response.UserDetailResponse;
import vn_phuocloc.phuocloc_sample_code.exception.ResourceNotFoundException;
import vn_phuocloc.phuocloc_sample_code.model.User;
import vn_phuocloc.phuocloc_sample_code.repository.UserRepository;
import vn_phuocloc.phuocloc_sample_code.service.UserService;
import vn_phuocloc.phuocloc_sample_code.util.UserStatus;
import vn_phuocloc.phuocloc_sample_code.util.UserType;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public int addUser(UserRequestDTO requestDTO) {
        // System.out.println("Save user to db");
        // if (!requestDTO.getFirstName().equals("Loc")) {
        //     // ném lỗi này ra để bên UserController bắt
        //     throw new ResourceNotFoundException("Loc khong ton tai");
        // }
        return 0;
    }

    @Override
    public long saveUser(UserRequestDTO request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setGender(request.getGender());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setStatus(request.getStatus());
        user.setType(UserType.valueOf(request.getType().toUpperCase()));
        user.setAddresses(request.getAddresses());


        return 0;
    }

    @Override
    public void updateUser(Long userId, UserRequestDTO request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void changeStatus(Long userId, UserStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeStatus'");
    }

    @Override
    public void deleteUser(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public UserDetailResponse getUser(long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public List<UserDetailResponse> getAllUsers(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    

}
