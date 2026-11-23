package edu.handong.week12.book;

import edu.handong.week12.book.dto.BookRequest;
import edu.handong.week12.book.dto.BookResponse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookResponse> findAll() {
        return repository.findAll().stream()
                .map(BookResponse::from)
                .collect(Collectors.toList());
    } // TODO STEP 6: Pagination/Sorting

    public BookResponse findById(Long id) {
        Book book = repository.findById(id).orElseThrow();
        return BookResponse.from(book);
    } // TODO STEP 5: 404

    public BookResponse create(BookRequest request) {
        Book book = new Book(request.getTitle(), request.getAuthor(), request.getPrice());
        return BookResponse.from(repository.save(book));
    } // TODO STEP 3: DTO

    public BookResponse update(Long id, BookRequest request) {
        Book book = repository.findById(id).orElseThrow();
        book.update(request.getTitle(), request.getAuthor(), request.getPrice());
        return BookResponse.from(repository.save(book));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    } // TODO: 404 if absent
}