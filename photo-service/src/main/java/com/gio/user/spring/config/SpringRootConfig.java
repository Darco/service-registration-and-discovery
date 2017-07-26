package com.gio.user.spring.config;

import org.hsqldb.util.DatabaseManagerSwing;

//@ComponentScan({ "com.gio.user" })
//@Configuration
public class SpringRootConfig {

	//@Autowired
	//DataSource dataSource;

	//@Bean
	//public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
	//	return new NamedParameterJdbcTemplate(dataSource);
	//}

	//@PostConstruct
	public void startDBManager() {
		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
}
