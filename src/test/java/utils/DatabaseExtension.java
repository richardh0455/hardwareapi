package utils;

import com.zaxxer.hikari.HikariDataSource;
import org.example.database.ConnectionPool;
import org.example.database.JooqConfiguration;
import org.flywaydb.core.Flyway;
import org.jooq.impl.DataSourceConnectionProvider;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.testcontainers.containers.PostgreSQLContainer;

public class DatabaseExtension implements BeforeEachCallback, InvocationInterceptor {

    public static final String POSTGRES_IMAGE = "postgres:15.2";
    public static final String POSTGRES_USERNAME = "postgres";

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        ensureDatabaseIsRunning();
    }

    protected static HikariDataSource dataSource;
    private static Object databaseStartupLock = new Object();

    private void ensureDatabaseIsRunning() {
        if(dataSource == null) {
            synchronized (databaseStartupLock) {
                if(dataSource == null) {
                    //TODO:: Environment variables
                    PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(POSTGRES_IMAGE)
                            .withUsername("postgres");
                    postgreSQLContainer.start();
                    String jdbcUrl = postgreSQLContainer.getJdbcUrl();
                    String password = postgreSQLContainer.getPassword();
                    migrateDatabase(jdbcUrl, POSTGRES_USERNAME, password);

                    dataSource = new HikariDataSource();
                    dataSource.setJdbcUrl(jdbcUrl);
                    dataSource.setUsername(POSTGRES_USERNAME);
                    dataSource.setPassword(password);
                    ConnectionPool.setProvider(new DataSourceConnectionProvider(dataSource));
                    JooqConfiguration.clear();
                }
            }

        }
    }
    public void migrateDatabase(String url, String username, String password) {
        Flyway flyway = Flyway.configure()
                .dataSource(url, username, password)
                .table("tb_schema")
                .locations("classpath:db/migration")
                .outOfOrder(true)
                .load();
        flyway.migrate();
    }
}
