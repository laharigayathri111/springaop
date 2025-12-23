package com.learn.springaop.mongo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activity_logs")

public class ActivityLog {

	@Id

	private String id;

	private String action;

	private String entity;

	private String details;

	private LocalDateTime timestamp;

	public ActivityLog() {

		this.timestamp = LocalDateTime.now();

	}

	public ActivityLog(String action, String entity, String details) {

		this.action = action;

		this.entity = entity;

		this.details = details;

		this.timestamp = LocalDateTime.now();

	}

	public String getId() {

		return id;

	}

	public String getAction() {

		return action;

	}

	public String getEntity() {

		return entity;

	}

	public String getDetails() {

		return details;

	}

	public LocalDateTime getTimestamp() {

		return timestamp;

	}

	public void setAction(String action) {

		this.action = action;

	}

	public void setEntity(String entity) {

		this.entity = entity;

	}

	public void setDetails(String details) {

		this.details = details;

	}

}
