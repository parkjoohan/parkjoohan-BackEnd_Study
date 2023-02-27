package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

//    @Autowired
//    private final UserJdbcRepository userJdbcRepository;
//
//    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
//        this.userJdbcRepository = userJdbcRepository;
//    }
//
//    public void saveUser(UserCreateRequest request) {
//        userJdbcRepository.saveUser(request.getName(), request.getAge());
//    }
//
//    public List<UserResponse> getUsers() {
//        return userJdbcRepository.getUsers();
//    }
//
//    public void updateUser(UserUpdateRequest request) {
//        // 유저가 존재하지 않을 때 오루 발생
//        if(userJdbcRepository.isUserNotExist(request.getId())) {
//            throw new IllegalArgumentException();
//        }
//
//        // db 연결하여 이름 업데이트
//        userJdbcRepository.updateUserName(request.getName(), request.getId());
//    }
//
//    public void deleteUser(String name) {
//        if(userJdbcRepository.isUserNotExist(name)) {
//            throw new IllegalArgumentException();
//        }
//
//        userJdbcRepository.deleteUser(name);
//    }
}
