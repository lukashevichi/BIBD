package me.x99.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import me.x99.full_data.setData
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init() {
        Database.connect(hikari())
        transaction {
            SchemaUtils.create(AppointmentTable)
            SchemaUtils.create(DiagnosisTable)
            SchemaUtils.create(PatientTable)
            SchemaUtils.create(DepartmentTable)
            SchemaUtils.create(DoctorTable)
            SchemaUtils.create(PatientCardTable)
            SchemaUtils.create(RootTable)

            DepartmentTable.setData()
            DoctorTable.setData()
            PatientTable.setData()
            DiagnosisTable.setData()
            PatientCardTable.setData()
            AppointmentTable.setData()
            RootTable.setData()
        }
    }

    /**
     * Look at hikari.properties and change accordingly
     * */
    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.h2.Driver"
        config.jdbcUrl = "jdbc:h2:mem:test"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }
}