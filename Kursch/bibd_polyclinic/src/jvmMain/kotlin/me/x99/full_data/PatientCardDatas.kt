package me.x99.full_data

import me.x99.database.AppointmentTable
import me.x99.database.DiagnosisTable
import me.x99.database.PatientCardTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.insert

fun PatientCardTable.setData() {
    this.insert {
        it[id] = 1
        it [number] = "123"
        it [address] = "ул.Любимая"
        it [telephone] = "+375179992311"
        it [dateOfEstablishment] = "28.12.1998"
        it [diagnosisId] = 1
    }
    this.insert {
        it[id] = 2
        it [number] = "124"
        it [address] = "ул.Любимая"
        it [telephone] = "+375179992311"
        it [dateOfEstablishment] = "28.12.1998"
        it [diagnosisId] = 3
    }
    this.insert {
        it[id] = 3
        it [number] = "125"
        it [address] = "ул.Любимая"
        it [telephone] = "+375179992311"
        it [dateOfEstablishment] = "28.12.1998"
        it [diagnosisId] = 1
    }
    this.insert {
        it[id] = 4
        it [number] = "126"
        it [address] = "ул.Любимая"
        it [telephone] = "+375179992311"
        it [dateOfEstablishment] = "28.12.1998"
        it [diagnosisId] = 2
    }
    this.insert {
        it[id] = 5
        it [number] = "127"
        it [address] = "ул.Любимая"
        it [telephone] = "+375179992311"
        it [dateOfEstablishment] = "28.12.1998"
        it [diagnosisId] = 1
    }
}