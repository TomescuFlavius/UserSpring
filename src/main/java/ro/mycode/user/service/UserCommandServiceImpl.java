package ro.mycode.user.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.user.dtos.UserCreateRequest;
import ro.mycode.user.dtos.UserResponse;
import ro.mycode.user.dtos.UserResponseList;
import ro.mycode.user.dtos.UserUpdateRequest;
import ro.mycode.user.mappers.UserMapper;
import ro.mycode.user.model.User;
import ro.mycode.user.repository.UserRepository;

@Service
public class UserCommandServiceImpl implements UserCommandService{

    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userMapper=userMapper;
        this.userRepository=userRepository;
    }





    @Transactional
    @Override
    public UserResponse crete(UserCreateRequest request) {
        User savedUser=userRepository.save(userMapper.toEntity(request));
        return userMapper.toDto(savedUser);
    }

    @Transactional
    @Override
    public UserResponse update(String email, UserUpdateRequest request) {
        User user=userRepository.findUserByEmail(email).get();
        if (request.username()!=null && !request.username().isBlank()){
            user.setUsername(request.username());
        }
        if (request.email()!=null && !request.email().isBlank()){
            user.setEmail(request.email());
        }
        User updatedUser=userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    @Transactional
    @Override
    public void delete(String email) {
        User user=userRepository.findUserByEmail(email).get();
        userRepository.delete(user);
    }
}
