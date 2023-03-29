package org.example.database;


import org.jooq.Configuration;
import org.jooq.ConnectionProvider;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.conf.SettingsTools;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.ThreadLocalTransactionProvider;

public class JooqConfiguration {

    private static final Object lock = new Object();
    private static Configuration jooqConfiguration = null;

    public static Configuration get() {
        synchronized (lock) {
            if (jooqConfiguration == null) {
                final ConnectionProvider connectionProvider = ConnectionPool.getConnectionProvider();
                jooqConfiguration = new DefaultConfiguration()
                    .set(connectionProvider)
                    .set(SQLDialect.POSTGRES)
                    .set(new ThreadLocalTransactionProvider(connectionProvider, true))
                    .set(defaultSettings());
            }
            return jooqConfiguration;
        }
    }
    public static void clear() {
        synchronized (lock) {
            jooqConfiguration = null;
        }
    }

    private static Settings defaultSettings() {
        return SettingsTools.defaultSettings().withReturnAllOnUpdatableRecord(true);
    }
}
