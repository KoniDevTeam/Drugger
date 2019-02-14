package koni.drugger.instant.objects

import java.util.*

data class Drug (val drugName: String, val drugID: Int, val dateAndTime: Array<Date>, val dose: Double , val doseUnit: String?, val repeat: String?) // repeat - number + h/d/w/m/y (hour, day, week, month, year)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Drug

        if (drugName != other.drugName) return false
        if (drugID != other.drugID) return false
        if (!Arrays.equals(dateAndTime, other.dateAndTime)) return false
        if (dose != other.dose) return false
        if (doseUnit != other.doseUnit) return false
        if (repeat != other.repeat) return false

        return true
    }

    override fun hashCode(): Int {
        var result = drugName.hashCode()
        result = 31 * result + drugID
        result = 31 * result + Arrays.hashCode(dateAndTime)
        result = 31 * result + dose.hashCode()
        result = 31 * result + (doseUnit?.hashCode() ?: 0)
        result = 31 * result + (repeat?.hashCode() ?: 0)
        return result
    }


}