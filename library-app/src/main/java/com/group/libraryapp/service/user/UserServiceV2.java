package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 아래 있는 함수가 시작될 때 start transaction;을 해준다 (트랜잭션을 시작!)
    // 함수가 예외없이 잘 끝났다면 commmit;
    // 혹시라도 문제가 있다면 rollback;
    @Transactional
    public void saveUser(UserCreateRequest request) {
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        // SELECT * FROM USER;
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        // select * from user where id = ?;
        // Optional<User>
        // fingById를 통해 id를 기준으로 1개의 데이터를 가져온다.
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);      // User가 없다면 예외 던진다.

        user.updateName(request.getName());         // 객체를 없데이트 후, save 호출 -> 자동으로 Update SQL 진행
//        userRepository.save(user);                // @Transactionl로 인해 해당 코드가 없어도 변경사항이 있으면 자동으로 업데이트 진행 (변경 감지)
    }

    @Transactional
    public void deleteUser(String name) {
        // SELECT * FROM user WHERE name = ?
        User user = userRepository.findByName(name);

        if(user == null) {
            throw new IllegalArgumentException();
        }

        userRepository.delete(user);
    }
}
