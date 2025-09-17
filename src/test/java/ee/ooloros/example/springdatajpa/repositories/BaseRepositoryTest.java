package ee.ooloros.example.springdatajpa.repositories;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@ExtendWith(SpringExtension.class)
@Transactional
@Testcontainers
@ContextConfiguration(classes = { TestConfig.class })
public abstract class BaseRepositoryTest {

    @Container
    static PostgreSQLContainer<?> database =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("test")
                    .withInitScript("init.sql");

    @Test
    void contextLoads() {
        // nothing
    }

    @DynamicPropertySource
    static void props(DynamicPropertyRegistry r) {
        r.add("spring.datasource.url", database::getJdbcUrl);
        r.add("spring.datasource.username", database::getUsername);
        r.add("spring.datasource.password", database::getPassword);
        r.add("spring.jpa.hibernate.ddl-auto", () -> "create");
        r.add("spring.jpa.properties.hibernate.dialect", () -> "org.hibernate.dialect.PostgreSQLDialect");
    }
}
