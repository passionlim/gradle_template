package cj.oshopping.user.config;

//@Configuration
//@EnableTransactionManagement
//@MapperScan("org.mybatis.spring.sample.mapper")
public class MallDataSourceConfiguration {
//
////	@Bean
//	public DataSource dataSource() {
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		return builder.setType(EmbeddedDatabaseType.HSQL).build();
//	}
//
////	@Bean public SqlSessionFactory sqlSessionFactory() {
////		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
////		factoryBean.setDataSource(dataSource());
//////		factoryBean.setConfigLocation("classpath:mybatis/config.xml");
////
////		return factoryBean.getObject();
////
////	}
//	
////	@Bean
//	public PlatformTransactionManager transactionManager() {
//	    DataSourceTransactionManager txManager = new DataSourceTransactionManager();
//	    txManager.setDataSource(dataSource());
//	    return txManager;
//	  }
	
}
