package org.example.database;

import com.zaxxer.hikari.HikariDataSource;
import org.jooq.ConnectionProvider;
import org.jooq.impl.DataSourceConnectionProvider;

public class ConnectionPool {

    public static final Object CONNECTION_PROVIDER_LOCK = new Object();

    public static final int MAX_POOL_SIZE = 256;

    private static ConnectionProvider connectionProvider;

    public static ConnectionProvider getConnectionProvider() {
        synchronized (CONNECTION_PROVIDER_LOCK) {
            if (connectionProvider == null) {
                try {
                    HikariDataSource hikariDataSource = new HikariDataSource();
                    //TODO:: Environment variables
                    hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
                    hikariDataSource.setUsername("postgres");
                    hikariDataSource.setPassword("postgres");
                    hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);
                    hikariDataSource.setConnectionTimeout(10000); //10s
                    hikariDataSource.setIdleTimeout(120000); // 2m
                    hikariDataSource.setMaxLifetime(1800000); // 30m
                    hikariDataSource.setLeakDetectionThreshold(30000); // 30s
                    connectionProvider = new DataSourceConnectionProvider(hikariDataSource);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return connectionProvider;
        }
    }

    /**
     * This method is only for testing purposes
     * @param newConnectionProvider
     * @return
     */
    public static void setProvider(ConnectionProvider newConnectionProvider) {
        connectionProvider = newConnectionProvider;
    }
}
