package junseok.snr.study.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class HikariCPTest {
    enum Status {
        RUNNING,
        QUERY,
        CONNECTION,
        END
    }

    private static final Logger log = LoggerFactory.getLogger(HikariCPTest.class);
    private static final HikariDataSource DATA_SOURCE = createDataSource(getHikariConfig());
    private static Status status = Status.RUNNING;

    public static void main(String[] args) throws InterruptedException {
        final Scanner scanner = new Scanner(System.in);

        Thread.sleep(1000);

        while (status == Status.RUNNING) {
            process(scanner);
        }
        DATA_SOURCE.close();
    }

    private static void process(Scanner scanner) {
        log.info(">>>>> command : ");
        final String command = scanner.next();

        connectionIfCommandConnection(command);
        queryIfCommandQuery(command);
        endIfCommandEnd(command);
    }

    private static void endIfCommandEnd(String command) {
        if (command.equals(Status.END.name())) {
            status = Status.END;
        }
    }

    private static void connectionIfCommandConnection(String command) {
        if (command.equals(Status.CONNECTION.name())) {
            try (Connection connection = DATA_SOURCE.getConnection()) {
                log.info(">>>>> getConnection ::: {}", connection);
            } catch (Exception exception) {
                log.error(">>>>> CONNECTION Exception", exception);
            }
        }
    }

    private static void queryIfCommandQuery(String command) {
        if (command.equals(Status.QUERY.name())) {
            CompletableFuture.supplyAsync(() -> {
                try (final Connection con = DATA_SOURCE.getConnection();
                     final Statement statement = con.createStatement()) {
                    statement.setQueryTimeout(5);
                    processQuery(statement);

                } catch (Exception exception) {
                    log.error(">>>>> QUERY Statement Exception", exception);
                }
                return 0;
            });

        }
    }

    private static void processQuery(Statement statement) {
        final String sql = "SELECT * FROM users a, users b";

        try (final ResultSet resultSet = statement.executeQuery(sql)) {
            log.info(">>>>> QUERY Print ::: {}", resultSet.next());
        } catch (Exception exception) {
            log.error(">>>>> QUERY ResultSet Exception", exception);
        }
    }

    private static HikariDataSource createDataSource(HikariConfig config) {
        return new HikariDataSource(config);
    }

    private static HikariConfig getHikariConfig() {
        final HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mariadb://localhost:13300/test_db");
        config.setUsername("root");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("preStmtCacheSqlLimit", 2048);

        config.setMinimumIdle(1);
        config.setMaximumPoolSize(3);
        config.setConnectionTimeout(250);
        config.setIdleTimeout(0);
        config.setValidationTimeout(251);
        config.setMaxLifetime(300000);

        final String connectionTestQuery = "SELECT * FROM users a, users b\n" +
                "WHERE a.first_name LIKE 'a%'";

        config.setConnectionTestQuery(connectionTestQuery);
        return config;
    }

}
