package junseok.snr.study.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HikariCPTest {

    public static void main(String[] args) throws SQLException {
        final HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mariadb://localhost:13300/test_db");
        config.setUsername("root");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("preStmtCacheSqlLimit", 2048);

        config.setConnectionTimeout(251);
        config.setIdleTimeout(0);
        config.setValidationTimeout(250);
        config.setConnectionTestQuery("SELECT 1");

        final HikariDataSource datasource = new HikariDataSource(config);
        final Connection connection = datasource.getConnection();
        final Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        final ResultSet resultSet = statement.executeQuery("SELECT * FROM users a, users b, users c, users d");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + ", " + resultSet.getString("first_name"));
        }

        resultSet.close();
        statement.close();
        connection.close();
        datasource.close();

    }
}
