package com.spf.euraka_client.config.db;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.atomikos.jdbc.AtomikosSQLException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

	@Bean("dbConfig")
	@ConfigurationProperties(prefix = "spring.db")
	public DbConfig getDbConfig() {
		DbConfig config = new DbConfig();
	    return config;
	}

//	@Bean(name="masterSourceBean",initMethod="init",destroyMethod="close")
//	public AtomikosDataSourceBean masterSourceBean(@Qualifier("dbConfig") DbConfig dbConfig) throws Exception{
//		AtomikosDataSourceBean db = dataSourceConfig();
//		db.setUniqueResourceName("dataSource");
//		Properties prop = new Properties();
//		prop.put("URL", dbConfig.getUrl());
//		prop.put("user", dbConfig.getUsername());
//		prop.put("password", dbConfig.getPassword());
//		db.setXaProperties(prop);
//		return db;
//	}
//
//	private AtomikosDataSourceBean dataSourceConfig() throws SQLException {
//		AtomikosDataSourceBean datasource = new AtomikosDataSourceBean();
//		datasource.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
//		//datasource.setPoolSize(10);
//		datasource.setMinPoolSize(1);
//		datasource.setMaxPoolSize(10000);
//		datasource.setReapTimeout(60);
//		datasource.setBorrowConnectionTimeout(60);
//		datasource.setReapTimeout(20);
//		datasource.setMaxIdleTime(60);
//		datasource.setMaintenanceInterval(60);
//		datasource.setLoginTimeout(60);
//		datasource.setTestQuery("SELECT 1");
//		return datasource;
//	}
//
//	@Bean("masterDb")
//	public TransactionAwareDataSourceProxy dataSource(@Qualifier("masterSourceBean") AtomikosDataSourceBean db) throws AtomikosSQLException{
//		TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(db);
//		return proxy;
//	}

//		@Bean("db1Config")
//	@ConfigurationProperties(prefix = "spring.db1")
//	public DbConfig getDb2Config() {
//		return new DbConfig();
//	}

	//	    @Bean("go2Db")
//	public TransactionAwareDataSourceProxy go2Db(@Qualifier("db1Config") DbConfig db1Config) throws SQLException{
//		AtomikosDataSourceBean db = dataSourceConfig();
//		db.setUniqueResourceName("go2Db");
//		Properties prop = new Properties();
//		prop.put("URL", db1Config.getUrl());
//		prop.put("user", db1Config.getUsername());
//		prop.put("password", db1Config.getPassword());
//		db.setXaProperties(prop);
//		db.init();
//		TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(db);
//		return proxy;
//	}
}
