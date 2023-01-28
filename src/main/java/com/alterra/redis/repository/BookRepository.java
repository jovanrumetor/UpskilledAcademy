package com.alterra.redis.repository;

import com.alterra.redis.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class BookRepository {

    public static final String HASH_KEY = "Book";

    @Autowired
    private RedisTemplate template;

    public BookEntity save(BookEntity bookEntity){

        template.opsForHash().put(HASH_KEY,bookEntity.getId(),bookEntity);
        return bookEntity;
    }

    public BookEntity updateBook(BookEntity bookEntity, int id){
        template.opsForHash().put(HASH_KEY,id,bookEntity);
        return bookEntity;
    }

    public List<BookEntity> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public BookEntity findBookById(int id){
        System.out.println("called findBookById() from DB");
        return (BookEntity) template.opsForHash().get(HASH_KEY,id);
    }

    public String deleteBook(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "book removed !!";
    }
}
