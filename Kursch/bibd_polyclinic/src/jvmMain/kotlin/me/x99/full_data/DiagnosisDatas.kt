package me.x99.full_data

import me.x99.database.DiagnosisTable
import me.x99.utils.toUUID
import org.jetbrains.exposed.sql.insert

fun DiagnosisTable.setData() {
    this.insert {
        it[id] = 1
        it[name] = "Альцгеймер"
    }
    this.insert {
        it[id] = 2
        it[name] = "Коронавирус"
    }
    this.insert {
        it[id] = 3
        it[name] = "Простуда"
    }
    this.insert {
        it[id] = 4
        it[name] = "Малерия"
    }
    this.insert {
        it[id] = 5
        it[name] = "Грип"
    }
}