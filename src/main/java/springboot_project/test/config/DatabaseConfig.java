package springboot_project.test.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

        @Bean(name = "dbService")
        @ConfigurationProperties(prefix = "spring.dbService")
        @Primary
        public DataSource createDataSource() {
            return DataSourceBuilder.create().build();
        }

        @Bean(name = "jdbcService")
        @Autowired
        public JdbcTemplate createJdbcTemplate_Service(@Qualifier("dbService") DataSource productServiceDS) {
            return new JdbcTemplate(productServiceDS);
        }

}
