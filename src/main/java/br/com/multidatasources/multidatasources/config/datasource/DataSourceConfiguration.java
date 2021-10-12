package br.com.multidatasources.multidatasources.config.datasource;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public interface DataSourceConfiguration {

    String getPoolName();

    int getMaximumPoolSize();

    default HikariDataSource definePoolDataSourceConnection(DataSource dataSource) {
        return new HikariDataSource(hikariConfig(dataSource));
    }

    private HikariConfig hikariConfig(DataSource dataSource) {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setPoolName(getPoolName());
        hikariConfig.setMaximumPoolSize(getMaximumPoolSize());
        hikariConfig.setDataSource(dataSource);
        hikariConfig.setAutoCommit(false);

        return hikariConfig;
    }

}