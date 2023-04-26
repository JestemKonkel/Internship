package com.example.internshiptasks;

import com.example.internshiptasks.Repository.PostsRepository;
import com.example.internshiptasks.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class InternshipTasksApplication {
    private static PostsRepository postsRepository;

    @Autowired
    public void PostsRepository(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(InternshipTasksApplication.class, args);



        for (int i=0; i<60; i++){
            long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
            long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

            Random random = new Random();

            Posts posts = new Posts((long) i, "Post"+ " " + i, "Content"+ " " + i, randomDate, random.nextBoolean(), random.nextBoolean());
            postsRepository.save(posts);
        }

    }



}
