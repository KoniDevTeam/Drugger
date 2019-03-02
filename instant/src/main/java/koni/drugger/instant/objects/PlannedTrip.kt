package koni.drugger.instant.objects

import java.util.*

data class PlannedTrip (val drugID: Int, val dateAndTime: Array<Date>, val dose: Double, val doseUnit: String?, val tripped: Boolean, val skip: Boolean)  {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PlannedTrip

        if (drugID != other.drugID) return false
        if (!Arrays.equals(dateAndTime, other.dateAndTime)) return false
        if (dose != other.dose) return false
        if (doseUnit != other.doseUnit) return false
        if (tripped != other.tripped) return false
        if (skip != other.skip) return false

        return true
    }

    override fun hashCode(): Int {
        var result = drugID
        result = 31 * result + Arrays.hashCode(dateAndTime)
        result = 31 * result + dose.hashCode()
        result = 31 * result + (doseUnit?.hashCode() ?: 0)
        result = 31 * result + tripped.hashCode()
        result = 31 * result + skip.hashCode()
        return result
    }
}