package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // 반환타입은 User이다 -> 유저가 없다면, null 반환
    // 함수 이름만 작성하면, 알아서 SQL이 조립된다. -> find라 작성하면, 1개의 데이터만 가져온다
    // By 뒤에 붙는 필드 이름으로 SELECT 쿼리의 WHERE문이 작성된다.
    Optional<User> findByName(String name);
}