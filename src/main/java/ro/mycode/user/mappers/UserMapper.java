package ro.mycode.user.mappers;

import org.hibernate.query.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ro.mycode.user.dtos.UserCreateRequest;
import ro.mycode.user.dtos.UserResponse;
import ro.mycode.user.model.User;

import java.util.List;

@Component
public class UserMapper {
    public User toEntity(UserCreateRequest request){
        if (request==null) return null;

        return User.builder().username(request.username())
                .email(request.email())
                .build();
    }


    public UserResponse toDto (User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }

    public List<UserResponse> toDtoList(List<User> users){
        return users.stream().map(this::toDto).toList();
    }


}
