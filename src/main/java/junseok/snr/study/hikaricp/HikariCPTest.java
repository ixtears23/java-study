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
        log.info(">>>>> Process Running");
        final String command = scanner.next();

        connectionIfCommandConnection(command);
        queryIfCommandQuery(command);
        endIfCommandEnd(command);
    }

    private static void endIfCommandEnd(String command) {
        if (command.equals(Status.END.name())) {
            status = Status.END;
            log.info(">>>>> Process End");
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
                    Thread.sleep(2000);
                    con.isValid(1);
                    statement.setQueryTimeout(10);
                    processQuery(statement);

                } catch (Exception exception) {
                    log.error(">>>>> QUERY Statement Exception", exception);
                }
                return 0;
            });

        }
    }

    private static void processQuery(Statement statement) {
        final String sql = "SELECT * FROM users a, users b\n" +
                "WHERE a.ip_address LIKE '%1%'\n" +
                " AND b.last_name LIKE '%a%'\n" +
                " AND a.first_name LIKE '%a%';";

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
        config.setJdbcUrl("jdbc:mariadb://localhost:13400/dev");
        config.setUsername("root");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("preStmtCacheSqlLimit", 2048);

        config.setMinimumIdle(5);
        config.setMaximumPoolSize(10);
        config.setConnectionTimeout(3000000);
        config.setIdleTimeout(10000);
        config.setValidationTimeout(30001);
        config.setMaxLifetime(60000);

        final String connectionTestQuery = "SELECT 1";

        config.setConnectionTestQuery(connectionTestQuery);
        return config;
    }

}
