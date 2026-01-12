package ro.mycode.user;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import ro.mycode.user.dtos.UserCreateRequest;
import ro.mycode.user.mappers.UserMapper;
import ro.mycode.user.model.User;
import ro.mycode.user.repository.UserRepository;

import java.util.Optional;

@Component
public class View {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public View(UserRepository userRepository, UserMapper userMapper){
        this.userRepository=userRepository;
        this.userMapper=userMapper;


        this.findUserByUsernameIgnoringCase();
        this.findUserByEmailAndUsername();
        this.addUser();
    }

    public void findUserByUsernameIgnoringCase(){
        Optional<User> rez=userRepository.findUserByNameIgnoringCaseJPQL("maria");
        System.out.println(userMapper.toDto(rez.get()));
    }
    public void findUserByEmailAndUsername(){
        Optional<User> rezultat=userRepository.findUserByEmailAndUsername("andrei@gmail.com", "Andrei");
        System.out.println(userMapper.toDto(rezultat.get()));
    }

    @Transactional
    public void addUser(){
        UserCreateRequest userCreateRequest= new UserCreateRequest("Adriaan", "A@gmail.com");
        User user=userRepository.save(userMapper.toEntity(userCreateRequest));
        System.out.println(userMapper.toDto(user));
    }


}
