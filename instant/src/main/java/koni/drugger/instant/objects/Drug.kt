package koni.drugger.instant.objects

import java.util.Date

data class Drug (val drugName: String, val drugID: Int, val dateAndTime: Date, val dose: Int , val doseUnit: String?)