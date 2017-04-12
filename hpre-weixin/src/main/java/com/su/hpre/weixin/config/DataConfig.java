package com.su.hpre.weixin.config;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

/**
*	2017年4月5日 下午10:21:43
*	@author	husu
*/

public class DataConfig {
	
	@Bean
	public DataSource dataSoure() {
		return new BasicDataSource()
				.setDriverClassName("");
				 
	}
}
