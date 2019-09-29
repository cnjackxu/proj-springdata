package com.jacklab.springdata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/list")
	public List<Map<String, Object>> listDept() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
		return list;
	}
}
