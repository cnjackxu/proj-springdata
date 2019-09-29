package com.jacklab.springdata.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

	@Bean
	public ConfigurationCustomizer configurationCustomizer() {
		return new ConfigurationCustomizer() {
			
			@Override
			public void customize(org.apache.ibatis.session.Configuration configuration) {
				// map table column name with _ to Camel format in java obj
				configuration.setMapUnderscoreToCamelCase(true);
			}
		};
	}
}
