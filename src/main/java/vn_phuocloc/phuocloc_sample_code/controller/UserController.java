package vn_phuocloc.phuocloc_sample_code.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import vn_phuocloc.phuocloc_sample_code.DTO.UserRequestDTO;
import vn_phuocloc.phuocloc_sample_code.DTO.response.ResponseSuccess;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseSuccess addUser(@Valid @RequestBody UserRequestDTO userRequest) {

        return new ResponseSuccess(HttpStatus.CREATED, "User added successfully", 1);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseSuccess updateUser(@PathVariable int userId, @Valid @RequestBody UserRequestDTO userRequestDTO) {

        System.out.println("Request update userId = " + userId);
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User updated successfully!!");
    }

    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseSuccess changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        System.out.println("Request change user status. userId = " + userId);
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User Status changed successfully!!!");
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseSuccess deleteUser(@Min(1) @PathVariable int userId) {

        return new ResponseSuccess(HttpStatus.NO_CONTENT, "Deleted user successfully!!!");
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSuccess getUser(@PathVariable int userId) {
        System.out.println("Request get user by user id");
        return new ResponseSuccess(HttpStatus.OK, "Get user success",
                new UserRequestDTO("nguyen", "phuoc", "0338361709", "npl2004qn@gmail.com"));
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSuccess getAllUsers(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        return new ResponseSuccess(HttpStatus.OK, "Get list of user success",
                List.of(new UserRequestDTO("nguyen", "phuoc", "0338361709", "npl2004qn@gmail.com"),
                        new UserRequestDTO("nguyen", "phuoc", "0338361709", "npl2004qn@gmail.com")));
    }

}
