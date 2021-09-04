package com.lessonone.lessonone.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//TODO Вот это все исправило
@EntityScan("com.lessonone.lessonone.bean")
public class LessononeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessononeApplication.class, args);
    }
}
