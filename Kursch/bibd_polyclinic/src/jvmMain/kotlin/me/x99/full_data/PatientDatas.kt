package me.x99.full_data

import me.x99.database.PatientTable
import org.jetbrains.exposed.sql.insert

fun PatientTable.setData() {
    this.insert {
        it[id] = 1
//        it[login] = "root@root.com"
//        it[psw] = "root"
        it[name] = "Владислав"
        it[surname] = "Котиков"
    }
    this.insert {
        it[id] = 2
//        it[login] = "vlad@root.com"
//        it[psw] = "root"
        it[name] = "Владислав"
        it[surname] = "Бубликов"
    }
    this.insert {
        it[id] = 3
//        it[login] = "vlad2@root.com"
//        it[psw] = "root"
        it[name] = "Владислав"
        it[surname] = "Славиков"
    }
    this.insert {
        it[id] = 4
//        it[login] = "vlad3@root.com"
//        it[psw] = "root"
        it[name] = "Владислав"
        it[surname] = "Радужников"
    }
    this.insert {
        it[id] = 5
//        it[login] = "vlad4@root.com"
//        it[psw] = "root"
        it[name] = "Владислав"
        it[surname] = "Святославников"
    }
}