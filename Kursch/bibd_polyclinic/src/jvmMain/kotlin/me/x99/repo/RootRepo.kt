package me.x99.repo

import me.x99.database.RootTable
import model.Root
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class RootRepo {
    suspend fun create(root: Root) {
        transaction {
            RootTable.insert {
                it[id] = UUID.randomUUID().hashCode()
                it[address] = root.address
                it[telephone] = root.telephone
                it[polyclinicName] = root.polyclinicName
            }
        }
    }

    suspend fun getAll(): List<Root> {
        return transaction {
            RootTable.selectAll().map {
                it.toPatient()
            }
        }
    }

    suspend fun get(id: Int): Root? {
        return transaction {
            RootTable.select { RootTable.id eq id }.map {
                it.toPatient()
            }.firstOrNull()
        }
    }

    private fun ResultRow.toPatient(): Root {
        return Root(
            id = this[RootTable.id].value,
            address = this[RootTable.address],
            telephone = this[RootTable.telephone],
            polyclinicName = this[RootTable.polyclinicName],
        )
    }
}