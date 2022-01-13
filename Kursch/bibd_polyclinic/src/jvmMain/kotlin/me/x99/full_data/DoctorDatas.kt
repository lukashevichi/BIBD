package me.x99.full_data

import me.x99.database.DoctorTable
import me.x99.utils.toUUID
import org.jetbrains.exposed.sql.insert

fun DoctorTable.setData() {
    this.insert {
        it[id] = 1
        it[name] = "Виктор"
        it[surname] = "Славник"
        it[cabinet] = "403"
        it[telephone] = "+375173338921"
        it[departmentId] = 1
    }
    this.insert {
        it[id] = 2
        it[name] = "Виктор"
        it[surname] = "Кочевник"
        it[cabinet] = "401"
        it[telephone] = "+375173338921"
        it[departmentId] = 1
    }
    this.insert {
        it[id] = 3
        it[name] = "Виктор"
        it[surname] = "Травник"
        it[cabinet] = "402"
        it[telephone] = "+375173338921"
        it[departmentId] = 2
    }
    this.insert {
        it[id] = 4
        it[name] = "Виктор"
        it[surname] = "Саратов"
        it[cabinet] = "403"
        it[telephone] = "+375173338921"
        it[departmentId] = 3
    }
    this.insert {
        it[id] = 5
        it[name] = "Виктор"
        it[surname] = "Пятков"
        it[cabinet] = "403"
        it[telephone] = "+375173338921"
        it[departmentId] = 3
    }
}