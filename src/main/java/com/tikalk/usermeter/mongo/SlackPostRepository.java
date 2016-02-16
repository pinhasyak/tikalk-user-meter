package com.tikalk.usermeter.mongo;

/**
 * Created by rans on 2/16/16.
 */
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SlackPostRepository extends MongoRepository<SlackPost, String> {
}
