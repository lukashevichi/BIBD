package by.maxluxs.polyc.ui.info.domain

import by.maxluxs.polyc.domain.model.Doctor
import model.Department

data class InfoModel(
    val doctors: List<Doctor>,
    val departments: List<Department>,
)