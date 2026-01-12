package ro.mycode.user.dtos;

public record UserResponse(
        Long id,
        String username,
        String email
) {}
