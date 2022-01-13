package me.x99.full_data

import me.x99.database.DepartmentTable
import me.x99.utils.toUUID
import org.jetbrains.exposed.sql.insert

fun DepartmentTable.setData() {
    this.insert {
        it[id] = 1
        it[specialization] = "Херургия"
        it[telephone] = "+3751799982721"
    }
    this.insert {
        it[id] = 2
        it[specialization] = "Травмотология"
        it[telephone] = "+3751799982721"
    }
    this.insert {
        it[id] = 3
        it[specialization] = "Неврология"
        it[telephone] = "+3751799982721"
    }
    this.insert {
        it[id] = 4
        it[specialization] = "Терапевтическое отделение"
        it[telephone] = "+3751799982721"
    }
    this.insert {
        it[id] = 5
        it[specialization] = "Женская консультация"
        it[telephone] = "+3751799982721"
    }
}