package com.alterra.redis.controller;

import com.alterra.redis.entity.BookEntity;
import com.alterra.redis.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@EnableCaching
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public BookEntity save(@RequestBody BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "Book",unless = "#result.price > 1000")
    public BookEntity findBook(@PathVariable int id) {
        return bookRepository.findBookById(id);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(@RequestBody BookEntity bookEntity, @PathVariable int id) {
        return bookRepository.updateBook(bookEntity, id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = "Book")
    public String remove(@PathVariable int id) {
        return bookRepository.deleteBook(id);
    }

}
