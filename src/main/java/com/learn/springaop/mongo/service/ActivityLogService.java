package com.learn.springaop.mongo.service;

import java.util.List;

import com.learn.springaop.mongo.entity.ActivityLog;

public interface ActivityLogService {

	ActivityLog save(ActivityLog log);

	List<ActivityLog> getAll();

	void delete(String id);

}
