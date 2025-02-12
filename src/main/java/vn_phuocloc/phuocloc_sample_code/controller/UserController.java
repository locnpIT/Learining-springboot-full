package vn_phuocloc.phuocloc_sample_code.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import vn_phuocloc.phuocloc_sample_code.DTO.UserRequestDTO;
import vn_phuocloc.phuocloc_sample_code.DTO.response.ResponseData;
import vn_phuocloc.phuocloc_sample_code.DTO.response.ResponseError;
import vn_phuocloc.phuocloc_sample_code.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userRequest) {

        try {
            userService.addUser(userRequest);
            return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);
        } catch (Exception e) {
            // bắt lỗi bên UserServiceImpl
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@PathVariable int userId, @Valid @RequestBody UserRequestDTO userRequestDTO) {

        System.out.println("Request update userId = " + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully!!");
    }

    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        System.out.println("Request change user status. userId = " + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User Status changed successfully!!!");
    }

    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@Min(1) @PathVariable int userId) {

        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Deleted user successfully!!!");
    }

    @GetMapping("/{userId}")
    public ResponseData<UserRequestDTO> getUser(@Min(1) @PathVariable int userId) {
        System.out.println("Request get user by user id");
        return new ResponseData<>(HttpStatus.OK.value(), "Get user success",
                new UserRequestDTO("nguyen", "phuoc", "0338361709", "npl2004qn@gmail.com"));
    }

    @GetMapping("/list")
    public ResponseData<List<UserRequestDTO>> getAllUsers(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @Min(10) @RequestParam(defaultValue = "10") int pageSize) {
        return new ResponseData<>(HttpStatus.OK.value(), "Get list of user success",
                List.of(new UserRequestDTO("nguyen", "phuoc", "0338361709", "npl2004qn@gmail.com"),
                        new UserRequestDTO("nguyen", "phuoc", "0338361709", "npl2004qn@gmail.com")));
    }

}
