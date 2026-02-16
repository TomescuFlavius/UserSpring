package ro.mycode.user.dtos;

import java.util.List;

public record UserResponseList(
        List<UserResponse> userResponseList
) {
}
