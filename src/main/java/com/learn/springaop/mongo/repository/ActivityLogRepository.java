package com.learn.springaop.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.springaop.mongo.entity.ActivityLog;

public interface ActivityLogRepository extends MongoRepository<ActivityLog, String> {

}
