package com.tikalk.usermeter;

import com.tikalk.usermeter.mongo.SlackPost;
import com.tikalk.usermeter.mongo.SlackPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private SlackPostRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
    @Override
    public void run(String... args) throws Exception {
        // read data from slack

        //write to mongo
        repository.save(new SlackPost(new Date().getTime(), "JSmith", "general", "this is my message"));

    }
}
