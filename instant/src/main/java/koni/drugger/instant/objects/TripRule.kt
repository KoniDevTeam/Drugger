package koni.drugger.instant.objects

import java.util.*

data class TripRule (val drugID: Int, val dateAndTimeFrom: Array<Date>, val dose: Double, val doseUnit: String?, val period: Int, val periodUnit: String?)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TripRule

        if (drugID != other.drugID) return false
        if (!Arrays.equals(dateAndTimeFrom, other.dateAndTimeFrom)) return false
        if (dose != other.dose) return false
        if (doseUnit != other.doseUnit) return false
        if (period != other.period) return false
        if (periodUnit != other.periodUnit) return false

        return true
    }

    override fun hashCode(): Int {
        var result = drugID
        result = 31 * result + Arrays.hashCode(dateAndTimeFrom)
        result = 31 * result + dose.hashCode()
        result = 31 * result + (doseUnit?.hashCode() ?: 0)
        result = 31 * result + period
        result = 31 * result + (periodUnit?.hashCode() ?: 0)
        return result
    }
}