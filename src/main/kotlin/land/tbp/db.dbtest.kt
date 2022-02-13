package land.tbp.land.tbp

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import liquibase.Contexts
import liquibase.LabelExpression
import liquibase.Liquibase
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor


fun main() {
    migrateDatabase()


}

fun migrateDatabase() {
    val config = HikariConfig()
    config.driverClassName = "org.sqlite.JDBC"
    config.jdbcUrl = "jdbc:sqlite:zzzz.sqlite"
    config.connectionTestQuery = "SELECT 1"
    config.maxLifetime = 60000 // 60 Sec
    config.idleTimeout = 45000 // 45 Sec
    config.maximumPoolSize = 10

    val ds = HikariDataSource(config)

    Liquibase("db/db.changelog.yaml", ClassLoaderResourceAccessor(), JdbcConnection(ds.connection))
//        .
        .update(Contexts(), LabelExpression())
}
