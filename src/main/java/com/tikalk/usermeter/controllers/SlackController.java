package com.tikalk.usermeter.controllers;

import com.tikalk.usermeter.mongo.SlackPost;
import com.tikalk.usermeter.mongo.SlackPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.util.logging.Logger;

@RestController
public class SlackController {

    private final static Logger LOGGER = Logger.getLogger(SlackController.class.getName());

    @Autowired
    private SlackPostRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public void post(@RequestParam(value = "user_name", required = false) String userName,
                     @RequestParam(value = "channel_name", required = false) String channelName,
                     @RequestParam(value = "text", required = false) String text) throws IOException {

        LOGGER.info(String.format("Insert params : user_name: %s, channel_name %s, text %s", userName, channelName, text));

        repository.save(new SlackPost(System.currentTimeMillis(), userName, channelName, text));
    }
}
