package com.tikalk.usermeter.mongo;

/**
 * Created by rans on 2/16/16.
 */
import org.springframework.data.annotation.Id;

import java.util.logging.Logger;


public class SlackPost {
    private final static Logger LOGGER = Logger.getLogger(SlackPost.class.getName());
    @Id
    private String id;
    private Long timestamp;
    private String user;
    private String channel;
    private String text;

    public SlackPost(Long timestamp, String user, String channel, String text) {
        this.timestamp = timestamp;
        this.user = user;
        this.channel = channel;
        this.text = text;

    }

    @Override
    public String toString() {
        return "SlackPost{" +
                "timestamp=" + timestamp +
                ", user='" + user + '\'' +
                ", channel='" + channel + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
