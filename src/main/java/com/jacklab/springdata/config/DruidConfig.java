package com.jacklab.springdata.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;


/**
 * Customized DataSource
 * Druid didn't inject basic properties, so need to set them up manually
 * @author jack
 *
 */

/*
 * Comment if not using `druid` profile
 */
//@Configuration
public class DruidConfig {

	@Value("${druid.monitor.loginUsername}")
	private String loginUsername;
	@Value("${druid.monitor.loginPassword}")
	private String loginPassword;
	@Value("${druid.monitor.allow}")
	private String allow;
	
	
	/*
	 * @Value("${spring.datasource.url}") String url;
	 * 
	 * // use FQN to avoid conflict with sys env ${username}
	 * 
	 * @Value("${spring.datasource.username}") String username;
	 * 
	 * @Value("${spring.datasource.password}") String password;
	 * 
	 * @Value("${spring.datasource.driver-class-name}") String driverClassName;
	 * 
	 * @Bean
	 * 
	 * @Qualifier("dsDruid") public DataSource getDruidDataSource() {
	 * DruidDataSource ds = new DruidDataSource(); ds.setUsername(username);
	 * ds.setPassword(password); ds.setUrl(url);
	 * ds.setDriverClassName(driverClassName); return ds; }
	 */
	
//	public String getLoginUsername() {
//		return loginUsername;
//	}
//
//	public void setLoginUsername(String loginUsername) {
//		this.loginUsername = loginUsername;
//	}
//
//	public String getLoginPassword() {
//		return loginPassword;
//	}
//
//	public void setLoginPassword(String loginPassword) {
//		this.loginPassword = loginPassword;
//	}
//
//	public String getAllow() {
//		return allow;
//	}
//
//	public void setAllow(String allow) {
//		this.allow = allow;
//	}

	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	@Qualifier("dsDruid")
	public DataSource getDruidDataSource() {
		return new DruidDataSource();
	}
	
	// register Stat Servlet
	@Bean
	public ServletRegistrationBean<StatViewServlet> statViewServlet(){
		ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(), "/druid/*");
		Map<String, String> initParameters = new HashMap<>();
		initParameters.put("loginUserName", loginUsername);
		initParameters.put("allow", allow);
		initParameters.put("loginPassword", loginPassword);
		bean.setInitParameters(initParameters);
		return bean;
	}
	
	// set filter
	@Bean
	public FilterRegistrationBean<WebStatFilter> webStatFilter(){
		FilterRegistrationBean<WebStatFilter> filter = new FilterRegistrationBean<WebStatFilter>(new WebStatFilter());
		filter.setUrlPatterns(Arrays.asList("/*"));
		return filter;
	}
}
