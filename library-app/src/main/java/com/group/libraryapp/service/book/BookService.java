package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        // 1. 책 정보를 가져온다
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);
        // 2. 대출기록 정보를 확인해서 대출 중인지 확인한다
        // 3. 만약에 확인했는데 대출 중이라면 예외를 발생시킨다.
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("진작 대출되어 있는 책입니다.");
        }

        // 4. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
        // 5. 유저 정보와 책 정보를 기반으로 UserLoanHistory를 저장
        userLoanHistoryRepository.save(new UserLoanHistory(user, book.getName()));
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        // 1. userName을 활용하여 userId를 찾아와야 한다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        //2. userId와 userName을 통해 대출 기록을 찾는다.
        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
                .orElseThrow(IllegalArgumentException::new);
        history.doReturn();

        // 아래 코드는 없어도 된다. => @Transactional annotation은 영속성 함수를 가지고 있어 변경되는 내용에 대해서 자동 업데이트
        // userLoanHistoryRepository.save(history);
    }
}
