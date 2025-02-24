package vn_phuocloc.phuocloc_sample_code.service.impl;

import org.springframework.stereotype.Service;

import vn_phuocloc.phuocloc_sample_code.DTO.UserRequestDTO;
import vn_phuocloc.phuocloc_sample_code.exception.ResourceNotFoundException;
import vn_phuocloc.phuocloc_sample_code.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public int addUser(UserRequestDTO requestDTO) {
        // System.out.println("Save user to db");
        // if (!requestDTO.getFirstName().equals("Loc")) {
        //     // ném lỗi này ra để bên UserController bắt
        //     throw new ResourceNotFoundException("Loc khong ton tai");
        // }
        return 0;
    }

}
