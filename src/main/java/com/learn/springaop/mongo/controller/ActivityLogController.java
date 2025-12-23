package com.learn.springaop.mongo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springaop.mongo.entity.ActivityLog;
import com.learn.springaop.mongo.service.ActivityLogService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Activity Log API", description = "MongoDB CRUD operations")
@RestController
@RequestMapping("/activity-logs")
public class ActivityLogController {

	private final ActivityLogService service;

	public ActivityLogController(ActivityLogService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ActivityLog> create(@RequestBody ActivityLog log) {
		return ResponseEntity.ok(service.save(log));
	}

	@GetMapping
	public ResponseEntity<List<ActivityLog>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok("Activity log deleted");
	}
}
