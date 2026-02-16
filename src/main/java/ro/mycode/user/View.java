package ro.mycode.user;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import ro.mycode.user.dtos.UserCreateRequest;
import ro.mycode.user.mappers.UserMapper;
import ro.mycode.user.model.User;
import ro.mycode.user.repository.UserRepository;
import ro.mycode.user.service.UserCommandService;
import ro.mycode.user.service.UserQueryService;

import java.util.Optional;

@Component
public class View {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private UserQueryService userQueryService;
    private UserCommandService userCommandService;

    public View(UserRepository userRepository, UserMapper userMapper, UserCommandService userCommandService, UserQueryService userQueryService){
        this.userRepository=userRepository;
        this.userMapper=userMapper;
        this.userCommandService=userCommandService;
        this.userQueryService=userQueryService;
    }




}
