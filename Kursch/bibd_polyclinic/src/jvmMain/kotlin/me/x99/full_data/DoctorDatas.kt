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
    this.insert {
        it[id] = 6
        it[name] = "Анатолий"
        it[surname] = "Сурга"
        it[cabinet] = "101"
        it[telephone] = "+375171138921"
        it[departmentId] = 4
    }
    this.insert {
        it[id] = 7
        it[name] = "Нина"
        it[surname] = "Сюта"
        it[cabinet] = "212"
        it[telephone] = "+375173448921"
        it[departmentId] = 1
    }
    this.insert {
        it[id] = 8
        it[name] = "Слабая"
        it[surname] = "Урбана"
        it[cabinet] = "506"
        it[telephone] = "+375173300921"
        it[departmentId] = 3
    }
    this.insert {
        it[id] = 9
        it[name] = "Дария"
        it[surname] = "Наша"
        it[cabinet] = "213"
        it[telephone] = "+375173398921"
        it[departmentId] = 5
    }
    this.insert {
        it[id] = 10
        it[name] = "Сулия"
        it[surname] = "Стручков"
        it[cabinet] = "105"
        it[telephone] = "+375173338921"
        it[departmentId] = 2
    }
    this.insert {
        it[id] = 11
        it[name] = "Краков"
        it[surname] = "Сучков"
        it[cabinet] = "409"
        it[telephone] = "+375173338921"
        it[departmentId] = 2
    }
}