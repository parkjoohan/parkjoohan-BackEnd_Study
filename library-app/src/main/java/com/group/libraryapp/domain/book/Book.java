package com.group.libraryapp.domain.book;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

//    기본 길이가 255이고, 테이블 칼럼 이름도 선언과 같기 떄문에 생략 가능
    @Column(nullable = false)
    private String name;

    protected Book() {

    }
    public Book(String name) {
        if(name==null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
