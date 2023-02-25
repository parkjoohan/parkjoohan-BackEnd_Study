package com.group.libraryapp.domain.user;

import javax.persistence.*;

@Entity
public class User {

    @Id                                                     // 이 필드를 primary key로 지정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // primary key는 자동 생성되는 값이다. (Auto-Increment)
    private Long id = null;

    @Column(nullable = false, length = 20, name = "name")   // name varchar(20) : null이 들어갈 수 있는지 여부, 길이 제한, DB에서의 Column 이름 등등 선언
    private String name;
    private Integer age;                                    // Table과 비교하여 모든 것이 똑같으면 @Column을 아예 생략할 수 있다.

    protected User() {}     // JPA 사용하기 위해서는 기본 생성자가 필요하다

    public User(String name, Integer age) {
        if(name==null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
