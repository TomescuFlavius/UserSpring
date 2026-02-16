package ro.mycode.user.service;

import ro.mycode.user.dtos.UserCreateRequest;
import ro.mycode.user.dtos.UserResponse;
import ro.mycode.user.dtos.UserUpdateRequest;

public interface UserCommandService {

    UserResponse crete(UserCreateRequest request);
    UserResponse update(String email, UserUpdateRequest request);
    void delete(String email);
}
