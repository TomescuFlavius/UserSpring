package ro.mycode.user.service;

import ro.mycode.user.dtos.UserResponse;
import ro.mycode.user.dtos.UserResponseList;

public interface UserQueryService {

    UserResponseList findAllUsers();
    UserResponse findByEmail(String email);
    UserResponse findById(Long id);
}
