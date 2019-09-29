package com.jacklab.springdata.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jacklab.springdata.domain.Department;
import com.jacklab.springdata.mapper.DepartmentMapper;

@MapperScan(basePackages = "com.jacklab.springdata.mapper")
@RestController
public class MybatisController {

	@Autowired
	DepartmentMapper departmentMapper;
	
	@GetMapping("/dept/{id}")
	public Department getDept(@PathVariable("id") Integer id) {
		return departmentMapper.getDeptById(id);
	}
	
}
