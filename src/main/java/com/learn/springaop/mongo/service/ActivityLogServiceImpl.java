package com.learn.springaop.mongo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.springaop.mongo.entity.ActivityLog;
import com.learn.springaop.mongo.repository.ActivityLogRepository;

@Service

public class ActivityLogServiceImpl implements ActivityLogService {

	private final ActivityLogRepository repository;

	public ActivityLogServiceImpl(ActivityLogRepository repository) {

		this.repository = repository;

	}

	@Override

	public ActivityLog save(ActivityLog log) {

		return repository.save(log);

	}

	@Override

	public List<ActivityLog> getAll() {

		return repository.findAll();

	}

	@Override

	public void delete(String id) {

		repository.deleteById(id);

	}

}
