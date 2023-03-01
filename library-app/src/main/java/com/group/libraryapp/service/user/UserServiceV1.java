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
//    public void saveUser(UserCreateRequest request2) {
//        userJdbcRepository.saveUser(request2.getName(), request2.getAge());
//    }
//
//    public List<UserResponse> getUsers() {
//        return userJdbcRepository.getUsers();
//    }
//
//    public void updateUser(UserUpdateRequest request2) {
//        // 유저가 존재하지 않을 때 오루 발생
//        if(userJdbcRepository.isUserNotExist(request2.getId())) {
//            throw new IllegalArgumentException();
//        }
//
//        // db 연결하여 이름 업데이트
//        userJdbcRepository.updateUserName(request2.getName(), request2.getId());
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
