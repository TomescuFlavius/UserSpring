package ro.mycode.user.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.user.dtos.UserCreateRequest;
import ro.mycode.user.dtos.UserResponse;
import ro.mycode.user.dtos.UserResponseList;
import ro.mycode.user.service.UserCommandService;
import ro.mycode.user.service.UserQueryService;

@RestController
@RequestMapping
@Slf4j
public class UserController {

    private UserQueryService userQueryService;
    private UserCommandService userCommandService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService){
        this.userCommandService=userCommandService;
        this.userQueryService=userQueryService;

    }

    @GetMapping("/all")
    public ResponseEntity<UserResponseList> getAllUsers(){
        log.info("Http  get  /api/v1/users/all");
        return ResponseEntity.ok(userQueryService.findAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest){
        log.info("Http post /api/v1/users username={} email={}", userCreateRequest.username(), userCreateRequest.email());
        return ResponseEntity.status(HttpStatus.CREATED).body(userCommandService.crete(userCreateRequest));
    }

    
}
