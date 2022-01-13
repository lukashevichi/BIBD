package me.x99.full_data

import me.x99.database.AppointmentTable
import me.x99.database.PatientTable
import me.x99.utils.toUUID
import org.jetbrains.exposed.sql.insert

fun PatientTable.setData() {
    this.insert {
        it[id] = 1
        it[name] = "Владислав"
        it[surname] = "Котиков"
    }
    this.insert {
        it[id] = 2
        it[name] = "Владислав"
        it[surname] = "Бубликов"
    }
    this.insert {
        it[id] = 3
        it[name] = "Владислав"
        it[surname] = "Славиков"
    }
    this.insert {
        it[id] = 4
        it[name] = "Владислав"
        it[surname] = "Радужников"
    }
    this.insert {
        it[id] = 5
        it[name] = "Владислав"
        it[surname] = "Святославников"
    }
}