package com.tikalk.usermeter.controllers;

import com.tikalk.usermeter.mongo.SlackPost;
import com.tikalk.usermeter.mongo.SlackPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.logging.Logger;

@RestController
public class SlackController {

    private final static Logger LOGGER = Logger.getLogger(SlackController.class.getName());

    @Autowired
    private SlackPostRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public void post(@RequestBody String body) throws IOException {
        Properties properties = new Properties();
        properties.load(new StringReader(body));
        LOGGER.info(String.format("Get Post request: body: %s", body));
        repository.save(new SlackPost(new Long(properties.getProperty("timestamp")), properties.getProperty("user_name"), properties.getProperty("channel_name"), properties.getProperty("text")));
    }
}
