package me.x99.full_data

import me.x99.database.RootTable
import org.jetbrains.exposed.sql.insert

fun RootTable.setData() {
    this.insert {
        it[RootTable.id] = 1
        it[RootTable.address] = "ул. Федукова д.48 к1"
        it[RootTable.telephone] = "+375172989999"
        it[RootTable.polyclinicName] = "245 Городская клиническая поликлиника"
    }
}