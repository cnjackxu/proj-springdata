package com.jacklab.springdata;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.druid.pool.DruidDataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjSpringdataApplicationTests {

	@Autowired
	private DataSource dsDruid;
//	private DataSource dataSource;
	
	@Test
	public void contextLoads() throws SQLException {
		System.out.println(dsDruid.getClass());
		System.out.println(dsDruid.getConnection().getCatalog());
		
		DruidDataSource druid = (DruidDataSource) dsDruid;
		
		System.out.println("druid init conn: " + druid.getInitialSize());
		System.out.println("druid max conn: " + druid.getMaxActive());
		
	}
}
