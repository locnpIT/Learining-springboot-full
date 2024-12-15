package vn_phuocloc.phuocloc_sample_code.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import vn_phuocloc.phuocloc_sample_code.DTO.UserRequestDTO;

import java.util.List;

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

    @PostMapping(value = "/")
    public String addUser(@Valid @RequestBody UserRequestDTO userRequest) {

        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @Valid @RequestBody UserRequestDTO userRequestDTO) {

        System.out.println("Request update userId = " + userId);
        return "user updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        System.out.println("Request change user status. userId = " + userId);
        return "User status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@Min(1) @PathVariable int userId) {

        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        System.out.println("Request get user by user id");
        return new UserRequestDTO("nguyen", "phuoc", "0338361709", "npl2004qn@gmail.com");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        return List.of(new UserRequestDTO("nguyen", "phuoc", "0338361709", "npl2004qn@gmail.com"),
                new UserRequestDTO("nguyen", "phuoc", "0338361709", "npl2004qn@gmail.com"));
    }

}
