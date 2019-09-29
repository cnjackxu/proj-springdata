package com.jacklab.springdata.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jacklab.springdata.domain.Department;

//@Mapper
public interface DepartmentMapper {

	@Select("select * from department where id=#{id}")
	public Department getDeptById(Integer id);
	
	@Delete("delete from department where id=#{id}")
	public int deleteDeptById(Integer id);
	
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into department(departmentName) values(#{deptName})")
	public int insertDept(String deptName);
	
	@Update("update department set departmentName=#{deptName} where id=#{id}")
	public int updateDept(String deptName);
}
