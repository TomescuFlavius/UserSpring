package ro.mycode.user.service;

import org.springframework.stereotype.Service;
import ro.mycode.user.dtos.UserResponse;
import ro.mycode.user.dtos.UserResponseList;
import ro.mycode.user.mappers.UserMapper;
import ro.mycode.user.repository.UserRepository;

@Service
public class UserQueryServiceImpl implements UserQueryService{

    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository=userRepository;
        this.userMapper=userMapper;
    }





    @Override
    public UserResponseList findAllUsers() {
        return new UserResponseList(userMapper.toDtoList(userRepository.findAll()));
    }

    @Override
    public UserResponse findByEmail(String email) {
        return userMapper.toDto(userRepository.findUserByEmail(email).get());
    }

    @Override
    public UserResponse findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).get());
    }
}
