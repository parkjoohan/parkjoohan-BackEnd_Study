package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(), request.getAge()));
    }

    public List<UserResponse> getUsers() {
        // SELECT * FROM USER;
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest request) {
        // select * from user where id = ?;
        // Optional<User>
        // fingById를 통해 id를 기준으로 1개의 데이터를 가져온다.
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);      // User가 없다면 예외 던진다.

        user.updateName(request.getName());         // 객체를 없데이트 후, save 호출 -> 자동으로 Update SQL 진행 
        userRepository.save(user);
    }
}
