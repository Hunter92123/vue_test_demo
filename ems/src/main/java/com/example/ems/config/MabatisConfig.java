package com.example.ems.config;

import org.apache.ibatis.logging.nologging.NoLoggingImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
class MybatisConfig {

	@Value("${mybatis.mapper-locations}")
	private String mapperLocations;

	@Bean
	public SqlSessionFactoryBean configSqlSessionFactoryBean(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		// configuration.setLogImpl(StdOutImpl.class);
		configuration.setLogImpl(NoLoggingImpl.class);
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setCallSettersOnNulls(true);

		sqlSessionFactoryBean.setConfiguration(configuration);
		sqlSessionFactoryBean.setDataSource(dataSource);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
		return sqlSessionFactoryBean;
	}

}
